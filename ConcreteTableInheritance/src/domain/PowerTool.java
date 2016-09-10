package domain;

import java.util.ArrayList;

public class PowerTool extends Tool {
	private boolean batteryPowered;
	private static int COLUMN_DESCRIPTION = 5;
	private static int COLUMN_BATTERYPOWERED = 4;

	public PowerTool(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor
	 * 
	 * @param id
	 */
	public PowerTool(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.description = (String) objectArray.get(COLUMN_DESCRIPTION);
		this.batteryPowered = (boolean) objectArray.get(COLUMN_BATTERYPOWERED);
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.PowerTool.find(id);
	}

	public boolean getBatteryPowered() {
		return batteryPowered;
	}
	@Override
	public void insert() {
		
		InventoryItemCommand.insert(InventoryItemCommand.PowerTool, this);
	}
}
