package domain;

import java.util.ArrayList;

public class PowerTool extends Tool {
	private boolean batteryPowered;
	/**
	 * The ordinal of the column/entry in the arraylist for the description of the power tool
	 */
	private static int COLUMN_DESCRIPTION = 5;
	/**
	 * The ordinal of the column/entry in the arraylist for the integer value representing the boolean value of whether or not the tool is battery powered
	 */
	private static int COLUMN_BATTERYPOWERED = 4;

	/**
	 * Creation constructor - not accessible outside of this package
	 * @see InventoryItemFactory
	 * @param objArray
	 *            an arraylist of objects that will be used to initialize this
	 *            PowerTool object
	 */
	protected PowerTool(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor, calls a static method which calls the correct method from the InventoryItemCommand enumeration
	 * 
	 * @param id - the id of the desired row in the database
	 */
	public PowerTool(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.description = (String) objectArray.get(COLUMN_DESCRIPTION);
		this.batteryPowered = ((Integer)objectArray.get(COLUMN_BATTERYPOWERED) > 0);
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.PowerTool.find(id);
	}

	public boolean getBatteryPowered() {
		return batteryPowered;
	}
	@Override
	public void insert() {
		
		InventoryItemCommand.PowerTool.insert(this);
	}
}
