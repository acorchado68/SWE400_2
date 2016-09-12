/**
 *
 * Nick Martinez and Andrew Corchado - Single Table Inheritance
 * Created by Nick Martinez on 9/3/16.
 */
public abstract class Fastener extends InventoryItem
{
    protected long length;

    public Fastener()
    {
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
