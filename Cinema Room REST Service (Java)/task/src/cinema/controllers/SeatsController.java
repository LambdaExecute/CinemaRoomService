package cinema.controllers;

import cinema.models.Seats;
import cinema.services.SeatsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class SeatsController
{
    private SeatsService seatsService;

    public  SeatsController(SeatsService seatsService)
    {
        this.seatsService = seatsService;
    }

    @GetMapping("/seats")
    public Seats GetSeats()
    {
        return seatsService.GetRoom();
    }
}
