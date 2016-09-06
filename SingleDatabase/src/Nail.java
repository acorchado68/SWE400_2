/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class Nail extends Fastener
{
    protected int numberInBox;

    public Nail(int id, String upc, int manufacturerID, int price, int length,
                int numberInBox)
    {
        super(id, upc, manufacturerID, price, length);
        this.numberInBox = numberInBox;
    }

    public Nail(int id)
    {
        super(id);
    }

    public String constructQuery()
    {
        return null;
    }
}
