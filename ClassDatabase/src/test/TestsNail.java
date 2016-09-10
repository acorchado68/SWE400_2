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
	public void testCreation() throws SQLException 
	{
		new NailMapper("absolute", 5, 10, 6, 6);
		Connection conn = DBConnectionManager.getConnection();
		PreparedStatement query = conn.prepareStatement("Select  numberInBox from Nail where id = 1;");		
		query.execute();
		ResultSet rs = query.executeQuery();
		System.out.println(rs.getInt("numberInBox"));
		//assertEquals(6,numbInBox);
		
		query.execute();
		
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
		int length = 6;
		int numBox = 14;
		NailMapper example = new NailMapper(upc, manufacturerId, price, length, numBox);
		
		NailMapper findExample = new NailMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(length, findExample.getLength());
		assertEquals(numBox, findExample.getNumInBox());
	}
}
