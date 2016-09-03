
public class NailMapper extends AbstractFastenerMapper 
{

	public NailMapper(int id, String upc, int manufacturerID, int price, long length, int numberInBox) 
	{
		super(id, upc, manufacturerID, price, length);
	}

	public NailMapper(int id)
	{
		super(id);
	}
	
}
