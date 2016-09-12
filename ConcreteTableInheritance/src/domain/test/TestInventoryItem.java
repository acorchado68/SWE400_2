package domain.test;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

import domain.InventoryItem;

public class TestInventoryItem{

	@Test
	public void testFields() {
		MockInventoryItem mockItem = new MockInventoryItem();
		assertTrue(mockItem.getId() == -9999);
		assertTrue(mockItem.getManufacturerId() == -1);
		assertTrue(mockItem.getPrice() == -1);
		assertTrue(mockItem.getUpc().equals("NOT AN ITEM/DOES NOT EXIST"));
		ArrayList<Object> objArray = new ArrayList<Object>();
		
		{
			objArray.add(((Integer)(-5)));
			objArray.add(((Integer)(-5)).toString());
			objArray.add(((Integer)(-5)));
			objArray.add(((Integer)(-5)));
		}
			mockItem = new MockInventoryItem(objArray);
			
		assertTrue(mockItem.getId() == -5);
		assertTrue(mockItem.getManufacturerId() == -5);
		assertTrue(mockItem.getPrice() == -5);
		assertTrue(mockItem.getUpc().equals("-5"));	
		
		mockItem = new MockInventoryItem();
		mockItem.allMutatorsNegativeFive();
		assertTrue(mockItem.getId() == -5);
		assertTrue(mockItem.getManufacturerId() == -5);
		assertTrue(mockItem.getPrice() == -5);
		assertTrue(mockItem.getUpc().equals("-5"));	
	}

}
class MockInventoryItem extends InventoryItem
{

	MockInventoryItem()
	{
		super(new ArrayList<Object>());
	}
	public MockInventoryItem(ArrayList<Object> objArray) {
		super(objArray);
	}
	@Override
	protected void handleUniqueColumn(ArrayList<Object> objectArray) {
		return;
	}
	@Override
	protected void insert() {
		return;
		
	}
	
	protected void allMutatorsNegativeFive()
	{
		this.setId(-5);
		this.setManufacturerId(-5);
		this.setPrice(-5);
		this.setUpc("-5");
	}
	
}