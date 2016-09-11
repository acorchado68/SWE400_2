package domain;

import java.util.ArrayList;

public enum InventoryItemFactory implements FactoryInterface {
	Nail {

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
