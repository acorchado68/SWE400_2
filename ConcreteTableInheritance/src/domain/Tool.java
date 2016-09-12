package domain;

import java.util.ArrayList;

public class Tool extends InventoryItem {
	protected String description;
	/**
	 * The ordinal of the column/entry in the arraylist for the description of
	 * the tool
	 */
	private static int COLUMN_DESCRIPTION = 4;

	/**
	 * Creation constructor - not accessible outside of this package
	 * 
	 * @see InventoryItemFactory
	 * @param objArray
	 *            an arraylist of objects that will be used to initialize this
	 *            Tool object
	 */
	protected Tool(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor, calls a static method which calls the correct
	 * method from the InventoryItemCommand enumeration
	 * 
	 * @param id
	 *            - the id of the desired row in the database
	 */
	public Tool(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.description = (String) objectArray.get(COLUMN_DESCRIPTION);

	}

	public String getDescription() {
		return description;
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.Tool.find(id);
	}

	@Override
	public void insert() {
		InventoryItemCommand.Tool.insert(this);

	}

}
