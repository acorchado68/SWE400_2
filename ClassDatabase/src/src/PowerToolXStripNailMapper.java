package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enums.PowerTools;
import enums.StripNails;

/**
 * PowerToolXStripNailMapper.java
 * @author Zachary & Scott
 * Class pertaining to the link table between Powertools and StripNails
 */
public class PowerToolXStripNailMapper 
{
	private PowerToolMapper PTMapper;
	private StripNailsMapper SNMapper;
	
	/**
	 * Constructor for setting up a connection between a PowerTool and StripNail
	 * @param PTMapper StripNail to connect
	 * @param SNMapper PowerTool to connect
	 */
	public PowerToolXStripNailMapper(PowerToolMapper PTMapper, StripNailsMapper SNMapper)
	{
		this.PTMapper = PTMapper;
		this.SNMapper = SNMapper;
		
		Connection conn;
		try {
			conn = DBConnectionManager.getConnection();
			PreparedStatement query = conn.prepareStatement("Insert into PowerToolStripNail (PowerToolID, StripNailID) VALUES ( ?,? );");
			query.setInt(1,PTMapper.getId());
			query.setInt(2,SNMapper.getId());
			query.execute();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * getter for PT Mapper
	 * @return the PowerToolMapper
	 */
	public PowerToolMapper getPTMapper()
	{
		return PTMapper;
	}
	
	/**
	 * getter for SN Mapper 
	 * @return the StripNailMapper
	 */
	public StripNailsMapper getSNMapper()
	{
		return SNMapper;
	}

	public static PowerToolMapper findPTID(PowerTools powertool) throws SQLException
	{
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement findID = conn.prepareStatement("Select id From InventoryItem Where upc = ? and manufacturerId = ? and price = ? and ItemType = ?;");
		findID.setString(1, powertool.getUpc());
		findID.setInt(2, powertool.getManufacturerID());
		findID.setInt(3, powertool.getPrice());
		findID.setString(4, "PowerTool");
		
		ResultSet rs = findID.executeQuery();
		rs.next();
		
		return new PowerToolMapper(Integer.parseInt(rs.getString("id")));
	}
	
	public static StripNailsMapper findSNID(StripNails stripnail) throws SQLException
	{
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement findID = conn.prepareStatement("Select id From InventoryItem Where upc = ? and manufacturerId = ? and price = ? and ItemType = ?;");
		findID.setString(1, stripnail.getUpc());
		findID.setInt(2, stripnail.getManufacturerID());
		findID.setInt(3, stripnail.getPrice());
		findID.setString(4, "StripNail");

		ResultSet rs = findID.executeQuery();
		rs.next();
		
		return new StripNailsMapper(Integer.parseInt(rs.getString("id")));
	}
}
