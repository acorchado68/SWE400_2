package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * NailMapper.java
 * @author Zachary & Scott
 *
 */
public class NailMapper extends AbstractFastenerMapper 
{
	protected int numberInBox;
	private final String CLASSNAME = "Nail";
	
	/**
	 * creation constructor
	 * @param id
	 * @param upc
	 * @param manufacturerID
	 * @param price
	 * @param length
	 * @param numberInBox
	 * @throws SQLException 
	 */
	public NailMapper( String upc, int manufacturerID, int price, double length, int numberInBox) throws SQLException 
	{
		super(upc, manufacturerID, price, length, "Nail");
		
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into " + CLASSNAME + " (id, numberInBox) VALUES ( ?,? );");
			
			query.setInt(1,id);
			query.setInt(2,numberInBox);
			query.execute();
			
			this.numberInBox = numberInBox;
		
	}

	/**
	 * finder constructor
	 * @param id
	 * @throws SQLException 
	 */
	public NailMapper(int id) throws SQLException
	{
		super();
		
		java.sql.PreparedStatement stmt = null;
			Connection conn = DBConnectionManager.getConnection();
			
			String query = "SELECT a.id, a.upc, a.manufacturerId, a.price, b.length, c.numberInBox FROM InventoryItem a JOIN Fastener b ON"
			+ "	a.ID = b.ID JOIN Nail c ON a.ID = c.ID WHERE a.ID = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			this.id = Integer.parseInt(rs.getString("id"));
			this.upc= rs.getString("upc");
			this.manufacturerID = Integer.parseInt(rs.getString("manufacturerId"));
			this.price = Integer.parseInt(rs.getString("price"));
			this.length = Double.parseDouble(rs.getString("length"));
			this.numberInBox = Integer.parseInt(rs.getString("numberInBox"));
			
	}

	/**
	 * returns the ID
	 */
	@Override
	public int getId() 
	{
		return id;
	}

	/**
	 * returns the UPC
	 */
	@Override
	public String getUpc() 
	{
		return upc;
	}

	/**
	 * returns the manufacturerID
	 */
	@Override
	public int getManufacturerID() 
	{
		return manufacturerID;
	}

	/**
	 * returns the price 
	 */
	@Override
	public int getPrice() 
	{
		return price;
	}

	/**
	 * returns the length
	 */
	@Override
	public double getLength() 
	{
		return length;
	}
	
	/**
	 * returns the number in the Box
	 * @return
	 */
	public int getNumInBox()
	{
		return numberInBox;
	}
	
}
