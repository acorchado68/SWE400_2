package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerToolMapper extends ToolMapper 
{
	int batteryPow;
	public PowerToolMapper(int id, String upc, int manufacturerID, int price, String description, int batteryPowered) 
	{
		super(id, upc, manufacturerID, price, description);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into PowerTool (id, batteryPowered) VALUES (?,?);");
			query.setInt(1, id);
			query.setInt(2, batteryPowered);
			
			query.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PowerToolMapper(int id)
	{
		super(id);
		PreparedStatement stmt = null;
		try{
			System.out.println("Entered PowerToolMapper");
			Connection conn = DBConnectionManager.getConnection();
			String query = "SELECT a.id, b.description, a.upc, a.manufacturerId, a.price, c.batteryPowered FROM InventoryItem a JOIN Tool b ON"
					+ "	a.ID = b.ID JOIN PowerTool c ON a.ID = c.ID WHERE a.ID = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			batteryPow = rs.getInt("batteryPowered");
			this.id = Integer.parseInt(rs.getString("id"));
			this.upc= rs.getString("upc");
			this.manufacturerID = Integer.parseInt(rs.getString("manufacturerId"));
			this.price = Integer.parseInt(rs.getString("price"));
			
			System.out.println(id + " " + batteryPow);
			stmt.execute();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	
	
}
