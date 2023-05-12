package cinema.models;

import cinema.services.TicketsService;
import lombok.AllArgsConstructor;

import java.util.UUID;

public class PurchaseResponse
{
    public String token;
    public Ticket ticket;

    public PurchaseResponse(String token, Ticket ticket)
    {
        this.token = token;
        this.ticket = ticket;
    }
}
