package domain.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Nail;
import domain.Tool;

public class TestTool extends CTITestCase {

	@Test
	public void testFinderConstructor() {

		Tool aTool = new Tool(2);
		assertTrue(aTool.getUpc().equals("1232343345"));
		assertTrue(aTool.getDescription().equals("Ten piece screwdriver set"));
	}

}
