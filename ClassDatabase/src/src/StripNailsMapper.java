package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * StripNailsMapper.java
 * @author Zachary & SCott
 *
 */
public class StripNailsMapper extends AbstractFastenerMapper 
{
	public StripNailsMapper(int id, String upc, int manufacturerID, int price, long length, int numberInStrip) 
	{
		super(upc, manufacturerID, price, length);
		
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

	/**
	 * returns the id
	 */
	@Override
	public int getId() {

		return id;
	}

	/**
	 * returns the upc
	 */
	@Override
	public String getUpc() {
		return upc;
	}

	/**
	 * returns the manufacturerID
	 */
	@Override
	public int getManufacturerID() {
		return manufacturerID;
	}

	/**
	 * returns the price
	 */
	@Override
	public int getPrice() {
		return price;
	}

	/**
	 * return the nail length
	 */
	@Override
	public long getLength() 
	{
		return length;
	}
}
