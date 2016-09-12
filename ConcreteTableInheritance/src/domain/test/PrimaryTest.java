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
	 * corresponding Nail object via the InventoryItemFactory, inserts each one
	 * into the database then checks to see if the ID in the object has been
	 * updated. It also checks the unique fields for the Nail class. Then it
	 * instantiates a new Nail object using the finder constructor, passing in
	 * the id from the object originally added to the database. It checks to see
	 * if the id it gets back in the new object is the same (as it will be
	 * obtained via a SELECT query in InventoryItemCommand)
	 */
	@Test
	public void testNail() {

		for (Nails n : Nails.values()) {
			Nail aNail = (Nail) InventoryItemFactory.Nail.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getNumberInBox(), n.getLength());
			aNail.insert();
			{
				assertEquals(n.getLength(), aNail.getLength(), 0.0001);
				assertEquals(n.getManufacturerID(), aNail.getManufacturerId());
				assertEquals(n.getNumberInBox(), aNail.getNumberInBox());
				assertEquals(n.getPrice(), aNail.getPrice());
				assertEquals(n.getUpc(), aNail.getUpc());
			}
			domain.Nail aNewNail = new domain.Nail(aNail.getId());
			{
				assertEquals(aNewNail.getLength(), aNail.getLength(), 0.0001);
				assertEquals(aNewNail.getManufacturerId(), aNail.getManufacturerId());
				assertEquals(aNewNail.getNumberInBox(), aNail.getNumberInBox());
				assertEquals(aNewNail.getPrice(), aNail.getPrice());
				assertEquals(aNewNail.getUpc(), aNail.getUpc());
			}
		}
	}

	/**
	 * Same test as TestNail except for StripNails
	 * 
	 * @see testNail
	 * 
	 */
	@Test
	public void testStripNails() {

		for (wellington.StripNails n : wellington.StripNails.values()) {

			domain.StripNails aNail = (domain.StripNails) InventoryItemFactory.StripNails.buildItem(n.getUpc(),
					n.getManufacturerID(), n.getPrice(), n.getNumberInStrip(), n.getLength());
			aNail.insert();
			{
				assertEquals(n.getLength(), aNail.getLength(), 0.0001);
				assertEquals(n.getManufacturerID(), aNail.getManufacturerId());
				assertEquals(n.getNumberInStrip(), aNail.getNumPerStrip());
				assertEquals(n.getPrice(), aNail.getPrice());
				assertEquals(n.getUpc(), aNail.getUpc());
			}
			domain.StripNails aNewNail = new domain.StripNails(aNail.getId());
			{
				assertEquals(aNewNail.getLength(), aNail.getLength(), 0.0001);
				assertEquals(aNewNail.getManufacturerId(), aNail.getManufacturerId());
				assertEquals(aNewNail.getNumPerStrip(), aNail.getNumPerStrip());
				assertEquals(aNewNail.getPrice(), aNail.getPrice());
				assertEquals(aNewNail.getUpc(), aNail.getUpc());
			}
		}
	}

	/**
	 * @see testNail - same things except for power tools
	 */
	@Test
	public void testPowerTool() {
		ArrayList<PowerTool> powerToolArray = new ArrayList<PowerTool>();
		for (wellington.PowerTools n : wellington.PowerTools.values()) {

			PowerTool aPowerTool = (PowerTool) InventoryItemFactory.PowerTool.buildItem(n.getUpc(),
					n.getManufacturerID(), n.getPrice(), n.isBatteryPowered() ? 1 : 0, n.getDescription());
			aPowerTool.insert();
			{
				assertEquals(n.isBatteryPowered(), aPowerTool.getBatteryPowered());
				assertEquals(n.getManufacturerID(), aPowerTool.getManufacturerId());
				assertEquals(n.getDescription(), aPowerTool.getDescription());
				assertEquals(n.getPrice(), aPowerTool.getPrice());
				assertEquals(n.getUpc(), aPowerTool.getUpc());
			}
			PowerTool aNewTool = new PowerTool(aPowerTool.getId());
			{
				assertEquals(n.isBatteryPowered(), aPowerTool.getBatteryPowered());
				assertEquals(aNewTool.getManufacturerId(), aPowerTool.getManufacturerId());
				assertEquals(aNewTool.getDescription(), aPowerTool.getDescription());
				assertEquals(aNewTool.getPrice(), aPowerTool.getPrice());
				assertEquals(aNewTool.getUpc(), aPowerTool.getUpc());
			}
		}
	}

	/**
	 * @see testNail - same things except for power tools
	 */
	@Test
	public void testTool() {
		for (wellington.Tools n : wellington.Tools.values()) {

			Tool aTool = (Tool) InventoryItemFactory.Tool.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getDescription());
			aTool.insert();
			{
				assertEquals(n.getManufacturerID(), aTool.getManufacturerId());
				assertEquals(n.getDescription(), aTool.getDescription());
				assertEquals(n.getPrice(), aTool.getPrice());
				assertEquals(n.getUpc(), aTool.getUpc());
			}
			Tool aNewTool = new Tool(aTool.getId());
			{
				assertEquals(aNewTool.getManufacturerId(), aTool.getManufacturerId());
				assertEquals(aNewTool.getDescription(), aTool.getDescription());
				assertEquals(aNewTool.getPrice(), aTool.getPrice());
				assertEquals(aNewTool.getUpc(), aTool.getUpc());
			}

		}
	}
}
