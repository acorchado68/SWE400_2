package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

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
	public void testCreation() throws SQLException 
	{
		String[] Checker = { "6", "8" };
		
		new NailMapper("absolute", 5, 10, 6, 6);
		Connection conn = DBConnectionManager.getConnection();
		PreparedStatement stmt = conn.prepareStatement("Select * From Nail WHERE id = 8");
		ResultSet rs = stmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int incrementer = rsmd.getColumnCount();
		while (rs.next()) 
		{
			for (int i = 1; i <= incrementer; i++) 
			{
				assertEquals(Checker[i - 1], rs.getString(i));
			}
		}
	}

	/**
	 * Test for finding the creation 
	 * @throws SQLException
	 */
	@Test
	public void testFind() throws SQLException
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 10;
		int length = 6;
		int numBox = 6;
		NailMapper example = new NailMapper(upc, manufacturerId, price, length, numBox);
		
		NailMapper findExample = new NailMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(length, findExample.getLength());
		assertEquals(numBox, findExample.getNumInBox());
	}
}
