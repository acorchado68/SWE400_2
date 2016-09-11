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
	 * 
	 */
	Nail("Nail", "(upc,manufacturerId,price,numberInBox,length)",6), PowerTool("PowerTool", "(upc,manufacturerId,price,batteryPowered,description,compatibleStripNails)",7), StripNails("StripNails", "(upc,manufacturerId,price,numberInStrip,length,compatiblePowerTools)",7), Tool("Tool", "(upc,manufacturerId,price,description)",5);

	private String tableName;
	private String valueString;
	private int numColumns;
	private static HashMap<String, StringAssemblerEnum> stringMap = null;
	private static Connection connection;
	protected static String uri = "jdbc:mysql://db.cs.ship.edu:3306/swe400-22?user=swe400_2&password=pwd4swe400_2F16";
	private static int availableID;

	protected static int getAvailableID() {
		return availableID;
	}
	InventoryItemCommand(String tableName, String valueString,int numColumns) {
		this.tableName = tableName;
		this.valueString = valueString;
		this.numColumns = numColumns;
	}

	protected ArrayList<Object> find(int id) {
		return getRowList(this, id);
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

	private static ArrayList<Object> getRowList(InventoryItemCommand inventoryItemCommand, int id) {
		try {
			Statement statement = connection.createStatement();
			if (statement.execute("SELECT * FROM " + inventoryItemCommand.tableName + " WHERE id=" + id)) {
				ResultSet results = statement.getResultSet();
				results.first();
				ArrayList<Object> objArray = new ArrayList<Object>();
				for (int i = 1; i < inventoryItemCommand.numColumns+1; i++) {
					objArray.add(results.getObject(i));
				}
				statement.close();
				return objArray;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Object>();
	}

	protected static boolean insert(InventoryItemCommand inventoryItemCommand, InventoryItem in) {
		try {
			Statement statement = connection.createStatement();
			statement.execute("START TRANSACTION");
			statement.execute(assembleString(inventoryItemCommand, in));
			statement.execute("COMMIT");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	private static String assembleString(InventoryItemCommand inventoryItemCommand, InventoryItem in) {
		String assembledString = "INSERT INTO " + inventoryItemCommand.tableName 
				+ inventoryItemCommand.valueString + " VALUES (";
		String temporaryString = String.copyValueOf(inventoryItemCommand.valueString.toCharArray());
		temporaryString = temporaryString.replaceAll("[)(]","");
		String[] split = temporaryString.split(",");
		for (int i = 0; i < split.length-1; i++) {
			assembledString += getStringAssemblerEnum(split[i]).getValue(in) + ",";
		}
		assembledString += getStringAssemblerEnum(split[split.length-1]).getValue(in);
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
