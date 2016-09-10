package domain;

import java.util.ArrayList;

public class StripNails extends Fastener {

	private int numPerStrip;

	public StripNails(ArrayList<Object> objectArray) {
		super(objectArray);
	}

	public StripNails(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		
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
