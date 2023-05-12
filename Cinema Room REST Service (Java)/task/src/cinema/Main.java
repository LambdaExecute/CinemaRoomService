package cinema;

import cinema.controllers.SeatsController;
import cinema.controllers.StatisticController;
import cinema.controllers.TicketsController;
import cinema.repositories.SeatsRepository;
import cinema.services.SeatsService;
import cinema.services.TicketsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main
{
    static private SeatsRepository seatsRepository;
    static private SeatsService seatsService;
    static  private TicketsService ticketsService;
    static private SeatsController seatsController;
    static private TicketsController ticketsController;
    static private StatisticController statisticController;

    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
        seatsRepository = new SeatsRepository();

        seatsService = new SeatsService(seatsRepository);
        ticketsService = new TicketsService(seatsRepository);
        statisticController = new StatisticController(ticketsService, seatsService);

        seatsController = new SeatsController(seatsService);
        ticketsController = new TicketsController(ticketsService);
    }
}
