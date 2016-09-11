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
	private String[] splitString;

	InventoryItemCommand(String tableName, String valueString,int numColumns) {
		this.tableName = tableName;
		this.valueString = valueString;
		this.numColumns = numColumns;
		splitString(valueString);
	}

	private void splitString(String valueString) {
		String temporaryString = String.copyValueOf(valueString.toCharArray());
		temporaryString = temporaryString.replaceAll("[)(]","");
		splitString = temporaryString.split(",");
	}
	private String[] getSplitString()
	{
		return splitString;
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

	private ArrayList<Object> getRowList(int id) {
		try {
			Statement statement = connection.createStatement();
			if (statement.execute("SELECT * FROM " + this.tableName + " WHERE id=" + id)) {
				ResultSet results = statement.getResultSet();
				results.first();
				ArrayList<Object> objArray = new ArrayList<Object>();
				for (int i = 1; i < this.numColumns+1; i++) {
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

	protected boolean insert( InventoryItem in) {
		try {
			Statement statement = connection.createStatement();
			statement.execute("START TRANSACTION");
			statement.execute(assembleString(in));
			statement.execute("COMMIT");
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}


	private String assembleString(InventoryItem in) {
		String assembledString = "INSERT INTO " + this.tableName 
				+ " " +  this.valueString + " VALUES (";
		for (int i = 0; i < this.splitString.length-1; i++) {
			assembledString += getStringAssemblerEnum(this.splitString[i]).getValue(in) + ",";
		}
		assembledString += getStringAssemblerEnum(this.splitString[splitString.length-1]).getValue(in);
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
