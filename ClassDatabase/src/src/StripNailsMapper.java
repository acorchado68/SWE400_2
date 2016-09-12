package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StripNailsMapper.java
 * @author Zachary & SCott
 *
 */
public class StripNailsMapper extends AbstractFastenerMapper 
{
	protected int numberInStrip;
	public StripNailsMapper(String upc, int manufacturerID, int price, double length, int numberInStrip) throws SQLException 
	{
			super(upc, manufacturerID, price, length, "StripNail");
	
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into StripNail (id, numberInStrip) VALUES (?,?);");
			query.setInt(1, id);
			query.setInt(2,numberInStrip);
			
			query.execute();
			
			this.numberInStrip = numberInStrip;
	}

	public StripNailsMapper(int id) throws NumberFormatException, SQLException
	{
		super();
		PreparedStatement stmt = null;
	
			Connection conn = DBConnectionManager.getConnection();
			String query = "SELECT a.id, a.upc, a.manufacturerId, a.price, b.length, c.numberInStrip FROM InventoryItem a JOIN Fastener b ON"
					+ "	a.ID = b.ID JOIN StripNail c ON a.ID = c.ID WHERE a.ID = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
					
			this.id = rs.getInt("id");
			this.upc= rs.getString("upc");
			this.length = Double.parseDouble(rs.getString("length"));
			this.manufacturerID = Integer.parseInt(rs.getString("manufacturerId"));
			this.price = Integer.parseInt(rs.getString("price"));
			this.numberInStrip = Integer.parseInt(rs.getString("numberInStrip"));	
	}

	public int getNumInStrip()
	{
		return numberInStrip;
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
	public double getLength() 
	{
		return length;
	}
}
