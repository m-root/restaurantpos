package brokers;

import java.util.ArrayList;
import DB.*;

public class TimeStampBroker implements Broker
{
    private static TimeStampBroker tsb;
	TimeStampDB timeStampDB = new TimeStampDB();

	private TimeStampBroker()
	{
	}

	public static TimeStampBroker getBroker()
	{
		if(tsb == null)
		{
			tsb = new TimeStampBroker();
		}
		return tsb;
	}

    public boolean saveAll(ArrayList a)
    {
        return timeStampDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return timeStampDB.remove(id);
    }

    public Object get(int id)
    {
        return timeStampDB.get(id);
    }

    public ArrayList getAll()
    {
        return timeStampDB.getAll();
    }

    public boolean save(Object o)
    {
        return timeStampDB.save(o);
    }
}