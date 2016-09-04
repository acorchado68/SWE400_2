import java.sql.Connection;
import java.sql.SQLException;

public class NailMapper extends AbstractFastenerMapper 
{

	public NailMapper(int id, String upc, int manufacturerID, int price, long length, int numberInBox) 
	{
		super(id, upc, manufacturerID, price, length);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into Nail (id, numberInBox) VALUES (" + id + "," + numberInBox +  ");";

			stmt = conn.prepareStatement(query);
			stmt.execute();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NailMapper(int id)
	{
		super(id);
	}
	
}
