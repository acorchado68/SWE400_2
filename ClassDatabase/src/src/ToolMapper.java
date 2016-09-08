package src;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ToolMapper extends AbstractInventoryItemMapper
{
	String description;
	
	public ToolMapper(int id, String upc, int manufacturerID, int price, String description) 
	{
		super(id, upc, manufacturerID, price);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			String query = "Insert into Tool (id, description) VALUES (" + id + "," + description +  ");";
			
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
	public ToolMapper() 
	{
		super(0);
	}

	public Object getDescription()
	{
		return description;
	}

	@Override
	public int getId() 
	{
		return id;
	}

	@Override
	public String getUpc() 
	{
		return upc;
	}

	@Override
	public int getManufacturerID() 
	{
		// TODO Auto-generated method stub
		return manufacturerID;
	}

	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
}
