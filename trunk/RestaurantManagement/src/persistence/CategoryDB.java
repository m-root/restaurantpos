

package persistence;


import businessobjects.Category;
import java.sql.*;
import businessobjects.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 465824
 */
public class CategoryDB {

    private Connection con;
    public Statement	stmt;
	public ResultSet	results;

    /**
     * This method sets the connection to the database
     */
    public void setConnection(){
     try {
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","password");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * This is the constructor for the category broker
     */
    public CategoryDB(){
        setConnection();
    }

    /**
     * This method takes in a Category object and writes the data to the database
     * @param Requires a Category Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Category category = (Category) o;

            CallableStatement stat = con.prepareCall("call spAddCategory(?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM Category WHERE " + category.getId() + " = categoryId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, category.getId());
                stat.setString(2, "" + category.getName());
                stat.setInt(3, category.getParent().getId());
                stat.execute();
                if(category.getSubs().isEmpty())
                {
                    return true;
                }
                else
                {
                    ItemBroker ib = ItemBroker.getBroker();
                    CategoryBroker cb = CategoryBroker.getBroker();
                    for(int i=0; i < category.getSubs().size(); i++)
                    {
                        Categorizable item = category.getSubs().get(i);
                        if(item.getParent() != null)
                        {
                            cb.save(item);
                        }
                        else
                        {
                            ib.save(item);
                        }
                        
                    }
                }
                return true;
            }
            else {
                query = "UPDATE Category SET categoryID = '" + category.getId() +
                                                "', name = '" + category.getName() +
                                                "', parent = '" + category.getParent().getId() +
                        "' where categoryId =" + category.getId() + ";";
                stmt.executeQuery(query);
                if(category.getSubs().isEmpty())
                {
                    return true;
                }
                else
                {
                    ItemBroker ib = ItemBroker.getBroker();
                    CategoryBroker cb = CategoryBroker.getBroker();
                    for(int i=0; i < category.getSubs().size(); i++)
                    {
                        Categorizable item = category.getSubs().get(i);
                        if(item.getParent() != null)
                        {
                            cb.save(item);
                        }
                        else
                        {
                            ib.save(item);
                        }

                    }
                }
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Category objects and writes the data to the database
     * @param Requires an arraylist of Category Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM Category;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Category category = (Category) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM Category WHERE " + category.getId() + " = categoryId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddCategory(?,?,?);");
                stat.setInt(1, category.getId());
                stat.setString(2, "" + category.getName());
                stat.setInt(3, category.getParent().getId());
                stat.execute();
                if(category.getSubs().isEmpty())
                {
                    return true;
                }
                else
                {
                    ItemBroker ib = ItemBroker.getBroker();
                    CategoryBroker cb = CategoryBroker.getBroker();
                    for(i=0; i < category.getSubs().size(); i++)
                    {
                        Categorizable item = category.getSubs().get(i);
                        if(item.getParent() != null)
                        {
                            cb.save(item);
                        }
                        else
                        {
                            ib.save(item);
                        }

                    }
                }

            }
            else {
                query = "UPDATE Category SET categoryID = '" + category.getId() +
                                                "', name = '" + category.getName() +
                                                "', parent = '" + category.getParent().getId() +
                        "' where categoryId =" + category.getId() + ";";
                stmt.executeQuery(query);
                if(category.getSubs().isEmpty())
                {
                    return true;
                }
                else
                {
                    ItemBroker ib = ItemBroker.getBroker();
                    CategoryBroker cb = CategoryBroker.getBroker();
                    for(i=0; i < category.getSubs().size(); i++)
                    {
                        Categorizable item = category.getSubs().get(i);
                        if(item.getParent() != null)
                        {
                            cb.save(item);
                        }
                        else
                        {
                            ib.save(item);
                        }

                    }
                }

            }

            } catch (SQLException ex) {
                Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Category ID number and returns the category from the database
     * @param Requires a CategoryID number (int)
     * @return returns a Category Object
     */
    public Category get(int number){
        try {
            Category category = new Category();


            stmt = con.createStatement();
            String query = "SELECT * FROM Category WHERE '" + number + "' = categoryId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                category = new Category(results.getInt("categoryID"), results.getString("name"),null,null);
                if(results.getInt("parent") != 0)
                {
                    category.setParent(get(results.getInt("parent")));
                }
                query = "SELECT * FROM category WHERE '" + results.getInt("categoryId") + "' = parent;";
                ArrayList<Categorizable> ar = new ArrayList<Categorizable>();
                CategoryBroker cb = CategoryBroker.getBroker();
                while(results.next())
                {
                    Categorizable item = (Categorizable) cb.get(results.getInt("categoryId"));
                    ar.add(item);
                }
                query = "SELECT * FROM items WHERE '" + results.getInt("categoryId") + "' = categoryId;";
                
                ItemBroker ib = ItemBroker.getBroker();
                while(results.next())
                {
                    Categorizable item = (Categorizable) ib.get(results.getInt("itemId"));
                    ar.add(item);
                }
                if(ar.size() != 0)
                {
                    category.setSubs(ar);
                }
            }

            return category;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all categorys in the database
     * @return Returns an arraylist full of all categorys in the database
     */
    public ArrayList getAll(){
        try {
            Category category = new Category();
            ArrayList<Category> ar = new ArrayList<Category>();
            stmt = con.createStatement();
            String query = "SELECT * FROM Category;";
            results = stmt.executeQuery(query);

            while(results.next()){
                category = new Category(results.getInt("categoryID"), results.getString("name"),null,null);
                if(results.getInt("parent") != 0)
                {
                    category.setParent(get(results.getInt("parent")));
                }
                query = "SELECT * FROM category WHERE '" + results.getInt("categoryId") + "' = parent;";
                ArrayList<Categorizable> ar2 = new ArrayList<Categorizable>();
                CategoryBroker cb = CategoryBroker.getBroker();
                while(results.next())
                {
                    Categorizable item = (Categorizable) cb.get(results.getInt("categoryId"));
                    ar2.add(item);
                }
                query = "SELECT * FROM items WHERE '" + results.getInt("categoryId") + "' = categoryId;";

                ItemBroker ib = ItemBroker.getBroker();
                while(results.next())
                {
                    Categorizable item = (Categorizable) ib.get(results.getInt("itemId"));
                    ar2.add(item);
                }
                if(ar.size() != 0)
                {
                    category.setSubs(ar2);
                }
                ar.add(category);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Category ID number and deletes that category from the database
     * @param Requires a Category ID number (int)
     * @return Returns true if the category is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteCategory(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}

