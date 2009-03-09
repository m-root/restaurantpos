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
import other.*;
/**
 *
 * @author 465824
 */
public class ShiftDB {

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
     * This is the constructor for the shift broker
     */
    public ShiftDB(){
        setConnection();
    }

    /**
     * This method takes in a Shift object and writes the data to the database
     * @param Requires a Shift Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            Shift shift = (Shift) o;
            CalDateConv cdconv = new CalDateConv();
            CallableStatement stat = con.prepareCall("call spAddShift(?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM Shift WHERE " + shift.getId() + " = shiftId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, shift.getId());
                stat.setDate(2,(Date) cdconv.calToDate(shift.getIn()));
                stat.setDate(3,(Date) cdconv.calToDate(shift.getOut()));
                stat.setInt(4, shift.getEmployee().getNumber());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE Shift SET shiftID = '" + shift.getId() +
                                                "', inTime = '" + cdconv.calToDate(shift.getIn()) +
                                                "', outTime = '" + cdconv.calToDate(shift.getIn()) +
                                                "', FK_employeeId = '" + shift.getEmployee().getNumber() +
                        "' where shiftId =" + shift.getId() + ";";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of Shift objects and writes the data to the database
     * @param Requires an arraylist of Shift Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM Shift;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            Shift shift = (Shift) ar.get(i);
            CalDateConv cdconv = new CalDateConv();
            

            
            String query = "SELECT count(*) FROM Shift WHERE " + shift.getId() + " = shiftId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddShift(?,?,?,?);");
                stat.setInt(1, shift.getId());
                stat.setDate(2,(Date) cdconv.calToDate(shift.getIn()));
                stat.setDate(3,(Date) cdconv.calToDate(shift.getOut()));
                stat.setInt(4, shift.getEmployee().getNumber());
                stat.execute();

            }
            else {
                 query = "UPDATE Shift SET shiftID = '" + shift.getId() +
                                                "', inTime = '" + cdconv.calToDate(shift.getIn()) +
                                                "', outTime = '" + cdconv.calToDate(shift.getOut()) +
                                                "', FK_employeeId = '" + shift.getEmployee().getNumber() +
                        "' where shiftId =" + shift.getId() + ";";
                stmt.executeQuery(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a Shift ID number and returns the shift from the database
     * @param Requires a ShiftID number (int)
     * @return returns a Shift Object
     */
    public Shift get(int number){
        try {
            Shift shift = new Shift();
            CalDateConv cdconv = new CalDateConv();

            stmt = con.createStatement();
            String query = "SELECT * FROM Shift WHERE '" + number + "' = shiftId;";
            results = stmt.executeQuery(query);
            while(results.next()){
                shift = new Shift(results.getInt("shiftID"), cdconv.dateToCal(results.getDate("inTime")), cdconv.dateToCal(results.getDate("outTime")), null);
                if(results.getInt("FK_employeeId") != 0)
                {
                    EmployeeBroker eb = EmployeeBroker.getBroker();
                    shift.setEmployee((Employee) eb.get(results.getInt("FK_employeeId")));
                }
            }

            return shift;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all shifts in the database
     * @return Returns an arraylist full of all shifts in the database
     */
    public ArrayList getAll(){
        try {
            Shift shift = new Shift();
            CalDateConv cdconv = new CalDateConv();
            ArrayList<Shift> ar = new ArrayList<Shift>();
            stmt = con.createStatement();
            String query = "SELECT * FROM Shift;";
            results = stmt.executeQuery(query);

            while(results.next()){
                shift = new Shift(results.getInt("shiftID"), cdconv.dateToCal(results.getDate("inTime")), cdconv.dateToCal(results.getDate("outTime")), null);
                if(results.getInt("FK_employeeId") != 0)
                {
                    EmployeeBroker eb = EmployeeBroker.getBroker();
                    shift.setEmployee((Employee) eb.get(results.getInt("FK_employeeId")));
                }
                ar.add(shift);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a Shift ID number and deletes that shift from the database
     * @param Requires a Shift ID number (int)
     * @return Returns true if the shift is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteShift(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}