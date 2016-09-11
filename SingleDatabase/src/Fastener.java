/**
 *
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
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

    /**
     * Returns the length of this fastener.
     * @return - the length of this fastener
     */
    public long getLength()
    {
        return length;
    }

}
