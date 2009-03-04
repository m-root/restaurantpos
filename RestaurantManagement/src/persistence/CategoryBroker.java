package persistence;

import java.util.ArrayList;
import DB.CategoryDB;

public class CategoryBroker implements Broker
{
    private static CategoryBroker cb;
	CategoryDB categoryDB = new CategoryDB();

	private CategoryBroker()
	{
	}

	public static CategoryBroker getBroker()
	{
		if(cb == null)
		{
			cb = new CategoryBroker();
		}
		return cb;
	}

    public boolean saveAll(ArrayList a)
    {
        return categoryDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return categoryDB.remove(id);
    }

    public Object get(int id)
    {
        return categoryDB.get(id);
    }

    public ArrayList getAll()
    {
        return categoryDB.getAll();
    }

    public boolean save(Object o)
    {
        return categoryDB.save(o);
    }
}