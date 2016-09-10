package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * AbstractInventoryItemMapper.java
 * @author Zachary & Scott
 * Abstract method for adding items to the Inventory Item Mapper.
 */
public abstract class AbstractInventoryItemMapper extends Mapper 
{
	protected int id;
	protected String upc;
	protected int manufacturerID;
	protected int price;
	
	/**
	 * creation constructor  
	 * @param id
	 * @param upc
	 * @param manufacturerID
	 * @param price
	 */
	public AbstractInventoryItemMapper( String upc, int manufacturerID, int price)
	{
		this.upc= upc;
		this.manufacturerID = manufacturerID;
		this.price = price;
		
		try {
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement query = conn.prepareStatement("Insert into InventoryItem (upc, manufacturerID, price) VALUES (?,?,?);"); 
			
			query.setString(1, upc);
			query.setInt(2, manufacturerID);
			query.setInt(3, price);
			
			query.execute();
			
			PreparedStatement findID = conn.prepareStatement("Select id From InventoryItem Where upc = ? and manufacturerId = ? and price = ? ");
			findID.setString(1, upc);
			findID.setInt(2, manufacturerID);
			findID.setInt(3, price);
			
			ResultSet rs = findID.executeQuery();
			rs.next();
			
			this.id = Integer.parseInt(rs.getString("id"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * need for finder constructor of upper classes 
	 *
	 */
	public AbstractInventoryItemMapper()
	{
		
	}
	
	/**
	 * abstract getter for the instance variables
	 * @return
	 */
	public abstract int getId();
	public abstract String getUpc();
	public abstract int getManufacturerID();
	public abstract int getPrice();
	
}
