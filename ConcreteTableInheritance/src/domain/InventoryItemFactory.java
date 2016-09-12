package domain;

import java.util.ArrayList;
/**
 * A "factory pattern" enum for building InventoryItem objects
 * Each type of InventoryItem object that has a corresponding table in the db has an enumeration here
 * @author gayyyy
 *
 */
public enum InventoryItemFactory implements FactoryInterface {
	Nail {

		/**
		 * Builds a Nail, the fourth and fifth parameters, with respect to order, should be (integer) numberInBox and (double) length
		 */
		@Override
		public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects) {
			staticTemporaryList.clear();
			addCommonParameters(upc,manufacturerId,price);
			for(Object o : objects)
				staticTemporaryList.add(o);
			return new Nail(staticTemporaryList);
		}
	},
	StripNails {

		/**
		 * Builds a StripNail, the fourth and fifth parameters, with respect to order, should be (integer) numberInStrip and (double) length
		 */
		@Override
		public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects) {
			staticTemporaryList.clear();
			addCommonParameters(upc,manufacturerId,price);
			for(Object o : objects)
				staticTemporaryList.add(o);
			return new StripNails(staticTemporaryList);
		}
	},
	Tool {
		/**
		 * Builds a Tool, the fourth parameter should be (String) description
		 */
		@Override
		public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects) {
			staticTemporaryList.clear();
			addCommonParameters(upc,manufacturerId,price);
			for(Object o : objects)
				staticTemporaryList.add(o);
			return new Tool(staticTemporaryList);
		}
	},
	PowerTool {
		/**
		 * Builds a PowerTool, the fourth parameter should be an integer value corresponding to if the tool is battery-powered and the fifth parameter
		 * should be a string representing the description
		 */
		@Override
		public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects) {
			staticTemporaryList.clear();
			addCommonParameters(upc,manufacturerId,price);
			for(Object o : objects)
				staticTemporaryList.add(o);
			return new PowerTool(staticTemporaryList);
		}
	};
	private static ArrayList<Object> staticTemporaryList = new ArrayList<Object>();
	InventoryItemFactory() {
		checkList();
	}
	protected void addCommonParameters(String upc, int manufacturerId, int price) {
		staticTemporaryList.add(-27); // see ID_NOT_ISSUED in InventoryItemCommand
		staticTemporaryList.add(upc);
		staticTemporaryList.add(manufacturerId);
		staticTemporaryList.add(price);
		
	}
	private static void checkList() {
		if(staticTemporaryList == null)
		{
			staticTemporaryList = new ArrayList<Object>();
		}
		
	}

}
