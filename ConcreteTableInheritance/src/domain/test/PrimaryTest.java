package domain.test;
import domain.InventoryItemFactory;
import domain.Nail;
import domain.PowerTool;
import domain.StripNails;
import domain.Tool;
import wellington.Nails;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PrimaryTest extends CTITestCase{

	@Test
	public void testNail() {
		ArrayList<Nail> nailArray = new ArrayList<Nail>();
		for(Nails n : Nails.values())
		{
			nailArray.add((Nail) InventoryItemFactory.Nail.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(), n.getNumberInBox(), n.getLength()));
		}
		for(Nail n : nailArray)
		{
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(n.getLength() > 0);
			assertTrue(n.getNumberInBox() > 0);
		}
	}

	@Test
	public void testStripNails() {
		ArrayList<domain.StripNails> stripNailArray = new ArrayList<domain.StripNails>();
		for(wellington.StripNails n : wellington.StripNails.values())
		{
			stripNailArray.add((StripNails) InventoryItemFactory.StripNails.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(), n.getNumberInStrip(),n.getLength()));
		}
		for(StripNails n : stripNailArray)
		{
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(n.getLength() > 0);
			assertTrue(n.getNumPerStrip() > 0);
		}
	}
	
	@Test
	public void testPowerTool() {
		ArrayList<PowerTool> powerToolArray = new ArrayList<PowerTool>();
		for(wellington.PowerTools n : wellington.PowerTools.values())
		{
			powerToolArray.add((PowerTool) InventoryItemFactory.PowerTool.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(), n.isBatteryPowered() ? 1 : 0 ,n.getDescription()));
		}
		for(PowerTool n : powerToolArray)
		{
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(!n.getDescription().equals(null));
		}
	}
	
	@Test
	public void testTool() {
		ArrayList<Tool> toolArray = new ArrayList<Tool>();
		for(wellington.Tools n : wellington.Tools.values())
		{
			toolArray.add((Tool) InventoryItemFactory.Tool.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(), n.getDescription()));
		}
		for(Tool n : toolArray)
		{
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(!n.getDescription().equals(null));
		}
	}
}
