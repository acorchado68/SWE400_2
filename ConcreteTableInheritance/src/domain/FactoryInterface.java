package domain;

/**
 * The parent interface for the InventoryItemFactory enum
 * Contains method signatures that all enumerations in InventoryItemFactory must implement
 * @author mb8542
 *
 */
public interface FactoryInterface {
	public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects);
}
