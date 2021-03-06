package src;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enums.Nails;
import enums.PowerTools;
import enums.StripNails;
import enums.Tools;


/**
 * InventoryItemMapper.java
 * @author Zachary & Scott
 * Runner, creates a arrayList of items
 */
public class InventoryItemMapper
{
	 static ArrayList<AbstractInventoryItemMapper> dbItem = new ArrayList<AbstractInventoryItemMapper>();
	/**
	 * Main method that will add the objects into the arraylist
	 * @param args
	 * @throws SQLException
	 */
	public static void main(String args[]) throws SQLException
	{
		createDatabase();//Instantiates the Database, comment out if already created.
		
		
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query = conn.prepareStatement("Select id, ItemType From InventoryItem;");
		ResultSet rs = query.executeQuery();
	
		while(rs.next())
		{	
			dbItem.add(findClass(rs.getInt("id"), rs.getString("ItemType")));
		}
	}

	/**
	 * Populates the Database with the Enums provided
	 * @throws SQLException
	 */
	private static void createDatabase() throws SQLException 
	{				
		for(StripNails stripNails : StripNails.values())
		{	
			new StripNailsMapper(stripNails.getUpc(), stripNails.getManufacturerID(), stripNails.getPrice(), stripNails.getLength(), stripNails.getNumberInStrip());
		}
		
		for(Nails nails : Nails.values())
		{
			new NailMapper(nails.getUpc(), nails.getManufacturerID(), nails.getPrice(), nails.getLength(), nails.getNumberInBox());
		}
		
		for(PowerTools powerTool : PowerTools.values())
		{
			new PowerToolMapper(powerTool.getUpc(), powerTool.getManufacturerID(), powerTool.getPrice(), powerTool.getDescription(), powerTool.isBatteryPowered());
		}
		
		for(Tools tool : Tools.values())
		{		
			new ToolMapper(tool.getUpc(),tool.getManufacturerID(), tool.getPrice(), tool.getDescription());
		}
		
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.HITACHI_PNEUMATIC_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.ROUND_HEAD_NAIL_STRIP));
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.FRAMING_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.ROUND_HEAD_NAIL_STRIP));
		
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.HITACHI_PNEUMATIC_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.QUALITY_ROUND_HEAD_NAIL_STRIP));
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.FRAMING_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.QUALITY_ROUND_HEAD_NAIL_STRIP));
		
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.BRAD_CORDLESS_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.BRAD_STRIP));
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.BRAD_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.BRAD_STRIP));
		
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.BRAD_CORDLESS_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.BRIGHT_FINISH_BRAD_STRIP));
		new PowerToolXStripNailMapper(PowerToolXStripNailMapper.findPT(PowerTools.BRAD_NAILER),
				PowerToolXStripNailMapper.findSN(StripNails.BRIGHT_FINISH_BRAD_STRIP));
	}
	
	/**
	 * finds the type of the id from the database
	 * @param string
	 * @param string2
	 * @return
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	private static AbstractInventoryItemMapper findClass(int idNum, String itemType) throws NumberFormatException, SQLException 
	{
		AbstractInventoryItemMapper item = null;
		if(itemType.equals("Tool"))
		{
			item = new ToolMapper(idNum);
		}
		else if(itemType.equals("PowerTool"))
		{
			item = new PowerToolMapper(idNum);
		}
		else if(itemType.equals("Nail"))
		{
			item = new NailMapper(idNum);
		}
		else if(itemType.equals("StripNail"))
		{
			item = new StripNailsMapper(idNum);
		}
		return item;
	}
	
	
	
}
