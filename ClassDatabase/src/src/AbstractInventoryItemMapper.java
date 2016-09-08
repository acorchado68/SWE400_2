package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AbstractInventoryItemMapper.java
 * @author Zachary & Scott
 * Abstract method for adding items to the Inventroy Item Mapper.
 */
public abstract class AbstractInventoryItemMapper extends Mapper 
{
	protected int id;
	protected String upc;
	protected int manufacturerID;
	protected int price;
	
	public AbstractInventoryItemMapper(int id, String upc, int manufacturerID, int price)
	{
		this.id = id;
		this.upc= upc;
		this.manufacturerID = manufacturerID;
		this.price = price;
		
		
		try {
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement query = conn.prepareStatement("Insert into InventoryItem (id, upc, manufacturerID, price) VALUES (?,?,?,?);"); //" + id + ",'" + upc + "'," + manufacturerID + "," + price + ");");
			
			query.setInt(1, id);
			query.setString(2, upc);
			query.setInt(3, manufacturerID);
			query.setInt(4, price);
			
			query.execute();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public AbstractInventoryItemMapper(int id)
	{
		
	}
	public abstract Object getId();
	public abstract Object getUpc();
	public abstract Object getManufacturerID();
	public abstract Object getPrice();
	
}
