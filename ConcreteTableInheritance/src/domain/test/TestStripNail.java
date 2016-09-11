package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.StripNails;

public class TestStripNail extends CTITestCase {

	@Test
	public void testFinderConstructorAndFields() {
		StripNails stripNail = new StripNails(2);
		assertTrue(stripNail.getNumPerStrip() == 75);
		assertTrue(stripNail.getLength() == 3);
	}

}
