package persistence;



import java.util.ArrayList;

public class TableBroker implements Broker
{
    private static TableBroker tb;
	TableDB tableDB = new TableDB();

	private TableBroker()
	{
	}

	public static TableBroker getBroker()
	{
		if(tb == null)
		{
			tb = new TableBroker();
		}
		return tb;
	}

    public boolean saveAll(ArrayList a)
    {
        return tableDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return tableDB.remove(id);
    }

    public Object get(int id)
    {
        return tableDB.get(id);
    }

    public ArrayList getAll()
    {
        return tableDB.getAll();
    }

    public boolean save(Object o)
    {
        return tableDB.save(o);
    }
}