package domain;
/**
 * String Assembler Enum - a "condensed" (maybe?) command pattern to help assemble strings
 * 	for inserting objects into the database
 * Each enumeration represents a column in some table in the database.
 * @author mb8542
 *	
 */
public enum StringAssemblerEnum implements SAEParent {

	UPC("upc") {
		public String getValue(InventoryItem i) {

			return "'"+i.getUpc()+"'";
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
			int ternaryInt = t.getBatteryPowered() ? 1 : 0;
			return ((Integer) ternaryInt).toString();

		}
	},
	LENGTH("length") {
		public String getValue(InventoryItem i) {
			Fastener f = (Fastener)i;
			return ((Double)f.getLength()).toString();
		}

	},
	NUMBERINSTRIP("numberInStrip") {
		public String getValue(InventoryItem i) {
			StripNails nail = (StripNails) i;
			return ((Integer) nail.getNumPerStrip()).toString();
		}

	},
	NUMBERINBOX("numberInBox") {
		public String getValue(InventoryItem i) {
			Nail nail = (Nail) i;
			return ((Integer) nail.getNumberInBox()).toString();
		}

	},
	/*ID("id")
	{


		public String getValue(InventoryItem i) {
			return ((Integer)InventoryItemCommand.getAvailableID()).toString();
		}
		
	},*/
	COMPATIBLE_POWERTOOLS("compatiblePowerTools")
	{

		@Override
		public String getValue(InventoryItem i) {
			return null;
		}
		
	},
	COMPATIBLE_STRIPNAILS("compatibleStripNails")
	{

		@Override
		public String getValue(InventoryItem i) {
			return null;
		}
		
	};

	
	private String columnName;
	/**
	 * 
	 * @param columnName
	 */
	StringAssemblerEnum(String columnName) {

		this.columnName = columnName;
	}

	protected String getColumn() {
		return columnName;
	}
	

}
