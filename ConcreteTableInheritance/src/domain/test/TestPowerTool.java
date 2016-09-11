package domain.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import domain.Nail;
import domain.PowerTool;

public class TestPowerTool extends CTITestCase {

	@Test
	public void testFinderConstructor() {
		PowerTool powerTool = new PowerTool(3);
		assertTrue(powerTool.getBatteryPowered());
		assertTrue(powerTool.getDescription().equals("Standard 10 inch table saw"));
		assertTrue(powerTool.getId() == 3);
	}

	@Test
	public void testCreationConstructor() throws SQLException
	{
		String fakeUpc = "99999999";
		objArray.clear();
		objArray.add(-27);
		objArray.add(fakeUpc);
		objArray.add(-5);
		objArray.add(-1999);
		objArray.add(0);
		objArray.add("'nothing'");
		PowerTool aTool = new PowerTool(objArray);
		aTool.insert();
		
		Statement statement = CTITestCase.connection.createStatement();
		statement.execute("SELECT * FROM PowerTool WHERE upc='"+fakeUpc+"'");
		resultSet = statement.getResultSet();
		resultSet.first();
		objArray.clear();
			for (int i = 1; i < 7; i++) {
				Object object = resultSet.getObject(i);
				objArray.add(object);
			}
			PowerTool tool = new PowerTool(objArray);
			
			assertTrue(tool.getId() > 0);
			assertTrue(tool.getPrice() == -1999);
			assertTrue(tool.getManufacturerId() == -5);
			assertFalse(tool.getBatteryPowered());
			assertTrue(tool.getDescription().equals("nothing"));
			objArray.clear();

	}
}
