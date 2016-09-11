package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.PowerTool;

public class TestPowerTool extends CTITestCase {

	@Test
	public void testFinderConstructor() {
		PowerTool powerTool = new PowerTool(3);
		assertTrue(powerTool.getBatteryPowered());
		assertTrue(powerTool.getDescription().equals("Standard 10 inch table saw"));
		assertTrue(powerTool.getId() == 3);
	}

}
