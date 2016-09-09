package domain;

import java.util.ArrayList;

public class StripNails extends Fastener {

	public StripNails(ArrayList<Object> objectArray) {
		super(objectArray);
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {

	}

	@Override
	protected boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected StripNails find(int id) {
		return (StripNails) null;
	}

}
