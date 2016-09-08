/**
 * Fastener
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16. Last Mofified on 9/8/16.
 */
public abstract class Fastener extends InventoryItem
{
    protected long length;

    public Fastener(int id, String upc, int manufacturerID, int price, int length)
    {
        super(id, upc, manufacturerID, price);
        this.length = length;
    }

    public Fastener(int id)
    {
        super(id);
    }
}
