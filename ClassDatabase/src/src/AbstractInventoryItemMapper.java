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
public abstract class AbstractInventoryItemMapper
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
	 * @throws SQLException 
	 */
	public AbstractInventoryItemMapper( String upc, int manufacturerID, int price, String itemType) throws SQLException
	{
		this.upc= upc;
		this.manufacturerID = manufacturerID;
		this.price = price;
		
			Connection conn = DBConnectionManager.getConnection();
			PreparedStatement query = conn.prepareStatement("Insert into InventoryItem (upc, manufacturerID, price, ItemType) VALUES (?,?,?,?);"); 
			
			query.setString(1, upc);
			query.setInt(2, manufacturerID);
			query.setInt(3, price);
			query.setString(4, itemType);
			
			query.execute();
			
			PreparedStatement findID = conn.prepareStatement("Select id From InventoryItem Where upc = ? and manufacturerId = ? and price = ? and ItemType = ?;");
			findID.setString(1, upc);
			findID.setInt(2, manufacturerID);
			findID.setInt(3, price);
			findID.setString(4, itemType);
			
			ResultSet rs = findID.executeQuery();
			rs.next();
			
			this.id = Integer.parseInt(rs.getString("id"));
			
	}
	
	/**
	 * need for finder constructor of upper classes 
	 *
	 */
	public AbstractInventoryItemMapper()
	{
		
	}
	
	/**
	 * abstract getters for the instance variables
	 * @return
	 */
	public abstract int getId();
	public abstract String getUpc();
	public abstract int getManufacturerID();
	public abstract int getPrice();
	
}
