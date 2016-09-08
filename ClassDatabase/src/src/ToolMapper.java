package src;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ToolMapper extends AbstractInventoryItemMapper 
{

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
			ResultSetMetaData rsmd = rs.getMetaData();
			int incrementer = rsmd.getColumnCount();
			while (rs.next()) 
			{
				for (int i = 1; i <= incrementer; i++) 
				{
					System.out.println(rs.getString(i)+ "");
				}
			}
			
			
			stmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
