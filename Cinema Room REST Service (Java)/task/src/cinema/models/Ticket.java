package cinema.models;

import lombok.AllArgsConstructor;

public class Ticket
{
    public int row;
    public int column;
    public int price;

    public Ticket(int row, int column, int price)
    {
        this.row = row;
        this.column = column;
        this.price = price;
    }
}
