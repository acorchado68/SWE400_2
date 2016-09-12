package domain;

import java.util.ArrayList;

public class Nail extends Fastener {
	private int numberInBox;
	/**
	 * The ordinal of the column/entry in the arraylist for the number of nails in the box
	 */
	private static int COLUMN_NUMINBOX = 4;
	/**
	 * The ordinal of the column/entry in the arraylist for the length of the nail
	 */
	private static int COLUMN_LENGTH = 5;

	/**
	 * Creation constructor - not accessible outside of this package
	 * @see InventoryItemFactory
	 * @param objArray
	 *            an arraylist of objects that will be used to initialize this
	 *            Nail object
	 */
	protected Nail(ArrayList<Object> objArray) {
		super(objArray);
	}

	/**
	 * The "Finder" Constructor, calls a static method which calls the correct method from the InventoryItemCommand enumeration
	 * 
	 * @param id - the id of the desired row in the database
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
