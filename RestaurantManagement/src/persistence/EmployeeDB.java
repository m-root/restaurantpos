

package persistence;


import businessobjects.Employee;
import java.sql.*;
import businessobjects.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 465824
 */
public class EmployeeDB {

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
     * This is the constructor for the employee broker
     */
    public EmployeeDB(){
        setConnection();
    }

    /**
     * This method takes in a Employee object and writes the data to the database
     * @param Requires a Employee Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Employee employee = (Employee) o;
            
            CallableStatement stat = con.prepareCall("call spAddEmployee(?,?,?,?,?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM Employee WHERE " + employee.getNumber() + " = employeeId;";
            results = stmt.executeQuery(query);
            System.out.println(results);
            if (results.getInt(1) == 0) {
                stat.setInt(1, employee.getNumber());
                stat.setString(2, "" + employee.getRole());
                stat.setString(3, employee.getFName());
                stat.setString(4, employee.getLName());
                stat.setString(5, employee.getPhone());
                stat.setString(6, employee.getSin());
                stat.setString(7, employee.getAddress());
                stat.setDouble(8, employee.getWage());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE Employee SET employeeID = '" + employee.getNumber() +
                                                "', role = '" + employee.getRole() +
                                                "', fname = '" + employee.getFName() +
                                                "', lname = '" + employee.getLName() +
                                                "', phone = '" + employee.getPhone() +
                                                "', sin = '" + employee.getSin() +
                                                "', address = '" + employee.getAddress() +
                        "' where employeeId =" + employee.getNumber() + ";";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Employee objects and writes the data to the database
     * @param Requires an arraylist of Employee Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM Employee;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Employee employee = (Employee) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM Employee WHERE " + employee.getNumber() + " = employeeId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddEmployee(?,?,?,?,?,?,?,?);");
                stat.setInt(1, employee.getNumber());
                stat.setString(2, "" + employee.getRole());
                stat.setString(3, employee.getFName());
                stat.setString(4, employee.getLName());
                stat.setString(5, employee.getPhone());
                stat.setString(6, employee.getSin());
                stat.setString(7, employee.getAddress());
                stat.setDouble(8, employee.getWage());
                stat.execute();

            }
            else {
                query = "UPDATE Employee SET employeeID = '" + employee.getNumber() +
                                                "', role = '" + employee.getRole() +
                                                "', fname = '" + employee.getFName() +
                                                "', lname = '" + employee.getLName() +
                                                "', phone = '" + employee.getPhone() +
                                                "', sin = '" + employee.getSin() +
                                                "', address = '" + employee.getAddress() +
                        "' where employeeId =" + employee.getNumber() + ";";
                stmt.executeQuery(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Employee ID number and returns the employee from the database
     * @param Requires a EmployeeID number (int)
     * @return returns a Employee Object
     */
    public Employee get(int number){
        try {
            Employee employee = null;


            stmt = con.createStatement();
            String query = "SELECT * FROM Employee WHERE '" + number + "' = employeeId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                employee = new Employee(results.getInt("employeeID"), results.getString("role").charAt(0),results.getString("fname"), results.getString("lname"),
                                    results.getString("phone"), results.getString("sin"), results.getString("address"), results.getDouble("wage"));
            }

            return employee;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all employees in the database
     * @return Returns an arraylist full of all employees in the database
     */
    public ArrayList getAll(){
        try {
            Employee employee = null;
            ArrayList<Employee> ar = new ArrayList<Employee>();
            stmt = con.createStatement();
            String query = "SELECT * FROM Employee;";
            results = stmt.executeQuery(query);

            while(results.next()){
                employee = new Employee(results.getInt("employeeID"), results.getString("role").charAt(0),results.getString("fname"), results.getString("lname"),
                                    results.getString("phone"), results.getString("sin"), results.getString("address"), results.getDouble("wage"));
                ar.add(employee);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Employee ID number and deletes that employee from the database
     * @param Requires a Employee ID number (int)
     * @return Returns true if the employee is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteEmployee(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public boolean clockOut(int number){
        try {
            CallableStatement stat = con.prepareCall("call spClockOut(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean clockIn(int number){
        try {
            CallableStatement stat = con.prepareCall("call spClockIn(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    


}

