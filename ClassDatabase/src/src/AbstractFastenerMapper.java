package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * AbstractFastenerMapper.java
 * @author Zachary & Scott
 *
 */
public abstract class AbstractFastenerMapper extends AbstractInventoryItemMapper
{
	protected long length;
	
	/**
	 * creation constructor
	 * @param id
	 * @param upc
	 * @param manufacturerID
	 * @param price
	 * @param length
	 */
	public AbstractFastenerMapper(String upc, int manufacturerID, int price, long length) 
	{
		super(upc, manufacturerID, price);
	
		try {
			Connection conn = DBConnectionManager.getConnection();
	
			PreparedStatement query = conn.prepareStatement("Insert into Fastener (id, length) VALUES (?,?);");
			
			query.setInt(1, id);
			query.setLong(2, length);
		
			this.length = length;
			query.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * finder constructor
	 */
	public AbstractFastenerMapper()
	{	
		super();
	}
	
	/**
	 * method for returning length of nail 
	 * @return
	 */
	public abstract long getLength();
}
