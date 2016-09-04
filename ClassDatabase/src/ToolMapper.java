import java.sql.Connection;
import java.sql.SQLException;

public class ToolMapper extends AbstractInventoryItemMapper 
{

	public ToolMapper(int id, String upc, int manufacturerID, int price, String description) 
	{
		super(id, upc, manufacturerID, price);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into Tool (id, description) VALUES (" + id + "," + description +  ");";
			
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ToolMapper(int id)
	{
		super(id);
	}
	
}
