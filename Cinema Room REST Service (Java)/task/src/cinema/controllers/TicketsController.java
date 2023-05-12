package cinema.controllers;

import cinema.models.*;
import cinema.services.TicketsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class TicketsController
{
    private TicketsService ticketsService;

    public  TicketsController(TicketsService ticketsService)
    {
        this.ticketsService = ticketsService;
    }

    @PostMapping("/purchase")
    private PurchaseResponse Purchase(@RequestBody SeatPosition seatPosition)
    {
        return ticketsService.Purchase(seatPosition.row, seatPosition.column);
    }

    @PostMapping("/return")
    public ReturnResponse Return(@RequestBody TokenHolder tokenHolder)
    {
        return ticketsService.ReturnTicket(tokenHolder.token());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    private ErrorObj handler(Exception ex)
    {
        return new ErrorObj(ex.getMessage());
    }

    public record ErrorObj(String error)
    {

    }
}
