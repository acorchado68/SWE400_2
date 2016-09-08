package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
			Connection conn = DBConnectionManager.getConnection();
			
			PreparedStatement query = conn.prepareStatement("Insert into " + CLASSNAME + " (id, numberInBox) VALUES ( ?,? );");
			
			query.setInt(1,id);
			query.setInt(2,numberInBox);
			query.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public NailMapper(int id)
	{
		super(id);
		
		java.sql.PreparedStatement stmt = null;
		try {
			Connection conn = DBConnectionManager.getConnection();
			
			String query = "SELECT a.id, b.description, a.upc, a.manufacturerId, a.price, c.batteryPowered FROM InventoryItem a JOIN Tool b ON"
			+ "	a.ID = b.ID JOIN PowerTool c ON a.ID = c.ID WHERE a.ID = ?;";
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			
			stmt.execute();

			numberInBox = 0;
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getId() 
	{
		return id;
	}

	@Override
	public String getUpc() 
	{
		return upc;
	}

	@Override
	public int getManufacturerID() 
	{
		return manufacturerID;
	}

	@Override
	public int getPrice() 
	{
		return price;
	}

	@Override
	public long getLength() 
	{
		return length;
	}
	
}
