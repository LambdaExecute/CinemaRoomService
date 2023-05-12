package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

public class StatisticsResponse
{
    @JsonProperty("current_income")
    public long currentIncome;
    @JsonProperty("number_of_available_seats")
    public long numberOfAvailableSeats;
    @JsonProperty("number_of_purchased_tickets")
    public long numberOfPurchasedTickets;

    public StatisticsResponse(long currentIncome, long numberOfAvailableSeats, long numberOfPurchasedTickets)
    {
        this.currentIncome = currentIncome;
        this.numberOfAvailableSeats = numberOfAvailableSeats;
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }
}
