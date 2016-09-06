package src;
import java.sql.Connection;
import java.sql.SQLException;

public class NailMapper extends AbstractFastenerMapper 
{
	protected int numberInBox;
	private final String CLASSNAME = "Nail";
	
	public NailMapper(int id, String upc, int manufacturerID, int price, long length, int numberInBox) 
	{
		super(id, upc, manufacturerID, price, length);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Insert into " + CLASSNAME + " (id, numberInBox) VALUES (" + id + "," + numberInBox +  ");";

			stmt = conn.prepareStatement(query);
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NailMapper(int id)
	{
		super(id);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = TestConnection.getConnection();
			
			String query = "Select id, numberInBox From ? WHERE id = (?)";

			stmt = conn.prepareStatement(query);
			stmt.execute();

			numberInBox = 0;
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
