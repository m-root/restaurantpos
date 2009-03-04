package persistence;

import java.util.ArrayList;

public class EmployeeBroker implements Broker
{
    private static EmployeeBroker eb;
	EmployeeDB employeeDB = new EmployeeDB();

	private EmployeeBroker()
	{
	}

	public static EmployeeBroker getBroker()
	{
		if(eb == null)
		{
			eb = new EmployeeBroker();
		}
		return eb;
	}

    public boolean saveAll(ArrayList a)
    {
        return employeeDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return employeeDB.remove(id);
    }

    public Object get(int id)
    {
        return employeeDB.get(id);
    }
    
    public ArrayList getAll()
    {
        return employeeDB.getAll();
    }

    public boolean save(Object o)
    {
        return employeeDB.save(o);
    }
}