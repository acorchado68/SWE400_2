import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractFastenerMapper extends AbstractInventoryItemMapper
{
	protected long length;
	
	public AbstractFastenerMapper(int id, String upc, int manufacturerID, int price, long length) 
	{
		super(id, upc, manufacturerID, price);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			
			
			String query = "Insert into Fastener (id, length) VALUES (" + id + "," + length +  ");";
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public AbstractFastenerMapper(int id)
	{	
		super(id);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into Fastener (id, length) VALUES (" + id + "," + length +  ");";
			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			length = 0;
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
