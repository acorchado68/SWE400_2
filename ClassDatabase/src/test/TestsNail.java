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
		PreparedStatement stmt = null;
		NailMapper example = new NailMapper(8, "absolute", 5, 10, 6, 6);
		Connection conn = DBConnectionManager.getConnection();
		String query = "Select * From Nail WHERE id = 8";
		stmt = conn.prepareStatement(query);
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

}
