package brokers;

import java.util.ArrayList;
import DB.*;

public class MenuBroker implements Broker
{
    private static MenuBroker mb;
	MenuDB menuDB = new MenuDB();

	private MenuBroker()
	{
	}

	public static MenuBroker getBroker()
	{
		if(mb == null)
		{
			mb = new MenuBroker();
		}
		return mb;
	}

    public boolean saveAll(ArrayList a)
    {
        return menuDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return menuDB.remove(id);
    }

    public Object get(int id)
    {
        return menuDB.get(id);
    }

    public ArrayList getAll()
    {
        return menuDB.getAll();
    }

    public boolean save(Object o)
    {
        return menuDB.save(o);
    }
}