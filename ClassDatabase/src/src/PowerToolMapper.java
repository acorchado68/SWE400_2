package src;
import java.sql.Connection;
import java.sql.SQLException;

public class PowerToolMapper extends ToolMapper 
{

	public PowerToolMapper(int id, String upc, int manufacturerID, int price, String description, int batteryPowered) 
	{
		super(id, upc, manufacturerID, price, description);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			String query = "Insert into PowerTool (id, batteryPowered) VALUES (" + id + "," + batteryPowered +  ");";
			
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PowerToolMapper(int id)
	{
		super(id);
		
		
		
		
		String query = "SELECT a.id, b.description, a.upc, a.manufacturerId, a.price, c.batteryPowered FROM InventoryItem a JOIN Tool b ON"
				+ "	a.ID = b.ID JOIN PowerTool c ON a.ID = c.ID WHERE a.ID = ?;";
	}
}
