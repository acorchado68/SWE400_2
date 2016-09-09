package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public enum InventoryItemCommand {

	/**
	 * 
	 */
	Nail("Nail", ""), PowerTool("PowerTool", ""), StripNails("StripNail", ""), Tool("Tool", "");

	private String tableName;
	private String valueString;
	private static Connection connection = InventoryItem.getConnection();
	private static HashMap<String, StringAssemblerEnum> stringMap = null;

	InventoryItemCommand(String tableName, String valueString) {
		this.tableName = tableName;

	}

	protected ArrayList<Object> find(int id) {
		return getRowList(this, id);
	}

	private static ArrayList<Object> getRowList(InventoryItemCommand inventoryItemCommand, int id) {
		try {
			Statement statement = connection.createStatement();
			if (statement.execute("SELECT * FROM " + inventoryItemCommand.tableName + " WHERE id=" + id)) {
				ResultSet results = statement.getResultSet();
				results.first();
				ArrayList<Object> objArray = new ArrayList<Object>();
				for (int i = 1; i < 7; i++) {
					objArray.add(results.getObject(i));
				}
				return objArray;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Object>();
	}

	protected static boolean insert(InventoryItemCommand inventoryItemCommand, InventoryItem in) {
		try {

			Connection connection = InventoryItem.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(assembleString(inventoryItemCommand, in));
			statement.close();
		} catch (SQLException e) {

			return false;
		}
		return true;
	}

	private static String assembleString(InventoryItemCommand inventoryItemCommand, InventoryItem in) {

		String assembledString = "INSERT INTO " + inventoryItemCommand.tableName + " VALUES "
				+ inventoryItemCommand.valueString + " (";
		String temporaryString = String.copyValueOf(inventoryItemCommand.valueString.toCharArray());
		temporaryString.replaceAll("(", "");
		temporaryString.replaceAll(")", "");
		String[] split = inventoryItemCommand.valueString.split(",");
		for (String s : split) {
			assembledString += getStringAssemblerEnum(s).getValue(in);
		}
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
