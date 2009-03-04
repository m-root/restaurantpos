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
public class OrderItemDB {

    private Connection con;
    public Statement	stmt;
	public ResultSet	results;
    public ResultSet    results2;

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
     * This is the constructor for the orderItem broker
     */
    public OrderItemDB(){
        setConnection();
    }

    /**
     * This method takes in a OrderItem object and writes the data to the database
     * @param Requires a OrderItem Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            OrderItem orderItem = (OrderItem) o;

            CallableStatement stat = con.prepareCall("call spAddOrderItem(?,?,?,?,?);");
             stmt = con.createStatement();
            
            
                stat.setInt(1, orderItem.getOrderItemId());
                stat.setInt(2, orderItem.getItem().getId());
                stat.setDouble(3, orderItem.getItem().getPrice());
                stat.setInt(4, orderItem.getSeat());
                stat.setInt(5, orderItem.getOrderId());
                stat.execute();
               if(orderItem.getItemAddon().size() != 0)
               {
                   for(int i=0;i < orderItem.getItemAddon().size();i++)
                    {
                        CallableStatement stat2 = con.prepareCall("call spAddItemMod(?,?);");
                        stat2.setInt(1, orderItem.getItemAddon().get(i).getId());
                        stat2.setInt(2, orderItem.getOrderItemId());
                        stat2.execute();
                    }

                }
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of OrderItem objects and writes the data to the database
     * @param Requires an arraylist of OrderItem Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM OrderItem;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            OrderItem orderItem = (OrderItem) ar.get(i);
            
                CallableStatement stat = con.prepareCall("call spAddOrderItem(?,?,?,?,?);");
             stmt = con.createStatement();


                stat.setInt(1, orderItem.getOrderItemId());
                stat.setInt(2, orderItem.getItem().getId());
                stat.setDouble(3, orderItem.getItem().getPrice());
                stat.setInt(4, orderItem.getSeat());
                stat.setInt(5, orderItem.getOrderId());
                stat.execute();
               if(orderItem.getItemAddon().size() != 0)
               {
                   for(i=0;i < orderItem.getItemAddon().size();i++)
                    {
                        CallableStatement stat2 = con.prepareCall("call spAddItemMod(?,?);");
                        stat2.setInt(1, orderItem.getItemAddon().get(i).getId());
                        stat2.setInt(2, orderItem.getOrderItemId());
                        stat2.execute();
                    }

                }
                return true;
            
            

            } catch (SQLException ex) {
                Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a OrderItem ID number and returns the orderItem from the database
     * @param Requires a OrderItemID number (int)
     * @return returns a OrderItem Object
     */
    public OrderItem get(int number){
        try {
            OrderItem orderItem = new OrderItem();


            stmt = con.createStatement();
            String query = "SELECT * FROM OrderItem WHERE '" + number + "' = orderItemId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                orderItem = new OrderItem(results.getInt("orderItemID"), null, results.getDouble("price"), results.getInt("seat"),
                                            null, results.getInt("orderId"));
                ItemBroker ib = ItemBroker.getBroker();
                Item item = (Item) ib.get(results.getInt("itemId"));
                orderItem.setItem(item);
                query = "SELECT count(*) FROM ItemMod WHERE " + results.getInt("orderItemID") + " = timeStampId;";
                results2 = stmt.executeQuery(query);
                int count = results2.getInt(1);
                if(count != 0)
                {
                    ArrayList<ItemAddon> al = new ArrayList<ItemAddon>();
                    query = "SELECT * FROM ItemMod WHERE '" + results.getInt("orderItemID") + "' = orderItemId;";
                    results2 = stmt.executeQuery(query);
                    while(results2.next())
                    {
                        ItemAddonBroker iab = ItemAddonBroker.getBroker();
                        ItemAddon ia = (ItemAddon) iab.get(results2.getInt("ItemAddonID"));
                        al.add(ia);
                    }
                    orderItem.setItemAddon(al);
                }


            }

            return orderItem;
        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all orderItems in the database
     * @return Returns an arraylist full of all orderItems in the database
     */
    public ArrayList getAll(){
        try {
            OrderItem orderItem = new OrderItem();
            ArrayList<OrderItem> ar = new ArrayList<OrderItem>();
            stmt = con.createStatement();
            String query = "SELECT * FROM OrderItem;";
            results = stmt.executeQuery(query);

            while(results.next()){
                orderItem = new OrderItem(results.getInt("orderItemID"), null, results.getDouble("price"), results.getInt("seat"),
                                            null, results.getInt("orderId"));
                ItemBroker ib = ItemBroker.getBroker();
                Item item = (Item) ib.get(results.getInt("itemId"));
                orderItem.setItem(item);
                query = "SELECT count(*) FROM ItemMod WHERE " + results.getInt("orderItemID") + " = timeStampId;";
                results2 = stmt.executeQuery(query);
                int count = results2.getInt(1);
                if(count != 0)
                {
                    ArrayList<ItemAddon> al = new ArrayList<ItemAddon>();
                    query = "SELECT * FROM ItemMod WHERE '" + results.getInt("orderItemID") + "' = orderItemId;";
                    results2 = stmt.executeQuery(query);
                    while(results2.next())
                    {
                        ItemAddonBroker iab = ItemAddonBroker.getBroker();
                        ItemAddon ia = (ItemAddon) iab.get(results2.getInt("ItemAddonID"));
                        al.add(ia);
                    }
                    orderItem.setItemAddon(al);
                }
                ar.add(orderItem);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a OrderItem ID number and deletes that orderItem from the database
     * @param Requires a OrderItem ID number (int)
     * @return Returns true if the orderItem is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteOrderItem(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderItemDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}
