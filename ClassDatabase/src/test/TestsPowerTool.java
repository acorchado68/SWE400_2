package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import src.DBConnectionManager;
import src.NailMapper;
import src.PowerToolMapper;
import src.ToolMapper;

public class TestsPowerTool extends abstractTests {

	@Test
	public void testCreationPowerTool() throws SQLException 
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		String description = "description";
		Boolean batteryPowered = true;
		PowerToolMapper example = new PowerToolMapper(upc,manufacturerId,price,description,batteryPowered);
		Connection conn = DBConnectionManager.getConnection();
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
				
		PreparedStatement query2 = conn.prepareStatement("Select * from Tool where id = ?;");
		query2.setInt(1, example.getId());
		
		PreparedStatement query3 = conn.prepareStatement("Select * from PowerTool where id = ?;");
		query3.setInt(1, example.getId());
		
		ResultSet rs = query1.executeQuery();
		rs.next();
		assertEquals(upc,rs.getString("upc"));
		assertEquals(manufacturerId,rs.getInt("manufacturerId"));
		assertEquals(price,rs.getInt("price"));
		
		rs = query2.executeQuery();
		rs.next();
		assertEquals(description,rs.getString("description"));
		
		rs = query3.executeQuery();
		rs.next();
		assertEquals(1,rs.getInt("batteryPowered"));
		
	}
	
	@Test
	public void testFindPowerTool() throws SQLException
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		String description = "description";
		boolean batteryPowered = true;
		PowerToolMapper example = new PowerToolMapper(upc,manufacturerId,price,description,batteryPowered);
		
		PowerToolMapper findExample = new PowerToolMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(description, findExample.getDescription());
		assertEquals(batteryPowered, findExample.getbattery());
		
	}

	/**
	 * test for finding a element that does not exist
	 */
	@Test
	public void testFindNullPowerTool()
	{	
		try {
			new PowerToolMapper(-1);
			fail("Expected an SQLException to be thrown");
		} 
		catch (SQLException exception) 
		{
	
		}    
	}
}
