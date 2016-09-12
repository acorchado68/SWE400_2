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
	private static Savepoint savePoint;
	/**
	 * Before
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@BeforeClass
	public static void before() throws SQLException, Exception {
		connection = InventoryItemCommand.getConnection();
		statement = InventoryItemCommand.getStatement();
		connection.setAutoCommit(false);
		if (objArray == null) {
			objArray = new ArrayList<Object>();
		}
		
		try {
			statement = connection.createStatement();
			/*statement.execute("START TRANSACTION");
			statement.execute("SAVEPOINT beginTest");*/
			savePoint = connection.setSavepoint();
			//populateTables();

		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	

	/**
	 * After
	 * 
	 * @throws SQLException
	 * @throws Exception
	 */
	@AfterClass
	public static void after() throws SQLException, Exception {
		connection.rollback(savePoint);
		//objArray.clear();
		// resultSet.close();
		// statement.close();
		// connection.close();

	}
}
