package domain;

import java.util.ArrayList;

public abstract class Fastener extends InventoryItem {
	protected double length;
	
	public Fastener(ArrayList<Object> objectArray) {
		super(objectArray);
	}



	public double getLength() {
		return this.length;
	}
}
