import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public abstract class InventoryItem
{
    protected static final String DB_TABLE_NAME = "InventoryItem";

    protected int id;
    protected String upc;
    protected int manufacturerID;
    protected int price;

    public InventoryItem(int id, String upc, int manufacturerID, int price)
    {
        this.id = id;
        this.upc = upc;
        this.manufacturerID = manufacturerID;
        this.price = price;
        insert();
    }

    public InventoryItem(int id)
    {
        find(id);
    }

    /**
     * Returns the id of this inventory item.
     * @return - the id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the upc of this inventory item.
     * @return - the upc
     */
    public String getUpc() {
        return upc;
    }

    /**
     * Returns the manufacturer ID of this inventory item.
     * @return - the manufacturerID
     */
    public int getManufacturerID() {
        return manufacturerID;
    }

    /**
     * Returns the price of this inventory item.
     * @return - the price
     */
    public int getPrice() {
        return price;
    }

    public abstract String getClassType();

    protected abstract void insert();

    protected abstract void find(int id);

}
