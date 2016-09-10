package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import src.ToolMapper;

public class TestsTool extends abstractTests{
	
	@Test
	public void testCreation() throws SQLException 
	{
		
	}
	
	@Test
	public void testFind() throws SQLException
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
	public void testFindNull()
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
