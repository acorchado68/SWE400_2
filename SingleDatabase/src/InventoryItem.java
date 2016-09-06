import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16.
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
        // ResultSet rs = insert(connection)
        this.id = id;
        this.upc = upc;
        this.manufacturerID = manufacturerID;
        this.price = price;
    }

    public InventoryItem(int id)
    {

    }

    /**
     * Insertion. TODO
     * Will return a ResultSet
     * @param conn connection to the database
     */
    public void insert(Connection conn, String query)
    {
        PreparedStatement stmt = null;

        try {
            conn = TestConnection.getConnection();

            stmt = conn.prepareStatement(query);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch ( SQLException e ) {
                System.out.println("Insertion Problems");
                e.printStackTrace();
            }
        }
    }

    public abstract String constructQuery();

}
