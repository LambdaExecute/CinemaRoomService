package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

public class ReturnResponse
{
    @JsonProperty("returned_ticket")
    public Ticket returnedTicket;

    public ReturnResponse(Ticket returnedTicket)
    {
        this.returnedTicket = returnedTicket;
    }
}
