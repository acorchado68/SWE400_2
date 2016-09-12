package domain;

import java.util.ArrayList;

public class StripNails extends Fastener {

	private int numPerStrip;
	/**
	 * The ordinal of the column/entry in the arraylist for the number of strip
	 * nails per strip
	 */
	private static int COLUMN_NUMPERSTRIP = 4;
	/**
	 * The ordinal of the column/entry in the arraylist for length of the strip
	 * nails
	 */
	private static int COLUMN_LENGTH = 5;

	/**
	 * Creation constructor - not accessible outside of this package
	 * @see InventoryItemFactory
	 * @param objArray
	 *            an arraylist of objects that will be used to initialize this
	 *            StripNails object
	 */
	protected StripNails(ArrayList<Object> objectArray) {
		super(objectArray);
	}

	/**
	 * The "Finder" Constructor, calls a static method which calls the correct
	 * method from the InventoryItemCommand enumeration
	 * 
	 * @param id
	 *            - the id of the desired row in the database
	 */
	public StripNails(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.numPerStrip = (Integer) objectArray.get(COLUMN_NUMPERSTRIP);
		this.length = (Double) objectArray.get(COLUMN_LENGTH);
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.StripNails.find(id);
	}

	public Integer getNumPerStrip() {
		return numPerStrip;
	}

	@Override
	public void insert() {
		InventoryItemCommand.StripNails.insert(this);

	}
}
