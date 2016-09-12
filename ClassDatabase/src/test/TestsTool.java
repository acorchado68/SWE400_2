package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import src.DBConnectionManager;
import src.NailMapper;
import src.ToolMapper;

public class TestsTool extends abstractTests{
	
	/**
	 * Tests the creation of a tool
	 * @throws SQLException
	 */
	@Test
	public void testCreationTool() throws SQLException 
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		String description = "description";
		ToolMapper example = new ToolMapper(upc, manufacturerId, price, description);
	
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
				
		PreparedStatement query2 = conn.prepareStatement("Select * from Tool where id = ?;");
		query2.setInt(1, example.getId());
		
		ResultSet rs = query1.executeQuery();
		rs.next();
		assertEquals(upc,rs.getString("upc"));
		assertEquals(manufacturerId,rs.getInt("manufacturerId"));
		assertEquals(price,rs.getInt("price"));
		
		rs = query2.executeQuery();
		rs.next();
		assertEquals(description,rs.getString("description"));
		
	}
	
	/**
	 * Tests the finding of a tool
	 * @throws SQLException
	 */
	@Test
	public void testFindTool() throws SQLException
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		String description = "description";
		ToolMapper example = new ToolMapper(upc, manufacturerId, price, description);
		
		ToolMapper findExample = new ToolMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(description, findExample.getDescription());
	
	}

	/**
	 * Test if find is called on a id that does not exist
	 */
	@Test
	public void testFindNullTool()
	{	
		try {
			new ToolMapper(-1);
			fail("Expected an SQLException to be thrown");
		} 
		catch (SQLException exception) 
		{
	
		}    
	}
}
