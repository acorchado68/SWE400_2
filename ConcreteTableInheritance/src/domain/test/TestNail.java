package domain.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import domain.Nail;
import domain.Tool;
import org.junit.After;
import org.junit.Before;

public class TestNail extends CTITestCase {
	private ArrayList<Nail> nails;

	/**
	 * This merely tests to see if data is successfully added to the Nail table.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPopulated() throws Exception {
		// CTITestCase.before();
		statement.execute("SELECT * FROM Nail");
		resultSet = this.statement.getResultSet();
		resultSet.first();
		nails = new ArrayList<Nail>();
		do {
			for (int i = 1; i < 7; i++) {

				Object object = resultSet.getObject(i);
				objArray.add(object);
			}
			Nail nail = new Nail(objArray);
			nails.add(nail);
			objArray.clear();

		} while (resultSet.next());

		for (Nail n : nails) {
			assertTrue(n.getId() > 0);
		}

	}

	@Test
	public void testFinderConstructor() {
		// BRIGHT_10D("4343412343", 27, 1899, 3, 750),
		Nail aNail = new Nail(2);
		assertTrue(aNail.getUpc().equals("4343412343"));
	}

}
