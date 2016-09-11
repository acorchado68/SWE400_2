package domain.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		//CTITestCase.before();
		Statement statement = CTITestCase.connection.createStatement();
		statement.execute("SELECT * FROM Nail");
		resultSet = statement.getResultSet();
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
			assertTrue(n.getLength() > 0.0);
			assertTrue(n.getNumberInBox() > 0);
		}

	}

	@Test
	public void testFinderConstructor() {
		// BRIGHT_10D("4343412343", 27, 1899, 3, 750),
		Nail aNail = new Nail(2);
		assertTrue(aNail.getUpc().equals("4343412343"));
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
		objArray.add(5);
		objArray.add((Double)2.0);
		Nail aNail = new Nail(objArray);
		aNail.insert();
		
		Statement statement = CTITestCase.connection.createStatement();
		statement.execute("SELECT * FROM Nail WHERE upc='"+fakeUpc+"'");
		resultSet = statement.getResultSet();
		resultSet.first();
		objArray.clear();
			for (int i = 1; i < 7; i++) {
				Object object = resultSet.getObject(i);
				objArray.add(object);
			}
			Nail nail = new Nail(objArray);
			
			assertTrue(nail.getId() > 0);
			assertTrue(nail.getLength() == 2.0);
			assertTrue(nail.getPrice() == -1999);
			assertTrue(nail.getManufacturerId() == -5);
			assertTrue(nail.getNumberInBox() == 5);
			objArray.clear();

	}

}
