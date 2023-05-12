package cinema.models;

import lombok.AllArgsConstructor;

public class SeatPosition
{
    public int row;
    public int column;

    public SeatPosition(int row, int column)
    {
        this.row = row;
        this.column = column;
    }
}
