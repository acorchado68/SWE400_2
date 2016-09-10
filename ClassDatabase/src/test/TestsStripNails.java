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
import src.StripNailsMapper;

public class TestsStripNails extends abstractTests 
{
	@Test
	public void testCreation() throws SQLException 
	{
		//cant test cause offline form database but should work,
		// may need to make id equal to one since the auto increment
		//was implemented
		String[] Checker = { "6", "8" };
		new StripNailsMapper("absolute", 5, 10, 6, 6);
		Connection conn = DBConnectionManager.getConnection();
		PreparedStatement stmt = conn.prepareStatement("Select * From StripNail WHERE id = 1");
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
	
	@Test
	public void testFindStripNails() throws SQLException
	{
		String upc = "absolute3";
		int manufacturerId = 7;
		int price = 14;
		int length = 7;
		int numStrip = 15;
		StripNailsMapper example = new StripNailsMapper(upc, manufacturerId, price, length, numStrip);
		
		StripNailsMapper findExample = new StripNailsMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(length, findExample.getLength());
		assertEquals(numStrip, findExample.getNumInStrip());
	}
	
	/**
	 * Test if find is called on a id that does not exist
	 */
	@Test
	public void testNull()
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
