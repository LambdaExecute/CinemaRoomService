package cinema.controllers;

import cinema.models.StatisticsResponse;
import cinema.services.SeatsService;
import cinema.services.TicketsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class StatisticController
{
    public TicketsService ticketsService;
    public SeatsService seatsService;

    public StatisticController(TicketsService ticketsService, SeatsService seatsService)
    {
        this.ticketsService = ticketsService;
        this.seatsService = seatsService;
    }

    @PostMapping("/stats")
    public StatisticsResponse Stats(String password)
    {
        if(!"super_secret".equals(password))
            throw new RuntimeException("The password is wrong!");

        return  ticketsService.CollectStatistics();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(Exception.class)
    private ErrorObj handler(Exception ex)
    {
        return new ErrorObj(ex.getMessage());
    }

    public record ErrorObj(String error)
    {

    }
}
