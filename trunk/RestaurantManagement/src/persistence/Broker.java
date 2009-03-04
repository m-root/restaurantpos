package persistence;

import java.util.ArrayList;

/**
 *
 * @author 457022
 */

public interface Broker 
{
    public boolean save(Object o);

    public boolean saveAll(ArrayList a);
    
    public boolean remove(int id);
    
    public Object get(int id);     
    
    public ArrayList getAll();
 }
