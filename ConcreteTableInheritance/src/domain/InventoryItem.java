package domain;

import java.util.ArrayList;

public abstract class InventoryItem {
	private int id;
	private int price;
	private int manufacturerId;
	private String upc;
	/**
	 * The ordinal of the column/entry in the arraylist for the id
	 */
	private static int COLUMN_ID = 0;
	/**
	 * The ordinal of the column/entry in the arraylist for the UPC
	 */
	private static int COLUMN_UPC = 1;
	/**
	 * The ordinal of the column/entry in the arraylist for the manufacturerID
	 */
	private static int COLUMN_MFGID = 2;
	/**
	 * The ordinal of the column/entry in the arraylist for the price
	 */
	private static int COLUMN_PRICE = 3;
	/**
	 * 'null' value to represent the ID for objects that have not yet been
	 * inserted into the database
	 */
	private static int NO_ID_ISSUED = -27;

	protected InventoryItem(ArrayList<Object> objectArray) {
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

		if ((Integer) objectArray.get(COLUMN_ID) == NO_ID_ISSUED) {
			this.id = NO_ID_ISSUED;
		} else {
			this.id = (Integer) objectArray.get(COLUMN_ID);
		}
		this.upc = (String) objectArray.get(COLUMN_UPC);
		this.manufacturerId = (Integer) objectArray.get(COLUMN_MFGID);
		this.price = (Integer) objectArray.get(COLUMN_PRICE);

	}

	/**
	 * Accessor for ID of this InventoryItem object
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
	 * constructor declared above Implementations will provide behavior for
	 * initializing class specific fields in objects that inherit from
	 * InventoryItem
	 * 
	 * @param objectArray
	 */
	protected abstract void handleUniqueColumn(ArrayList<Object> objectArray);

	/**
	 * This method will be implemented by subclasses, implementations will call
	 * the appropriate method/enumeration in the InventoryItemCommand enum to
	 * insert an object into the database
	 * 
	 * @param objectArray
	 */
	protected abstract void insert();

}
