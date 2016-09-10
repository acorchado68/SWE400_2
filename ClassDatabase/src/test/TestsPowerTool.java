package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.NailMapper;
import src.PowerToolMapper;

public class TestsPowerTool extends abstractTests {

	@Test
	public void testCreation() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFind()
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

}
