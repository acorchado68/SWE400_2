package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.PowerTool;

public class TestPowerTool extends CTITestCase {

	@Test
	public void testFinderConstructor() {
		PowerTool p = new PowerTool(1);
	}

}
