package domain;

import java.util.ArrayList;
/**
 * Fastener
 * @author mb8542
 *
 */
public abstract class Fastener extends InventoryItem {
	protected double length;
	/**
	 * 
	 * @param objectArray
	 */
	protected Fastener(ArrayList<Object> objectArray) {
		super(objectArray);
	}



	public double getLength() {
		return this.length;
	}
}
