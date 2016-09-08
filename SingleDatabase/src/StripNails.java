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

    public String constructQuery()
    {
        return null;
    }
}
