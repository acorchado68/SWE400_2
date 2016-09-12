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

public class PrimaryTest extends CTITestCase {

	/**
	 * This test iterates through Dr. Wellingtons Nails enumeration, creates a
	 * corresponding Nail object via the inventoryitemfactory, inserts each one into the database then checks
	 * to see if the ID in the object has been updated. It also checks the
	 * unique fields for the Nail class. Then it instantiates a new Nail object
	 * using the finder constructor, passing in the id from the object
	 * originally added to the database. It checks to see if the id it gets back
	 * in the new object is the same (as it will obtain it via a SELECT query in
	 * InventoryItemCommand)
	 */
	@Test
	public void testNail() {
		ArrayList<Nail> nailArray = new ArrayList<Nail>();
		for (Nails n : Nails.values()) {
			nailArray.add((Nail) InventoryItemFactory.Nail.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getNumberInBox(), n.getLength()));
		}
		for (Nail n : nailArray) {
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(n.getLength() > 0);
			assertTrue(n.getNumberInBox() > 0);
			domain.Nail aNewNail = new domain.Nail(n.getId());
			assertTrue(aNewNail.getId() == n.getId());
		}
	}

	/**
	 * Same test as TestNail except for StripNails
	 * @see testNail
	 * 
	 */
	@Test
	public void testStripNails() {
		ArrayList<domain.StripNails> stripNailArray = new ArrayList<domain.StripNails>();
		for (wellington.StripNails n : wellington.StripNails.values()) {
			stripNailArray.add((StripNails) InventoryItemFactory.StripNails.buildItem(n.getUpc(), n.getManufacturerID(),
					n.getPrice(), n.getNumberInStrip(), n.getLength()));
		}
		for (StripNails n : stripNailArray) {
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(n.getLength() > 0);
			assertTrue(n.getNumPerStrip() > 0);
			domain.StripNails aNewNail = new domain.StripNails(n.getId());
			assertTrue(aNewNail.getId() == n.getId());
		}
	}
	/**
	 * @see testNail - same things except for power tools
	 */
	@Test
	public void testPowerTool() {
		ArrayList<PowerTool> powerToolArray = new ArrayList<PowerTool>();
		for (wellington.PowerTools n : wellington.PowerTools.values()) {
			powerToolArray.add((PowerTool) InventoryItemFactory.PowerTool.buildItem(n.getUpc(), n.getManufacturerID(),
					n.getPrice(), n.isBatteryPowered() ? 1 : 0, n.getDescription()));
		}
		for (PowerTool n : powerToolArray) {
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(!n.getDescription().equals(null));
			domain.PowerTool aNewTool = new domain.PowerTool(n.getId());
			assertTrue(aNewTool.getId() == n.getId());
		}
	}
	/**
	 * @see testNail - same things except for power tools
	 */
	@Test
	public void testTool() {
		ArrayList<Tool> toolArray = new ArrayList<Tool>();
		for (wellington.Tools n : wellington.Tools.values()) {
			toolArray.add((Tool) InventoryItemFactory.Tool.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getDescription()));
		}
		for (Tool n : toolArray) {
			n.insert();
			assertTrue(n.getId() > 0);
			assertTrue(!n.getDescription().equals(null));
			domain.Tool aNewTool = new domain.Tool(n.getId());
			assertTrue(aNewTool.getId() == n.getId());
		}
	}
}
