package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public enum InventoryItemCommand {

	/**
	 * Enumeration for Nail objects, provides methods for finding Nail records
	 * in the database and inserting Nail objects into the database
	 */
	Nail("Nail", "(upc,manufacturerId,price,numberInBox,length)", 6),
	/**
	 * Enumeration for PowerTool objects, provides methods for finding PowerTool
	 * records in the database and inserting PowerTool objects into the database
	 */
	PowerTool("PowerTool", "(upc,manufacturerId,price,batteryPowered,description,compatibleStripNails)", 7),
	/**
	 * Enumeration for StripNails objects, provides methods for finding
	 * StripNails records in the database and inserting StripNails objects into
	 * the database
	 */
	StripNails("StripNails", "(upc,manufacturerId,price,numberInStrip,length,compatiblePowerTools)", 7),
	/**
	 * Enumeration for Tool objects, provides methods for finding Tool records
	 * in the database and inserting Tool objects into the database
	 */
	Tool("Tool", "(upc,manufacturerId,price,description)", 5);

	private String tableName;
	private String valueString;
	private int numColumns;
	private static HashMap<String, StringAssemblerEnum> stringMap = null;
	private static Connection connection;
	protected static String uri = "jdbc:mysql://db.cs.ship.edu:3306/swe400-22?user=swe400_2&password=pwd4swe400_2F16";
	private String[] splitString;
	private static Statement statement;

	/**
	 * 
	 * @param tableName
	 *            - a string value that will be concatenated to form queries.
	 *            represents the name of the table for each enumeration/domain
	 *            object class
	 * @param valueString - a string value that will be concatenated to other strings to form queries. represents the columns surrounded by parentheses used in insert into statements
	 * @param numColumns - the number of columns in the corresponding table
	 */
	InventoryItemCommand(String tableName, String valueString, int numColumns) {
		this.tableName = tableName;
		this.valueString = valueString;
		this.numColumns = numColumns;
		splitString(valueString);
	}

	private void splitString(String valueString) {
		String temporaryString = String.copyValueOf(valueString.toCharArray());
		temporaryString = temporaryString.replaceAll("[)(]", "");
		splitString = temporaryString.split(",");
	}

	protected ArrayList<Object> find(int id) {
		return getRowList(id);
	}

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(uri);
			} catch (ClassNotFoundException e) {
				System.err.println("SQL Driver is Missing!");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return connection;
	}

	public static Statement getStatement() throws SQLException {
		if (statement == null) {
			statement = getConnection().createStatement();
		}
		return statement;
	}

	private ArrayList<Object> getRowList(int id) {
		try {
			getStatement();
			if (statement.execute("SELECT * FROM " + this.tableName + " WHERE id=" + id)) {
				ResultSet results = statement.getResultSet();
				results.first();
				ArrayList<Object> objArray = new ArrayList<Object>();
				for (int i = 1; i < this.numColumns + 1; i++) {
					objArray.add(results.getObject(i));
				}
				return objArray;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Object>();
	}

	protected boolean insert(InventoryItem in) {
		try {
			getStatement();
			statement.execute(assembleString(in));
			{
				// update id after insertion
				statement.execute("SELECT * FROM " + this.tableName + " WHERE upc='" + in.getUpc() + "'");
				ResultSet result = statement.getResultSet();
				result.first();
				in.setId(result.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private String assembleString(InventoryItem in) {
		String assembledString = "INSERT INTO " + this.tableName + " " + this.valueString + " VALUES (";
		for (int i = 0; i < this.splitString.length - 1; i++) {
			assembledString += getStringAssemblerEnum(this.splitString[i]).getValue(in) + ",";
		}
		assembledString += getStringAssemblerEnum(this.splitString[splitString.length - 1]).getValue(in);
		assembledString += ");";
		return assembledString;
	}

	private static void assembleStringMap() {
		stringMap = new HashMap<String, StringAssemblerEnum>();
		for (StringAssemblerEnum strEnum : StringAssemblerEnum.values()) {
			stringMap.put(strEnum.getColumn(), strEnum);
		}

	}

	private static StringAssemblerEnum getStringAssemblerEnum(String column) {
		if (stringMap == null) {
			assembleStringMap();
		}
		return stringMap.get(column);
	}

}
