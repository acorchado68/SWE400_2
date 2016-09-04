import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class AbstractInventoryItemMapper extends Mapper 
{
	public AbstractInventoryItemMapper(int id, String upc, int manufacturerID, int price)
	{
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into InventoryItem (id, upc, manufacturerID, price) VALUES (" + id + "," + upc + "," + manufacturerID + "," + price + ");";
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public AbstractInventoryItemMapper(int id)
	{
		
	}
}
