package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StripNailsMapper extends AbstractFastenerMapper 
{
	public StripNailsMapper(int id, String upc, int manufacturerID, int price, long length, int numberInStrip) 
	{
		super(id, upc, manufacturerID, price, length);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into StripNails (id, numberInStrip) VALUES (?,?);");
			query.setInt(1, id);
			query.setInt(2,numberInStrip);
			
			query.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public StripNailsMapper(int id)
	{
		super(id);
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUpc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getManufacturerID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
