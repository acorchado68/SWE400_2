
public abstract class AbstractFastenerMapper extends AbstractInventoryItemMapper
{

	public AbstractFastenerMapper(int id, String upc, int manufacturerID, int price, long length) 
	{
		super(id, upc, manufacturerID, price);
	}
	
	public AbstractFastenerMapper(int id)
	{
		super(id);
	}

}
