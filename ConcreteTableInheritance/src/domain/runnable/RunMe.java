package domain.runnable;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import domain.InventoryItemFactory;
import domain.Nail;
import domain.PowerTool;
import domain.Tool;
import domain.InventoryItem;
import wellington.Nails;

public class RunMe {
	private static ArrayList<InventoryItem> inventoryItems;

	public static void main(String[] args) {
		inventoryItems = new ArrayList<InventoryItem>();
		for (Nails n : Nails.values()) {
			Nail aNail = (Nail) InventoryItemFactory.Nail.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getNumberInBox(), n.getLength());
			aNail.insert();
			inventoryItems.add(aNail);
		}

		for (wellington.StripNails n : wellington.StripNails.values()) {
			domain.StripNails aNail = (domain.StripNails) InventoryItemFactory.StripNails.buildItem(n.getUpc(),
					n.getManufacturerID(), n.getPrice(), n.getNumberInStrip(), n.getLength());
			aNail.insert();
			inventoryItems.add(aNail);
		}
		for (wellington.PowerTools n : wellington.PowerTools.values()) {
			PowerTool aPowerTool = (PowerTool) InventoryItemFactory.PowerTool.buildItem(n.getUpc(),
					n.getManufacturerID(), n.getPrice(), n.isBatteryPowered() ? 1 : 0, n.getDescription());
			aPowerTool.insert();
			inventoryItems.add(aPowerTool);
		}
		for (wellington.Tools n : wellington.Tools.values()) {

			Tool aTool = (Tool) InventoryItemFactory.Tool.buildItem(n.getUpc(), n.getManufacturerID(), n.getPrice(),
					n.getDescription());
			aTool.insert();
			inventoryItems.add(aTool);
		}
	}

}
