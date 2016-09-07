package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import src.*;
import org.junit.Test;

public class TestsNail extends abstractTests 
{	
	@Test
	public void test() throws SQLException 
	{
		NailMapper example = new NailMapper(5, "absolute", 5, 10, 6, 5);
		
	
	}

}
