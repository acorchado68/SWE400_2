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
	}
}
