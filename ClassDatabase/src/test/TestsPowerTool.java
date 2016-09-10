package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import src.NailMapper;
import src.PowerToolMapper;
import src.ToolMapper;

public class TestsPowerTool extends abstractTests {

	@Test
	public void testCreation() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFind() throws SQLException
	{
		String upc = "absolute";
		int manufacturerId = 5;
		int price = 14;
		String description = "description";
		Boolean batteryPowered = true;
		PowerToolMapper example = new PowerToolMapper(upc, manufacturerId, price, description, batteryPowered);
		
		PowerToolMapper findExample = new PowerToolMapper(example.getId());
		assertEquals(upc, findExample.getUpc());
		assertEquals(manufacturerId, findExample.getManufacturerID());
		assertEquals(price, findExample.getPrice());
		assertEquals(description, findExample.getDescription());
		assertEquals(batteryPowered, findExample.getbattery());
		
	}

	/**
	 * test for finding a element that does not exist
	 */
	@Test
	public void testFindNull()
	{	
		try {
			new PowerToolMapper(-1);
			fail("Expected an SQLException to be thrown");
		} 
		catch (SQLException exception) 
		{
	
		}    
	}
}
