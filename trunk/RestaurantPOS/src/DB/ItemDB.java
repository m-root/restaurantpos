package DB;


import brokers.*;
import java.sql.*;
import businessobjects.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 465824
 */
public class ItemDB {

    private Connection con;
    public Statement	stmt;
	public ResultSet	results;

    /**
     * This method sets the connection to the database
     */
    public void setConnection(){
     try {
			Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * This is the constructor for the item broker
     */
    public ItemDB(){
        setConnection();
    }

    /**
     * This method takes in a Item object and writes the data to the database
     * @param Requires a Item Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Item item = (Item) o;

            CallableStatement stat = con.prepareCall("call spAddItem(?,?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM Item WHERE " + item.getId() + " = itemId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, item.getId());
                stat.setDouble(2, item.getPrice());
                stat.setInt(3, item.getParent().getId());
                stat.setString(4, item.getName());
                stat.setDouble(5, item.getCost());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE Item SET itemID = '" + item.getId() +
                                                "', price = '" + item.getPrice() +
                                                "', category = '" + item.getParent().getId() +
                                                "', name = '" + item.getName() +
                                                "', cost = '" + item.getCost() +
                        " where itemId ='" + item.getId() + "';";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Item objects and writes the data to the database
     * @param Requires an arraylist of Item Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM Item;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Item item = (Item) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM Item WHERE " + item.getId() + " = itemId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddItem(?,?,?,?,?);");
                stat.setInt(1, item.getId());
                stat.setDouble(2, item.getPrice());
                stat.setInt(3, item.getParent().getId());
                stat.setString(4, item.getName());
                stat.setDouble(5, item.getCost());
                stat.execute();

            }
            else {
                query = "UPDATE Item SET itemID = '" + item.getId() +
                                                "', price = '" + item.getPrice() +
                                                "', category = '" + item.getParent().getId() +
                                                "', name = '" + item.getName() +
                                                "', cost = '" + item.getCost() +
                        " where itemId ='" + item.getId() + "';";
                stmt.executeQuery(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Item ID number and returns the item from the database
     * @param Requires a ItemID number (int)
     * @return returns a Item Object
     */
    public Item get(int number){
        try {
            Item item = new Item();


            stmt = con.createStatement();
            String query = "SELECT * FROM Item WHERE '" + number + "' = itemId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                item = new Item(results.getInt("itemID"), results.getDouble("price"),
                                    null, results.getString("name"), results.getDouble("cost"));
                CategoryBroker cb = CategoryBroker.getBroker();
                item.setParent((Category)cb.get(results.getInt("categoryId")));
            }

            return item;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all items in the database
     * @return Returns an arraylist full of all items in the database
     */
    public ArrayList getAll(){
        try {
            Item item = new Item();
            ArrayList<Item> ar = new ArrayList<Item>();
            stmt = con.createStatement();
            String query = "SELECT * FROM Item;";
            results = stmt.executeQuery(query);

            while(results.next()){
                item = new Item(results.getInt("itemID"), results.getDouble("price"),
                                    null, results.getString("name"), results.getDouble("cost"));
                CategoryBroker cb = CategoryBroker.getBroker();
                item.setParent((Category)cb.get(results.getInt("categoryId")));
                ar.add(item);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Item ID number and deletes that item from the database
     * @param Requires a Item ID number (int)
     * @return Returns true if the item is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteItem(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}
