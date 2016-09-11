package domain.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;

import domain.InventoryItem;
import domain.InventoryItemCommand;
import domain.Nail;
import junit.framework.TestCase;
import wellington.*;

/**
 * 
 * @author mb8542
 *
 */
public class CTITestCase {

	protected static Connection connection;
	protected static Statement statement;
	protected static ResultSet resultSet;
	protected static ArrayList<Object> objArray = null;

	/**
	 * Before
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@Before
	public void before() throws SQLException, Exception {
		connection = InventoryItemCommand.getConnection();
		if (objArray == null) {
			objArray = new ArrayList<Object>();
		}
		/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = InventoryItemCommand.getConnection();
			statement = connection.createStatement();
			statement.execute("START TRANSACTION");
			populateTables();

		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {

		}*/
	}

	/**
	 * A helper method to populate the tables w/ known data its very gross,
	 * probably should work a way out to condense the for loops
	 * 
	 * @throws SQLException
	 */
	/*private static void populateTables() throws SQLException {
		for (Nails nail : Nails.values()) {

			statement.execute("INSERT INTO Nail (upc,manufacturerID,price,numberInBox,length) VALUES (" + nail.getUpc()
					+ "," + nail.getManufacturerID() + "," + nail.getPrice() + "," + nail.getNumberInBox() + ","
					+ nail.getLength() + ");");
		}

		for (Tools tool : Tools.values()) {
			String executeMe = "INSERT INTO Tool (upc,manufacturerID,price,description) VALUES (" + tool.getUpc() + ","
					+ tool.getManufacturerID() + "," + tool.getPrice() + ",\'" + tool.getDescription() + "\');";
			statement.execute(executeMe);
		}

		

		for (StripNails nail : StripNails.values()) {
			statement.execute("INSERT INTO StripNails (upc,manufacturerID,price,numberInStrip,length) VALUES (" + nail.getUpc()
					+ "," + nail.getManufacturerID() + "," + nail.getPrice() + "," + nail.getNumberInStrip() + ","
					+ nail.getLength() + ");");
		}
		for (PowerTools powerTool : PowerTools.values()) { // make sure you take
															// a look at the
															// ternary
															// conditional down
															// there :/
			statement.execute("INSERT INTO PowerTool (upc,manufacturerID,price,batterypowered,description) VALUES (" + powerTool.getUpc()
					+ "," + powerTool.getManufacturerID() + "," + powerTool.getPrice() + ","
					+ (powerTool.isBatteryPowered() ? 0 : 1) + ",\'"+powerTool.getDescription()+"\');");
		}

	}*/

	/**
	 * After
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@After
	public void after() throws SQLException, Exception {
		//statement.execute("COMMIT");
		//objArray.clear();
		// resultSet.close();
		// statement.close();
		// connection.close();

	}
}
