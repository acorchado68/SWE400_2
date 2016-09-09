package domain.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import static org.junit.Assert.*;
import org.junit.Test;
import domain.InventoryItem;
import junit.framework.TestCase;

public class TestInventoryItem extends CTITestCase {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet nailResultSet = null;
	private ResultSet stripNailResultSet = null;
	private ResultSet powerToolResultSet = null;
	private ResultSet toolResultSet = null;
	private ResultSet nailPowerToolUnionRS = null;

	@Test
	public void test() {
		fail("not yet implemented");
	}

}