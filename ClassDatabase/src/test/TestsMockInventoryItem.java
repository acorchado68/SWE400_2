package test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import src.AbstractInventoryItemMapper;
import src.DBConnectionManager;

/**
 * TestsMockInventoryItem.java
 * @author Zachary & Scott
 * Tests for the abstractInventoryItem class
 */
public class TestsMockInventoryItem extends abstractTests
{
	/**
	 * Test for creating a Nail
	 * 
	 * @throws SQLException
	 */
	@Test
	public void testCreation() throws SQLException 
	{
		String upc = "this is a upc";
		int manufacturerId = 7;
		int price = 10;
		MockInventoryItem example = new MockInventoryItem(upc, manufacturerId, price);
		
		Connection conn = DBConnectionManager.getConnection();
		
		PreparedStatement query1 = conn.prepareStatement("Select * from InventoryItem where id = ?;");
		query1.setInt(1, example.getId());
		
		ResultSet rs = query1.executeQuery();
		rs.next();
		assertEquals(upc,rs.getString("upc"));
		assertEquals(manufacturerId,rs.getInt("manufacturerId"));
		assertEquals(price,rs.getInt("price"));
	}
}

class MockInventoryItem extends AbstractInventoryItemMapper
{	
	MockInventoryItem( String upc, int manufacturerID, int price)
	{
		super(upc,manufacturerID, price);
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
}