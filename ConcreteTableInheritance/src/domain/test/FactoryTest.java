package domain.test;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.InventoryItemFactory;
import domain.Nail;
import domain.PowerTool;
import domain.StripNails;
import domain.Tool;

public class FactoryTest {

	@Test
	public void test() {
		Nail nail = (Nail) InventoryItemFactory.Nail.buildItem("fart", -25, -25, -25,-25.0);
		assertTrue(nail.getId() == -27);
		assertTrue(nail.getLength() == -25.0);
		assertTrue(nail.getNumberInBox() == -25);
		
		PowerTool powerTool = (PowerTool) InventoryItemFactory.PowerTool.buildItem("fart", -25, -25, 1, "Not a tool");
		assertTrue(powerTool.getId() == -27);
		assertTrue(powerTool.getBatteryPowered());
		assertTrue(powerTool.getPrice() == -25);
		assertTrue(powerTool.getDescription().equals("Not a tool"));
		
		StripNails nails = (StripNails) InventoryItemFactory.StripNails.buildItem("fart", -25, -25,-50,-2.3);
		assertTrue(nails.getId() == -27);
		assertTrue(nails.getLength() == -2.3);
		assertTrue(nails.getNumPerStrip() == -50);
		
		Tool tool = (Tool) InventoryItemFactory.Tool.buildItem("fart", -25, -25,"nothing");
		assertTrue(tool.getId() == -27);
		assertTrue(tool.getDescription().equals("nothing"));
		assertTrue(tool.getPrice() == -25);
	}

}
