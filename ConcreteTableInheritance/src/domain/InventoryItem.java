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
	private static int NO_ID_ISSUED = -27;
	public InventoryItem(ArrayList<Object> objectArray) {
		if (objectArray.isEmpty()) {
			this.id = -9999;
			this.price = -1;
			this.manufacturerId = -1;
			this.upc = "NOT AN ITEM/DOES NOT EXIST";
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

		if((Integer)objectArray.get(COLUMN_ID) == NO_ID_ISSUED)
		{
			this.id = NO_ID_ISSUED;
		}else{
			this.id = (Integer) objectArray.get(COLUMN_ID);
		}
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
