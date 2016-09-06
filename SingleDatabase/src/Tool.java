import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
 */
public class Tool extends InventoryItem
{
    protected String description;

    public Tool(int id, String upc, int manufacturerID, int price, String description)
    {
        super(id, upc, manufacturerID, price);
        String query = constructQuery();
        Connection conn = null;
        try {
            conn = TestConnection.getConnection();
            insert(conn,query);
        } catch ( SQLException e ) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
        }

    }

    public String constructQuery() {
        String query = "INSERT INTO " + TABLE_NAME + " (id, upc, manufacturerID, price, description, batteryPowered, " +
                "length, numberInStrip, numberInBox) VALUES (" + id + "," + upc + "," + manufacturerID + ","
                + price + "," + description + ",null,null,null,null);";
        return query;
    }
}
