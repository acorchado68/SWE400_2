package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.management.Query;

import src.*;

import org.junit.Test;

/**
 * TestNail.java
 * 
 * @author Zachary & Scott 
 * Tests for the Nail class
 */
public class TestsNail extends abstractTests {
	
	/**
	 * Test for creating a Nail
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testCreationNail() throws SQLException 
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		double length = 6;
		int numBox = 14;
		NailMapper example = new NailMapper(upc, manufacturerId, price, length, numBox);
		
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
				
		PreparedStatement query2 = conn.prepareStatement("Select * from Fastener where id = ?;");
		query2.setInt(1, example.getId());
		
		PreparedStatement query3 = conn.prepareStatement("Select * from Nail where id = ?;");
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
		assertEquals(numBox,rs.getInt("numberInBox"));
	}

	/**
	 * Test for finding the creation 
	 * @throws SQLException
	 */
	@Test
	public void testFindNails() throws SQLException
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		double length = 6;
		int numBox = 14;
		NailMapper example = new NailMapper(upc, manufacturerId, price, length, numBox);
		
		NailMapper findExample = new NailMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(length, findExample.getLength(),.01);
		assertEquals(numBox, findExample.getNumInBox());
	}
	
	/**
	 * Test if find is called on a id that does not exist
	 */
	@Test
	public void testNullNail()
	{	
		try {
			new NailMapper(-1);
			fail("Expected an SQLException to be thrown");
		} 
		catch (SQLException exception) 
		{
	
		}    
	}
	
}
