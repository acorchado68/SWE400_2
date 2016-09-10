package domain;

import java.util.ArrayList;

public abstract class Fastener extends InventoryItem {
	protected long length;

	public Fastener(ArrayList<Object> objectArray) {
		super(objectArray);
	}



	public long getLength() {
		return this.length;
	}
}
