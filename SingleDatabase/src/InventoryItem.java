import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Inventory Item
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16. Last Modified on 9/8/16.
 */
public abstract class InventoryItem
{
    public static final String TABLE_NAME = "InventoryItem";

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
    }

    public InventoryItem(int id)
    {
    	this.id = id;
    }

}
