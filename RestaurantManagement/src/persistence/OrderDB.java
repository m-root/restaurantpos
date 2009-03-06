/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class OrderDB {

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
     * This is the constructor for the order broker
     */
    public OrderDB(){
        setConnection();
    }

    /**
     * This method takes in a Order object and writes the data to the database
     * @param Requires a Order Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Order order = (Order) o;

            CallableStatement stat = con.prepareCall("call spAddOrder(?,?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM resorder WHERE " + order.getId() + " = orderId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, order.getId());
                stat.setString(2, "" + order.getPaymentMethod());
                stat.setBoolean(3, order.isPaid());
                stat.setDouble(4, order.getPaymentAmount());
                stat.setInt(5, order.getTable().getId());
                stat.setInt(6, order.getSeat());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE resorder SET orderID = '" + order.getId() +
                                                "', paymentMethod = '" + order.getPaymentMethod() +
                                                "', paid = '" + order.isPaid() +
                                                "', paymentAmount = '" + order.getPaymentAmount() +
                                                "', tableId = '" + order.getTable().getId() +
                                                "', seat = '" + order.getSeat() +
                        " where orderId ='" + order.getId() + "';";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Order objects and writes the data to the database
     * @param Requires an arraylist of Order Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM resorder;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Order order = (Order) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM resorder WHERE " + order.getId() + " = orderId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddOrder(?,?,?,?,?);");
                stat.setInt(1, order.getId());
                stat.setInt(2, order.getSeat());
                stat.setString(3, "" + order.getPaymentMethod());
                stat.setBoolean(4, order.isPaid());
                stat.setDouble(5, order.getPaymentAmount());
                stat.execute();
                TableBroker tb = TableBroker.getBroker();
                tb.save(order.getTable());
                if(order.getItems().isEmpty())
                {
                    return true;
                }
                else
                {
                     ItemBroker ib = ItemBroker.getBroker();
                      for(i=0; i < order.getItems().size(); i++)
                      {
                        ib.save(order.getItems().get(i));
                      }
                     return true;
                }

            }
            else {
                query = "UPDATE resorder SET orderID = '" + order.getId() +
                                                "', seat = '" + order.getSeat() +
                                                "', paymentMethod = '" + order.getPaymentMethod() +
                                                "', paymentAmount = '" + order.getPaymentAmount() +
                                                "', isPaid = '" + order.isPaid() +
                        " where orderId ='" + order.getId() + "';";
                stmt.executeQuery(query);
                TableBroker tb = TableBroker.getBroker();
                tb.save(order.getTable());
                if(order.getItems().isEmpty())
                {
                    return true;
                }
                else
                {
                     OrderItemBroker ib = OrderItemBroker.getBroker();
                      for(i=0; i < order.getItems().size(); i++)
                      {
                        ib.save(order.getItems().get(i));
                      }
                     return true;
                }


            }

            } catch (SQLException ex) {
                Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Order ID number and returns the order from the database
     * @param Requires a OrderID number (int)
     * @return returns a Order Object
     */
    public Order get(int number){
        try {
            Order order = new Order();


            stmt = con.createStatement();
            String query = "SELECT * FROM resorder WHERE '" + number + "' = orderId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                order = new Order(results.getInt("orderID"), null, results.getInt("seat"), results.getString("paymentMethod").charAt(0),
                                    results.getBoolean("paid"),results.getDouble("paymentAmount"), null);
                TableBroker tb = TableBroker.getBroker();
                OrderItemBroker ib = OrderItemBroker.getBroker();
                order.setTable((Table)tb.get(results.getInt("tableId")));
                query = "SELECT * FROM OrderItem WHERE '" + results.getInt("OrderId") + "' = OrderId;";
                ArrayList<Item> ar = new ArrayList<Item>();
                while(results.next())
                {
                    Item item = (Item) ib.get(results.getInt("OrderId"));
                    ar.add(item);
                }
                if(ar.size() != 0)
                {
                    order.setItems(ar);
                }
            }

            return order;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all orders in the database
     * @return Returns an arraylist full of all orders in the database
     */
    public ArrayList getAll(){
        try {
            Order order = new Order();
            ArrayList<Order> ar = new ArrayList<Order>();
            stmt = con.createStatement();
            String query = "SELECT * FROM resorder;";
            results = stmt.executeQuery(query);

            while(results.next()){
                order = new Order(results.getInt("orderID"), null, results.getInt("seat"), results.getString("paymentMethod").charAt(0),
                                    results.getBoolean("paid"),results.getDouble("paymentAmount"), null);
                TableBroker tb = TableBroker.getBroker();
                OrderItemBroker ib = OrderItemBroker.getBroker();
                order.setTable((Table)tb.get(results.getInt("tableId")));
                query = "SELECT * FROM OrderItem WHERE '" + results.getInt("OrderId") + "' = OrderId;";
                ArrayList<Item> ar2 = new ArrayList<Item>();
                while(results.next())
                {
                    Item item = (Item) ib.get(results.getInt("OrderId"));
                    ar2.add(item);
                }
                if(ar.size() != 0)
                {
                    order.setItems(ar2);
                }
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Order ID number and deletes that order from the database
     * @param Requires a Order ID number (int)
     * @return Returns true if the order is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteOrder(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(OrderDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}

