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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","root","shadow");
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
     * This method take in a Employee object and writes the data to the database
     * @param Requires a Employee Object
     * @return Returns true if it the object is save and false if it is not saved
     */
    public boolean save(Object o){
        try {
            //(int id, char status, int seats, int xloc, int yloc)
            Employee employee = (Employee) o;
            CallableStatement stat = con.prepareCall("call spAddEmployee(?,?,?,?,?,?,?,?);");
            stmt = con.createStatement();
            String query = "SELECT count(*) FROM employee WHERE " + employee.getNumber() + " = employeeId;";
            results = stmt.executeQuery(query);
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
                query = "UPDATE employee SET  = role = '" + employee.getRole() +
                                                "', fname = '" + employee.getFName() +
                                                "', lname = '" + employee.getLName() +
                                                "', phone = '" + employee.getPhone() +
                                                "', sin = '" + employee.getSin() +
                                                "', address = '" + employee.getAddress() +
                                                "', wage = '" + employee.getWage() +
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
     * This method takes in an arraylist of employees to be saved and adds them
     * to the employee table in the database. Returns
     * @param ar This is an array list full of employees to be added
     * @return Returns true if the objects are added and false if any object is not added
     */
    public boolean saveAll(ArrayList ar){
        for(int i = 0; i < ar.size(); i++){
            Employee employee = (Employee) ar.get(i);
            try {
                
                CallableStatement stat = con.prepareCall("call spAddEmployee(?,?,?,?,?,?,?,?);");
                stmt = con.createStatement();
                String query = "SELECT count(*) FROM employee WHERE " + employee.getNumber() + " = employeeId;";
                results = stmt.executeQuery(query);
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

                }
                else {
                    query = "UPDATE employee SET  = role = '" + employee.getRole() +
                                                    "', fname = '" + employee.getFName() +
                                                    "', lname = '" + employee.getLName() +
                                                    "', phone = '" + employee.getPhone() +
                                                    "', sin = '" + employee.getSin() +
                                                    "', address = '" + employee.getAddress() +
                                                    "', wage = '" + employee.getWage() +
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
     * @return Returns a Employee Object
     */
    public Employee get(int number){
        try {
            Employee employee = new Employee();
            stmt = con.createStatement();
            String query = "SELECT * FROM employee WHERE '" + number + "' = employeeId;";
            results = stmt.executeQuery(query);

            while(results.next()){
                employee = new Employee(results.getInt(1), results.getString(2).charAt(0),results.getString(3), results.getString(4),
                                    results.getString(5), results.getString(6), results.getString(7), results.getDouble(8));
            }

            return employee;
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList getAll(){
        try {
            Employee employee = new Employee();
            ArrayList<Employee> ar = new ArrayList<Employee>();
            stmt = con.createStatement();
            String query = "SELECT * FROM employee;";
            results = stmt.executeQuery(query);

            while(results.next()){
                employee = new Employee(results.getInt(1), results.getString(2).charAt(0),results.getString(3), results.getString(4),
                                    results.getString(5), results.getString(6), results.getString(7), results.getDouble(8));
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
     * @return Returns true if it is removed or false if it is not removed
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


}
