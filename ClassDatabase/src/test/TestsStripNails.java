package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import src.DBConnectionManager;
import src.NailMapper;
import src.StripNailsMapper;

public class TestsStripNails extends abstractTests 
{
	@Test
	public void testCreationStripNail() throws SQLException 
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		double length = 6;
		int numStrip = 14;
		StripNailsMapper example = new StripNailsMapper(upc, manufacturerId, price, length, numStrip);
		
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
				
		PreparedStatement query2 = conn.prepareStatement("Select * from Fastener where id = ?;");
		query2.setInt(1, example.getId());
		
		PreparedStatement query3 = conn.prepareStatement("Select * from StripNail where id = ?;");
		query3.setInt(1, example.getId());
		
		ResultSet rs = query1.executeQuery();
		rs.next();
		assertEquals(upc,rs.getString("upc"));
		assertEquals(manufacturerId,rs.getInt("manufacturerId"));
		assertEquals(price,rs.getInt("price"));
		
		rs = query2.executeQuery();
		rs.next();
		assertEquals(length,rs.getDouble("length"),.01);
		
		rs = query3.executeQuery();
		rs.next();
		assertEquals(numStrip,rs.getInt("numberInStrip"));
	}
	
	@Test
	public void testFindStripNails() throws SQLException
	{
		String upc = "absolute3";
		int manufacturerId = 7;
		int price = 14;
		double length = 7;
		int numStrip = 15;
		StripNailsMapper example = new StripNailsMapper(upc, manufacturerId, price, length, numStrip);
		
		StripNailsMapper findExample = new StripNailsMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(length, findExample.getLength(),.01);
		assertEquals(numStrip, findExample.getNumInStrip());
	}
	
	/**
	 * Test if find is called on a id that does not exist
	 */
	@Test
	public void testNullStripNail()
	{	
		try {
			new StripNailsMapper(-1);
			fail("Expected an SQLException to be thrown");
		} 
		catch (SQLException exception) 
		{
	
		}    
	}
}
