package domain;

/**
 * SAE (StringAssemblerEnum) Parent Interface contains signatures
 * for methods that all enumerations in the StringAssemblerEnum must implement
 * 
 * @author mb8542
 *
 */
public interface SAEParent {
	/**
	 * getValue - a method that all enumerations in SAE will implement to get
	 * a string value from an Inventory Item to insert into the table
	 * 
	 * @param i - the InventoryItem that this method will get values from
	 * @return a string representing the desired value from the InventoryItem, not necessarily assembled in a cleanly manner
	 */
	public abstract String getValue(InventoryItem i);
}
