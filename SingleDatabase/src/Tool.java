import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Tool
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16. Last Modified on 9/8/16.
 */
public class Tool extends InventoryItem
{
    protected String description;

    private static final String insertQuery = "INSERT INTO " + TABLE_NAME + " (upc, manufacturerID, "
    		+ "price, description, batteryPowered, length, numberInStrip, numberInBox, type) "
    		+ "VALUES (?,?,?,?,null,null,null,null,?);";

    private static final String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = (?);";

    private static final String classType = "Tool";

    public Tool(int id, String upc, int manufacturerID, int price, String description)
    {
        super(id, upc, manufacturerID, price);
        this.description = description;

        try
        {
        	Connection conn = TestConnection.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(insertQuery);
        	stmt.setString(1, upc);
        	stmt.setInt(2, manufacturerID);
        	stmt.setInt(3, price);
        	stmt.setString(4, description);
        	stmt.setString(5, classType);

        	stmt.executeUpdate();
        } catch ( SQLException exception )
        {
        	exception.printStackTrace();
        } finally
        {
        	if( conn != null )
        	{
        		conn.close();
        	}
        	if( stmt != null )
        	{
        		stmt.close();
        	}
        }
    }

    public Tool(int id)
    {
    	try
    	{
    		Connection conn = TestConnection.getConnection();
    		PreparedStatment stmt = conn.prepareStatement(selectQuery);
    		stmt.setInt(1, id);

    		ResultSet rs = stmt.executeQuery();
    		if( rs.first() == null )
    		{
    			// ...
    			return;
    		}
    		// set relevant fields for Tool
    	} catch ( SQLException exception )
    	{
    		exception.printStackTrace();
    	} finally
    	{
    		if( conn != null )
    		{
    			conn.close();
    		}
    		if( stmt != null )
    		{
    			stmt.close();
    		}
    	}
    }

}
