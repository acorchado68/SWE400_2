package domain;

import java.util.ArrayList;

public class Nail extends Fastener {
	private int numberInBox;
	private static int COLUMN_NUMINBOX = 4;
	private static int COLUMN_LENGTH = 5;

	/**
	 * Creation constructor
	 * 
	 * @param objArray
	 */
	public Nail(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor
	 * 
	 * @param id
	 */
	public Nail(int id) {
		this(findList(id));
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.setNumberInBox((Integer) objectArray.get(COLUMN_NUMINBOX));
		this.length = (Double) objectArray.get(COLUMN_LENGTH);
	}

	private static ArrayList<Object> findList(int id) {
		return InventoryItemCommand.Nail.find(id);
	}

	public int getNumberInBox() {
		return numberInBox;
	}

	protected void setNumberInBox(int numberInBox) {
		this.numberInBox = numberInBox;
	}

	@Override
	public void insert() {
		InventoryItemCommand.Nail.insert(this);
		
	}

}
