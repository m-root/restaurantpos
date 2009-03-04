package brokers;

import java.util.ArrayList;
import DB.*;

public class ItemBroker implements Broker
{
    private static ItemBroker ib;
	ItemDB itemDB = new ItemDB();

	private ItemBroker()
	{
	}

	public static ItemBroker getBroker()
	{
		if(ib == null)
		{
			ib = new ItemBroker();
		}
		return ib;
	}

    public boolean saveAll(ArrayList a)
    {
        return itemDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return itemDB.remove(id);
    }

    public Object get(int id)
    {
        return itemDB.get(id);
    }

    public ArrayList getAll()
    {
        return itemDB.getAll();
    }

    public boolean save(Object o)
    {
        return itemDB.save(o);
    }
}