import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Strip Nails
 * Nick Martinez and Andrew Corchado - Single File Inheritence
 * Created by Nick Martinez on 9/3/16. Last Modified on 9/8/16.
 */
public class StripNails extends Fastener
{
    protected int numberInStrip;

    private static final String insertQuery = "INSERT INTO " + TABLE_NAME + " (upc, manufacturerID, "
    		+ "price, description, batteryPowered, length, numberInStrip, numberInBox, type) "
    		+ "VALUES (?,?,?,null,null,?,?,null,?);";

    private static final String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = (?);";

    private static final String classType = "StripNails";

    public StripNails(int id, String upc, int manufacturerID, int price, int length,
                      int numberInStrip)
    {
        super(id, upc, manufacturerID, price, length);
        this.numberInStrip = numberInStrip;

        try
        {
        	Connection conn = TestConnection.getConnection();
        	PreparedStatement stmt = conn.prepareStatement(insertQuery);
        	stmt.setString(1, upc);
        	stmt.setInt(2, manufacturerID);
        	stmt.setInt(3, price);
        	stmt.setInt(4, length);
        	stmt.setInt(5, numberInStrip);
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

    public StripNails(int id)
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
    		length = rs.getInt("length");
    		numberInStrip = rs.getInt("numberInStrip");
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
