package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import src.AbstractFastenerMapper;
import src.AbstractInventoryItemMapper;
import src.DBConnectionManager;

/**
 * TestsMockInventoryItem.java
 * @author Zachary & Scott
 * Tests for the abstractInventoryItem class
 */
public class TestsMockFastener extends abstractTests
{
	/**
	 * Test for creating a Nail
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testCreationMockFastenerClass() throws SQLException 
	{
		String upc = "this is a upc";
		int manufacturerId = 7;
		int price = 10;
		double length = 60;
		MockFastener example = new MockFastener(upc, manufacturerId, price, length);
		
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
		
		ResultSet rs = query1.executeQuery();
		
		rs.next();
		assertEquals(upc,rs.getString("upc"));
		assertEquals(manufacturerId,rs.getInt("manufacturerId"));
		assertEquals(price,rs.getInt("price"));
		
		PreparedStatement query2 = conn.prepareStatement("Select * from Fastener where id = ?;");
		query2.setInt(1, example.getId());
		rs = query2.executeQuery();
		rs.next();
		assertEquals(length,rs.getDouble("length"),.01);
	}
}

class MockFastener extends AbstractFastenerMapper
{	
	MockFastener( String upc, int manufacturerID, int price, double length) throws SQLException
	{
		super(upc,manufacturerID, price,length, "");
	}

	@Override
	public int getId() 
	{
		return id;
	}

	@Override
	public String getUpc() 
	{
		return upc;
	}

	@Override
	public int getManufacturerID() 
	{
		return manufacturerID;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public double getLength() 
	{
		return length;
	}
}
