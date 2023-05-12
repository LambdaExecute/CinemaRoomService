package cinema.services;

import cinema.models.Seats;
import cinema.repositories.SeatsRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatsService
{
    private SeatsRepository seatsRepository;

    public SeatsService(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public Seats GetRoom() {
        return new Seats(seatsRepository.rows, seatsRepository.columns, seatsRepository.availableSeats);
    }
}