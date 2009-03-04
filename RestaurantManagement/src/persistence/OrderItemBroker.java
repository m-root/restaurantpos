package persistence;

import java.util.ArrayList;


public class OrderItemBroker implements Broker
{
    private static OrderItemBroker oib;
	OrderItemDB orderItemDB = new OrderItemDB();

	private OrderItemBroker()
	{
	}

	public static OrderItemBroker getBroker()
	{
		if(oib == null)
		{
			oib = new OrderItemBroker();
		}
		return oib;
	}

    public boolean saveAll(ArrayList a)
    {
        return orderItemDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return orderItemDB.remove(id);
    }

    public Object get(int id)
    {
        return orderItemDB.get(id);
    }

    public ArrayList getAll()
    {
        return orderItemDB.getAll();
    }

    public boolean save(Object o)
    {
        return orderItemDB.save(o);
    }
}