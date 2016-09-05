import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class AbstractInventoryItemMapper extends Mapper 
{
	protected int id;
	protected String upc;
	protected int manufacturerID;
	protected int price;
	
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
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into InventoryItem (id, upc, manufacturerID, price) VALUES (" + id + "," + upc + "," + manufacturerID + "," + price + ");";
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			id = 0;
			upc= "";
			manufacturerID = 0;
			price = 0;
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
