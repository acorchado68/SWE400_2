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
	public Tool(ArrayList<Object> objArray) {
		super(objArray);
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.description = (String) objectArray.get(COLUMN_DESCRIPTION);

	}

	public String getDescription() {
		return description;
	}

	@Override
	protected boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Tool find(int id) {
		// TODO Auto-generated method stub
		return (Tool)null;
	}

}
