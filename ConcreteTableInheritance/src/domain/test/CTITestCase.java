package domain.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import domain.InventoryItemCommand;

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
	private static Savepoint savePoint;

	/**
	 * Before sets up the connection, statement and a savepoint for reverting
	 * later
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@BeforeClass
	public static void before() {
		if (objArray == null) {
			objArray = new ArrayList<Object>();
		}
		try {
			connection = InventoryItemCommand.getConnection();
			statement = InventoryItemCommand.getStatement();
			connection.setAutoCommit(false);
			statement = connection.createStatement();
			savePoint = connection.setSavepoint();

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * After rollsback the changes, re-enables auto-commit, opens a new
	 * statement and resets the auto_increment values using that statement. Then
	 * it closes the connection/statement before finishing
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@AfterClass
	public static void after() throws SQLException, Exception {
		connection.rollback(savePoint);
		connection.setAutoCommit(true);
		statement.close();
		statement = InventoryItemCommand.getStatement();
		String[] paramArray = { ".Nail", ".Tool", ".PowerTool", ".StripNails" };
		for (String s : paramArray) {
			statement.execute("ALTER TABLE `swe400-22`" + s + " AUTO_INCREMENT=1;");
		}
		statement.close();
		connection.close();
	}
}
