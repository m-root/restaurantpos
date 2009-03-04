package brokers;

import java.util.ArrayList;
import DB.*;

public class OrderDB implements Broker
{
    private static OrderDB ob;
	OrderDB orderDB = new OrderDB();

	private OrderDB()
	{
	}

	public static OrderDB getBroker()
	{
		if(ob == null)
		{
			ob = new OrderDB();
		}
		return ob;
	}

    public boolean saveAll(ArrayList a)
    {
        return orderDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return orderDB.remove(id);
    }

    public Object get(int id)
    {
        return orderDB.get(id);
    }

    public ArrayList getAll()
    {
        return orderDB.getAll();
    }

    public boolean save(Object o)
    {
        return orderDB.save(o);
    }
}