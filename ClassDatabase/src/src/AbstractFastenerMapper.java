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
	protected double length;
	
	/**
	 * creation constructor
	 * @param id
	 * @param upc
	 * @param manufacturerID
	 * @param price
	 * @param length
	 * @throws SQLException 
	 */
	public AbstractFastenerMapper(String upc, int manufacturerID, int price, double length) throws SQLException 
	{
		super(upc, manufacturerID, price);

			Connection conn = DBConnectionManager.getConnection();
	
			PreparedStatement query = conn.prepareStatement("Insert into Fastener (id, length) VALUES (?,?);");
			
			query.setInt(1, id);
			query.setDouble(2, length);
		
			this.length = length;
			query.execute();
	
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
	public abstract double getLength();
}
