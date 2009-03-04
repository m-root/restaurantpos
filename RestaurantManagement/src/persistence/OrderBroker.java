package persistence;


import java.util.ArrayList;


public class OrderBroker implements Broker
{
    private static OrderBroker ob;
	OrderDB orderDB = new OrderDB();

	private OrderBroker()
	{
	}

	public static OrderBroker getBroker()
	{
		if(ob == null)
		{
			ob = new OrderBroker();
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