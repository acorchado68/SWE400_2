package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.InventoryItemFactory;
import domain.Nail;
import domain.PowerTool;
import domain.StripNails;
import domain.Tool;

public class FactoryTest{

	/**
	 * This bloated test makes use of all the enumerations in the InventoryItemFactory enum to create InventoryItem objects
	 * It then checks a few fields on each to ensure that its getting real objects (the tests for the mutators/accessors are in TestInventoryItem,
	 * so this isnt as thorough)
	 */
	@Test
	public void testFactory() {
		Nail nail = (Nail) InventoryItemFactory.Nail.buildItem("notanitem", -25, -25, -25,-25.0);
		assertTrue(nail.getId() == -27);
		assertTrue(nail.getLength() == -25.0);
		assertTrue(nail.getNumberInBox() == -25);
		assertTrue(nail.getUpc().equals("notanitem"));
		
		PowerTool powerTool = (PowerTool) InventoryItemFactory.PowerTool.buildItem("notanitem", -25, -25, 1, "Not a tool");
		assertTrue(powerTool.getId() == -27);
		assertTrue(powerTool.getBatteryPowered());
		assertTrue(powerTool.getPrice() == -25);
		assertTrue(powerTool.getDescription().equals("Not a tool"));
		assertTrue(powerTool.getUpc().equals("notanitem"));
	
		StripNails nails = (StripNails) InventoryItemFactory.StripNails.buildItem("notanitem", -25, -25,-50,-2.3);
		assertTrue(nails.getId() == -27);
		assertTrue(nails.getLength() == -2.3);
		assertTrue(nails.getNumPerStrip() == -50);

		Tool tool = (Tool) InventoryItemFactory.Tool.buildItem("notanitem", -25, -25,"nothing");
		assertTrue(tool.getId() == -27);
		assertTrue(tool.getDescription().equals("nothing"));
		assertTrue(tool.getPrice() == -25);

	}

}
