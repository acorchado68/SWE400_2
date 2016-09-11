package domain;

import java.util.ArrayList;

public class StripNails extends Fastener {

	private int numPerStrip;
	private static int COLUMN_NUMPERSTRIP = 4;
	private static int COLUMN_LENGTH = 5;
	public StripNails(ArrayList<Object> objectArray) {
		super(objectArray);
	}

	public StripNails(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.numPerStrip = (Integer)objectArray.get(COLUMN_NUMPERSTRIP);
		this.length = (Double)objectArray.get(COLUMN_LENGTH);
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.StripNails.find(id);
	}

	public Integer getNumPerStrip() {
		return numPerStrip;
	}

	@Override
	public void insert() {
		InventoryItemCommand.insert(InventoryItemCommand.StripNails, this);
		
	}
}
