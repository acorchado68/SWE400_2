package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class InventoryItem {
	private int id;
	private int price;
	private int manufacturerId;
	private String upc;
	private static int COLUMN_ID = 0;
	private static int COLUMN_UPC = 1;
	private static int COLUMN_MFGID = 2;
	private static int COLUMN_PRICE = 3;
	protected static String uri = "jdbc:mysql://db.cs.ship.edu:3306/swe400-22?"
			+ "user=swe400_2&password=pwd4swe400_2F16";
	private static Connection connection;

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

	protected InventoryItem() {
		id = -9999;
		price = -1;
		manufacturerId = -1;
		upc = "NOT AN ITEM/DOES NOT EXIST";
	}

	public InventoryItem(ArrayList<Object> objectArray) {
		if (objectArray.isEmpty()) {
			this.id = -99999;
			price = -1;
			manufacturerId = -1;
			upc = "NOT AN ITEM/DOES NOT EXIST";
		} else {
			parseParameterObjects(objectArray);
			handleUniqueColumn(objectArray);
		}

	}

	/**
	 * A really gross helper method for the constructor
	 * 
	 * @param objectArray
	 *            - the array of objects from a row in the database
	 */
	private void parseParameterObjects(ArrayList<Object> objectArray) {

		this.id = (Integer) objectArray.get(COLUMN_ID);
		this.upc = (String) objectArray.get(COLUMN_UPC);
		this.manufacturerId = (Integer) objectArray.get(COLUMN_MFGID);
		this.price = (Integer) objectArray.get(COLUMN_PRICE);

	}

	/**
	 * Mutators and accessors (getters/setters) below
	 */
	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	protected void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getUpc() {
		return upc;
	}

	protected void setUpc(String upc) {
		this.upc = upc;
	}

	/**
	 * Signatures
	 */

	/**
	 * This method will be implemented by subclasses, but only executed in the
	 * constructor declared above
	 * 
	 * @param objectArray
	 */
	protected abstract void handleUniqueColumn(ArrayList<Object> objectArray);
	protected abstract void insert();
	

}
