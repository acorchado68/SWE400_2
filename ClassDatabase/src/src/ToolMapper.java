package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ToolMapper.java
 * @author Zachary & Scott 
 * class for the Tool Table
 */
public class ToolMapper extends AbstractInventoryItemMapper
{
	String description;
	
	/**
	 * creation constructor
	 * @param id 
	 * @param upc code of the item
	 * @param manufacturerID 
	 * @param price
	 * @param description
	 */
	public ToolMapper(String upc, int manufacturerID, int price, String description) 
	{
		super(upc, manufacturerID, price);
	
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into Tool (id, description) VALUES (?,?);");
			
			query.setInt(1, id);
			query.setString(2, description);
			
			query.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * finder constructor
	 * @param id
	 */
	public ToolMapper(int id)
	{
		super(id);
		java.sql.PreparedStatement stmt = null;
		try {
			System.out.println("Enter is here");
			Connection conn = DBConnectionManager.getConnection();
			String query = "SELECT a.id, b.description, a.upc, a.manufacturerId, a.price FROM InventoryItem a JOIN Tool b ON"
			+ "	a.ID = b.ID WHERE a.ID = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			description = rs.getString("description");
			this.id = Integer.parseInt(rs.getString("id"));
			this.upc= rs.getString("upc");
			this.manufacturerID = Integer.parseInt(rs.getString("manufacturerId"));
			this.price = Integer.parseInt(rs.getString("price"));
			
			System.out.println(id + " " + upc);
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * constructor for the concrete finder methods
	 */
	public ToolMapper() 
	{
		super(0);
	}

	/**
	 * returns the description
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * returns the id of the item
	 */
	@Override
	public int getId() 
	{
		return id;
	}

	/**
	 * returns the upc of the item
	 */
	@Override
	public String getUpc() 
	{
		return upc;
	}

	/**
	 * returns the manufacturer ID
	 */
	@Override
	public int getManufacturerID() 
	{
		return manufacturerID;
	}

	/**
	 * returns the price of the item
	 */
	@Override
	public int getPrice() 
	{
		return price;
	}
}
