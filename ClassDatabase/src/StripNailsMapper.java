import java.sql.Connection;
import java.sql.SQLException;

public class StripNailsMapper extends AbstractFastenerMapper 
{
	public StripNailsMapper(int id, String upc, int manufacturerID, int price, long length, int numberInStrip) 
	{
		super(id, upc, manufacturerID, price, length);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into StripNails (id, numberInStrip) VALUES (" + id + "," + numberInStrip + ");";
			
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StripNailsMapper(int id)
	{
		super(id);
	}
}
