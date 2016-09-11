package domain.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import domain.Fastener;

public class TestFastener {

	@Test
	public void testFieldsViaMock() {
		ArrayList<Object> testArray = new ArrayList<Object>();
		{
			testArray.add((Integer)(-5));
			testArray.add(((Integer)(-5)).toString());
			testArray.add((Integer)(-5));
			testArray.add((Integer)(-5));
			testArray.add((Long)((long)-5));
		}
		MockFastener fastener = new MockFastener(testArray);
		assertTrue(fastener.getLength() == (long)-5);
		assertTrue(fastener.getId() == -5);
		assertTrue(fastener.getUpc().equals("-5"));
		assertTrue(fastener.getPrice() == -5);
		assertTrue(fastener.getManufacturerId() == -5);
	}

}
class MockFastener extends Fastener{
	private static int COLUMN_LENGTH = 4;
	protected MockFastener(ArrayList<Object> objArray)
	{
		super(objArray);
	}

	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		this.length = (Long) objectArray.get(COLUMN_LENGTH);
	}

	@Override
	protected void insert() {
		
		return;
	}
}
