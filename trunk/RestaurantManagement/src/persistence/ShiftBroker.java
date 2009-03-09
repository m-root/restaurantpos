/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

/**
 *
 * @author 465824
 */
import java.util.ArrayList;


public class ShiftBroker implements Broker
{
    private static ShiftBroker tsb;
	ShiftDB shiftDB = new ShiftDB();

	private ShiftBroker()
	{
	}

	public static ShiftBroker getBroker()
	{
		if(tsb == null)
		{
			tsb = new ShiftBroker();
		}
		return tsb;
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