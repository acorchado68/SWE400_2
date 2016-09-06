/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class StripNails extends Fastener
{
    protected int numberInStrip;

    public StripNails(int id, String upc, int manufacturerID, int price, int length,
                      int numberInStrip)
    {
        super(id, upc, manufacturerID, price, length);
        this.numberInStrip = numberInStrip;
    }

    public String constructQuery()
    {
        return null;
    }
}
