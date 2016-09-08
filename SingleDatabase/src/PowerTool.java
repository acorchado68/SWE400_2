import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Power Tool
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16. Last Modified on 9/8/16.
 */
public class PowerTool extends Tool
{
    protected boolean batteryPowered;

    private static final String insertQuery = "INSERT INTO " + TABLE_NAME + " (upc, manufacturerID, "
    		+ "price, description, batteryPowered, length, numberInStrip, numberInBox, type) "
    		+ "VALUES (?,?,?,?,?,null,null,null,?);";

    private static final String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = (?);";

    private static final String classType = "PowerTool";

    public PowerTool(int id, String upc, int manufacturerID, int price,
                     String description, boolean batteryPowered)
    {
        super(id, upc, manufacturerID, price, description);
        this.batteryPowered = batteryPowered;

        try
        {
        	Connection conn = TestConnection.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(insertQuery);
        	stmt.setString(1, upc);
        	stmt.setInt(2, manufacturerID);
        	stmt.setInt(3, price);
        	stmt.setString(4, description);
        	stmt.setBoolean(5, batteryPowered);
        	stmt.setString(6, classType);

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

    public PowerTool(int id)
    {
    	try
    	{
    		Connection conn = TestConnection.getConnection();
    		PreparedStatment stmt = conn.prepareStatement(selectQuery);
    		stmt.setInt(1, id);

    		ResultSet rs = stmt.executeQuery();
      		id = rs.getInt("id");
    		upc = rs.getString("upc");
    		manufacturerID = rs.getInt("manufacturerID");
    		price = rs.getInt("price");
    		description = rs.getString("description");
    		batteryPowered = rs.getBoolean("batteryPowered");
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