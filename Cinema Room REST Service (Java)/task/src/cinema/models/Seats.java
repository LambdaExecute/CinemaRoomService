package cinema.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    @JsonProperty("total_rows")
    public int rows;
    @JsonProperty("total_columns")
    public int columns;
    @JsonProperty("available_seats")
    public List<Ticket> availableSeats = new ArrayList<>();

    public Seats(int rows, int columns, List<Ticket> availableSeats)
    {
        this.rows = rows;
        this.columns = columns;
        this.availableSeats = availableSeats;
    }
}
