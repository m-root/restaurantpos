

package persistence;


import businessobjects.Table;
import java.sql.*;
import businessobjects.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 465824
 */
public class TableDB {

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
     * This is the constructor for the table broker
     */
    public TableDB(){
        setConnection();
    }

    /**
     * This method takes in a Table object and writes the data to the database
     * @param Requires a Table Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Table table = (Table) o;
            //(int id, char status, int seats, int xloc, int yloc)
            CallableStatement stat = con.prepareCall("call spAddTable(?,?,?,?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM resTable WHERE " + table.getId() + " = tableId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, table.getId());
                stat.setString(2, "" + table.getStatus());
                stat.setInt(3, table.getXLoc());
                stat.setInt(4, table.getYLoc());
                stat.setInt(5, table.getFloor());
                stat.setInt(6, table.getSeats());
                stat.setString(7, table.getType()+"");
                if(table.getServer() != null)
                {
                    stat.setInt(8, 0);
                }
                else
                {
                    stat.setInt(8, table.getServer().getNumber());
                }
                stat.execute();
                return true;
            }
            else {
                 query = "UPDATE resTable SET status = '" + table.getStatus() +
                                                "', xloc = '" + table.getXLoc() +
                                                "', yloc = '" + table.getYLoc() +
                                                "', seats = '" + table.getSeats() +
                                                "', typechar = '" + table.getType() +
                                                "', floor = '" + table.getFloor() +
                        "' where tableId =" + table.getId() + ";";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Table objects and writes the data to the database
     * @param Requires an arraylist of Table Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE FROM resTable WHERE floor="+((Table)ar.get(0)).getFloor()+";");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Table table = (Table) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM resTable WHERE " + table.getId() + " = tableId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddTable(?,?,?,?,?,?,?,?);");
                stat.setInt(1, table.getId());
                stat.setString(2, "" + table.getStatus());
                stat.setInt(3, table.getXLoc());
                stat.setInt(4, table.getYLoc());
                stat.setInt(5, table.getFloor());
                stat.setInt(6, table.getSeats());
                stat.setString(7, table.getType()+"");
                if(table.getServer() != null)
                {
                    stat.setInt(8, 0);
                }
                else
                {
                    stat.setInt(8, table.getServer().getNumber());
                }
                stat.execute();

            }
            else {
                query = "UPDATE resTable SET status = '" + table.getStatus() +
                                                "', xloc = '" + table.getXLoc() +
                                                "', yloc = '" + table.getYLoc() +
                                                "', seats = '" + table.getSeats() +
                                                "', typechar = '" + table.getType() +
                                                "', floor = '" + table.getFloor() +
                        "' where tableId =" + table.getId() + ";";
                stmt.execute(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Table ID number and returns the table from the database
     * @param Requires a TableID number (int)
     * @return returns a Table Object
     */
    public Table get(int number){
        try {
            Table table = new Table();


            stmt = con.createStatement();
            String query = "SELECT * FROM resTable WHERE '" + number + "' = tableId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                table = new Table(results.getInt(1), results.getString(2).charAt(0),results.getInt(6), results.getInt(4),
                                    results.getInt(5), results.getString("type").charAt(0), null, results.getInt("floor"));

                    String query2 = "SELECT * FROM Employee WHERE '" + results.getInt("employeeId") + "';";
                    Employee employee = new Employee(results.getInt("employeeID"), results.getString("role").charAt(0),results.getString("fname"), results.getString("lname"),
                                    results.getString("phone"), results.getString("sin"), results.getString("address"), results.getDouble("wage"));
                    table.setServer(employee);

            }

            return table;
        } catch (SQLException ex) {
            Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all tables in the database
     * @return Returns an arraylist full of all tables in the database
     */
    public ArrayList getAll(){
        try {
            Table table = new Table();
            ArrayList<Table> ar = new ArrayList<Table>();
            stmt = con.createStatement();
            String query = "SELECT * FROM resTable;";
            results = stmt.executeQuery(query);

            while(results.next()){
                table = new Table(results.getInt(1), results.getString(2).charAt(0),results.getInt("seats"), results.getInt(4),
                                    results.getInt(5), results.getString("typechar").charAt(0), null, results.getInt("floor"));
                if(results.getInt("employeeId") != 0)
                {
                    EmployeeBroker eb = EmployeeBroker.getBroker();
                    table.setServer((Employee) eb.get(results.getInt("employeeId")));
                }
                ar.add(table);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Table ID number and deletes that table from the database
     * @param Requires a Table ID number (int)
     * @return Returns true if the table is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteTable(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TableDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }


}

