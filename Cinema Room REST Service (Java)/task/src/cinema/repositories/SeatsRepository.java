package cinema.repositories;

import cinema.models.Seats;
import cinema.models.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Repository
public class SeatsRepository
{
    public int rows;
    public int columns;
    public List<Ticket> availableSeats = new ArrayList<>();
    public Hashtable<String, Ticket> tickets = new Hashtable<>();

    public SeatsRepository()
    {
        rows = 9;
        columns = 9;
        for(int r = 1; r <= rows; r++)
            for(int c = 1; c <= columns; c++)
                availableSeats.add(new Ticket(r, c, r <= 4 ? 10 : 8));
    }

    public Ticket GetSeat(int row, int column)
    {
        for (Ticket seat : availableSeats) {
            if(seat.column == column && seat.row == row)
                return seat;
        }
        return null;
    }

    public void Add(Ticket seat)
    {
        availableSeats.add(seat);
    }

    public void TryRemove(Ticket seat)
    {
        if(availableSeats.contains(seat))
            availableSeats.remove(seat);
    }
    public void MakeTicketRecord(String token, Ticket ticket)
    {
        tickets.put(token, ticket);
    }

    public boolean Contains(String token)
    {
        return tickets.containsKey(token);
    }

    public void RemoveTicketRecord(String token)
    {
        tickets.remove(token);
    }

    public Ticket GetTicketRecord(String token)
    {
        return tickets.get(token);
    }
}
