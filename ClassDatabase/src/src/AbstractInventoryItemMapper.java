package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		this.id = id;
		this.upc= upc;
		this.manufacturerID = 0;
		this.price = 0;
		
		
		try {
			Connection conn = TestConnection.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into InventoryItem (id, upc, manufacturerID, price) VALUES (?,?,?,?);"); //" + id + ",'" + upc + "'," + manufacturerID + "," + price + ");");
			
			query.setInt(1, id);
			query.setString(2, upc);
			query.setInt(3, manufacturerID);
			query.setInt(4, price);
			
			query.execute();
			
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
