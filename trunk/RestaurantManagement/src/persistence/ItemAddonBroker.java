package persistence;

import java.util.ArrayList;


public class ItemAddonBroker implements Broker
{
    private static ItemAddonBroker iab;
	ItemAddonDB itemAddonDB = new ItemAddonDB();

	private ItemAddonBroker()
	{
	}

	public static ItemAddonBroker getBroker()
	{
		if(iab == null)
		{
			iab = new ItemAddonBroker();
		}
		return iab;
	}

    public boolean saveAll(ArrayList a)
    {
        return itemAddonDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return itemAddonDB.remove(id);
    }

    public Object get(int id)
    {
        return itemAddonDB.get(id);
    }

    public ArrayList getAll()
    {
        return itemAddonDB.getAll();
    }

    public boolean save(Object o)
    {
        return itemAddonDB.save(o);
    }
}