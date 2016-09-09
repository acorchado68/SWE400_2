package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * PowerToolMapper.java
 * @author Zachary & Scott
 *
 */
public class PowerToolMapper extends ToolMapper 
{
	boolean batteryPow;
	
	/**
	 * creation constuctor
	 * @param id
	 * @param upc
	 * @param manufacturerID
	 * @param price
	 * @param description
	 * @param batteryPowered
	 */
	public PowerToolMapper(String upc, int manufacturerID, int price, String description, boolean batteryPowered) 
	{
		super(upc, manufacturerID, price, description);
		
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into PowerTool (id, batteryPowered) VALUES (?,?);");
			query.setInt(1, id);
			
			if(batteryPowered == true)
			{
				query.setInt(2, 0);
			}
			else
			{
				query.setInt(2, 1);
			}
			query.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * finder constructor
	 * @param id
	 */
	public PowerToolMapper(int id)
	{
		super();
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
			
			int value = rs.getInt("batteryPowered");
			if(value == 0)
			{
				batteryPow = true;
			}
			else
			{
				batteryPow = false;
			}
			this.id = Integer.parseInt(rs.getString("id"));
			this.upc= rs.getString("upc");
			this.manufacturerID = Integer.parseInt(rs.getString("manufacturerId"));
			this.price = Integer.parseInt(rs.getString("price"));
			this.description = rs.getString("description");
			
			stmt.execute();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * @return the battery power
	 */
	public boolean getbattery()
	{
		return batteryPow;
	}
	
}
