package brokers;

import java.util.ArrayList;
import DB.*;

public class ShiftBroker implements Broker
{
    private static ShiftBroker sb;
	ShiftDB shiftDB = new ShiftDB();

	private ShiftBroker()
	{
	}

	public static ShiftBroker getBroker()
	{
		if(sb == null)
		{
			sb = new ShiftBroker();
		}
		return sb;
	}

    public boolean saveAll(ArrayList a)
    {
        return shiftDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return shiftDB.remove(id);
    }

    public Object get(int id)
    {
        return shiftDB.get(id);
    }

    public ArrayList getAll()
    {
        return shiftDB.getAll();
    }

    public boolean save(Object o)
    {
        return shiftDB.save(o);
    }
}