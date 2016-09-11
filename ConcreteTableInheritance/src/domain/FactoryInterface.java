package domain;

public interface FactoryInterface {
	public InventoryItem buildItem(String upc, int manufacturerId, int price, Object... objects);
}
