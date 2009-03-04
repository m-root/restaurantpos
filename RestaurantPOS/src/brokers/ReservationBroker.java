package brokers;

import java.util.ArrayList;
import DB.*;

public class ReservationBroker implements Broker
{
    private static ReservationBroker rb;
	ReservationDB reservationDB = new ReservationDB();

	private ReservationBroker()
	{
	}

	public static ReservationBroker getBroker()
	{
		if(rb == null)
		{
			rb = new ReservationBroker();
		}
		return rb;
	}

    public boolean saveAll(ArrayList a)
    {
        return reservationDB.saveAll(a);
    }

    public boolean remove(int id)
    {
        return reservationDB.remove(id);
    }

    public Object get(int id)
    {
        return reservationDB.get(id);
    }

    public ArrayList getAll()
    {
        return reservationDB.getAll();
    }

    public boolean save(Object o)
    {
        return reservationDB.save(o);
    }
}