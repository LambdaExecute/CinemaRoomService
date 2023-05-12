package cinema.services;

import cinema.models.PurchaseResponse;
import cinema.models.ReturnResponse;
import cinema.models.StatisticsResponse;
import cinema.models.Ticket;
import cinema.repositories.SeatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TicketsService
{
    private SeatsRepository seatsRepository;

    public TicketsService(SeatsRepository seatsRepository)
    {
        this.seatsRepository = seatsRepository;
    }

    public PurchaseResponse Purchase(int row, int column)
    {
        if(row < 0 || row >= seatsRepository.rows || column < 0 || column >= seatsRepository.columns)
            throw new RuntimeException("The number of a row or a column is out of bounds!");

        Ticket ticket = seatsRepository.GetSeat(row, column);
        if(ticket == null)
            throw new RuntimeException("The ticket has been already purchased!");

        seatsRepository.TryRemove(ticket);

        String token = UUID.randomUUID().toString();

        seatsRepository.MakeTicketRecord(token, ticket);

        return new PurchaseResponse(token, ticket);
    }

    public ReturnResponse ReturnTicket(String token)
    {
        if(token == null)
            throw new RuntimeException("Wrong token!");

        if(!seatsRepository.Contains(token))
            throw new RuntimeException("Wrong token!");

        Ticket ticket = seatsRepository.GetTicketRecord(token);
        seatsRepository.Add(ticket);
        seatsRepository.RemoveTicketRecord(token);

        return new ReturnResponse(ticket);
    }

    public StatisticsResponse CollectStatistics()
    {
        int income = 0;
        for (Ticket ticket : seatsRepository.tickets.values()) {
            income += ticket.price;
        }
        return new StatisticsResponse(
                income,
                seatsRepository.availableSeats.stream().count(),
                seatsRepository.tickets.values().stream().count()
        );
    }
}
