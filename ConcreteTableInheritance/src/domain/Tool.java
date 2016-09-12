package domain;

import java.util.ArrayList;

public class Tool extends InventoryItem {
	protected String description;
	private static int COLUMN_DESCRIPTION = 4;

	/**
	 * A constructor for tool
	 * 
	 * @param objArray
	 *            an arraylist of objects representing a row of data from the
	 *            Tool table
	 */
	protected Tool(ArrayList<Object> objArray) {
		super(objArray);
	}
	/**
	 * Finder constructor for tool, accepts an id and finds the corresponding row in the database
	 * @param id
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
