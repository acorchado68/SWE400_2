package domain;

import java.util.ArrayList;

public class PowerTool extends Tool {
	private boolean batteryPowered;
	private static int COLUMN_DESCRIPTION = 5;
	private static int COLUMN_BATTERYPOWERED = 4;
	public PowerTool(ArrayList<Object> objArray) {
		super(objArray);
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray)
	{
		this.description = (String)objectArray.get(COLUMN_DESCRIPTION);
		this.batteryPowered = (boolean)objectArray.get(COLUMN_BATTERYPOWERED);
	}
	@Override
	protected boolean insert() {
		
		return false;
	}
	@Override
	protected PowerTool find(int id) {
		// TODO Auto-generated method stub
		return (PowerTool)null;
	}
}
