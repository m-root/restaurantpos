

package persistence;



import java.sql.*;
import businessobjects.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 465824
 */
public class ItemAddonDB {

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
     * This is the constructor for the itemAddon broker
     */
    public ItemAddonDB(){
        setConnection();
    }

    /**
     * This method takes in a ItemAddon object and writes the data to the database
     * @param Requires a ItemAddon Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            ItemAddon itemAddon = (ItemAddon) o;

            CallableStatement stat = con.prepareCall("call spAddItemAddon(?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM ItemAddon WHERE " + itemAddon.getId() + " = itemAddonId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, itemAddon.getId());
                stat.setDouble(2, itemAddon.getPrice());
                stat.setString(3, itemAddon.getName());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE ItemAddon SET itemAddonID = '" + itemAddon.getId() +
                                                "', price = '" + itemAddon.getPrice() +
                                                "', name = '" + itemAddon.getName() +
                        "' where itemAddonId =" + itemAddon.getId() + ";";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of ItemAddon objects and writes the data to the database
     * @param Requires an arraylist of ItemAddon Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM ItemAddon;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            ItemAddon itemAddon = (ItemAddon) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM ItemAddon WHERE " + itemAddon.getId() + " = itemAddonId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddItemAddon(?,?,?);");
                stat.setInt(1, itemAddon.getId());
                stat.setDouble(2, itemAddon.getPrice());
                stat.setString(3, itemAddon.getName());
                stat.execute();

            }
            else {
                query = "UPDATE ItemAddon SET itemAddonID = '" + itemAddon.getId() +
                                                "', price = '" + itemAddon.getPrice() +
                                                "', name = '" + itemAddon.getName() +
                        "' where itemAddonId =" + itemAddon.getId() + ";";
                stmt.executeQuery(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a ItemAddon ID number and returns the itemAddon from the database
     * @param Requires a ItemAddonID number (int)
     * @return returns a ItemAddon Object
     */
    public ItemAddon get(int number){
        try {
            ItemAddon itemAddon = new ItemAddon();


            stmt = con.createStatement();
            String query = "SELECT * FROM ItemAddon WHERE '" + number + "' = itemAddonId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                itemAddon = new ItemAddon(results.getInt("itemAddonID"), results.getDouble("price"), results.getString("name"));
            }

            return itemAddon;
        } catch (SQLException ex) {
            Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all itemAddons in the database
     * @return Returns an arraylist full of all itemAddons in the database
     */
    public ArrayList getAll(){
        try {
            ItemAddon itemAddon = new ItemAddon();
            ArrayList<ItemAddon> ar = new ArrayList<ItemAddon>();
            stmt = con.createStatement();
            String query = "SELECT * FROM ItemAddon;";
            results = stmt.executeQuery(query);

            while(results.next()){
                itemAddon = new ItemAddon(results.getInt("itemAddonID"), results.getDouble("price"), results.getString("name"));
                ar.add(itemAddon);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a ItemAddon ID number and deletes that itemAddon from the database
     * @param Requires a ItemAddon ID number (int)
     * @return Returns true if the itemAddon is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteItemAddon(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ItemAddonDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}

