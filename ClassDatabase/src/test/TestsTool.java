package test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import src.DBConnectionManager;
import src.NailMapper;
import src.ToolMapper;

public class TestsTool extends abstractTests{
	
	@Test
	public void testCreation() throws SQLException 
	{
		
	}
	
	@Test
	public void testFind()
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

}
