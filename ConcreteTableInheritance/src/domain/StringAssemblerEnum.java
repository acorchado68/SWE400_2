package domain;

public enum StringAssemblerEnum implements SAEParent {

	UPC("upc") {
		public String getValue(InventoryItem i) {

			return i.getUpc();
		}
	},
	MFGID("manufacturerId") {

		public String getValue(InventoryItem i) {

			return ((Integer) i.getManufacturerId()).toString();
		}
	},
	PRICE("price") {
		public String getValue(InventoryItem i) {
			return ((Integer) i.getPrice()).toString();
		}

	},
	DESCRIPTION("description") {
		public String getValue(InventoryItem i) {
			Tool t = (Tool) i;
			return t.getDescription();
		}

	},
	BATTERYPOWERED("batteryPowered") {

		public String getValue(InventoryItem i) {
			
			PowerTool t = (PowerTool) i;
			int ternaryInt = t.getBatteryPowered() ? 0 : 1;
			return ((Integer) ternaryInt).toString();

		}
	},
	LENGTH("length") {
		public String getValue(InventoryItem i) {
			Fastener f = (Fastener)i;
			return ((Long)f.getLength()).toString();
		}

	},
	NUMBERINSTRIP("numPerStrip") {
		public String getValue(InventoryItem i) {
			StripNails nail = (StripNails) i;
			return ((Integer) nail.getNumPerStrip()).toString();
		}

	},
	NUMBERINBOX("numPerBox") {
		public String getValue(InventoryItem i) {
			Nail nail = (Nail) i;
			return ((Integer) nail.getNumberInBox()).toString();
		}

	};

	private String columnName;

	StringAssemblerEnum(String columnName) {

		this.columnName = columnName;
	}

	protected String getColumn() {
		return columnName;
	}
	

}
