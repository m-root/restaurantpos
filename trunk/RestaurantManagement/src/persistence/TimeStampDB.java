

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
public class TimeStampDB {

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
     * This is the constructor for the timeStamp broker
     */
    public TimeStampDB(){
        setConnection();
    }

    /**
     * This method takes in a TimeStamp object and writes the data to the database
     * @param Requires a TimeStamp Object
     * @return Returns true if the object is saved and false if it is not saved
     */
    public boolean save(Object o){
        try {
            TimeStamp timeStamp = new TimeStamp();
            Employee emp = (Employee)o;

            CallableStatement stat = con.prepareCall("call spAddTimeStamp(?,?,?,?);");
             stmt = con.createStatement();
            String query = "SELECT count(*) FROM TimeStamp WHERE " + timeStamp.getId() + " = timeStampId;";
            results = stmt.executeQuery(query);
            if (results.getInt(1) == 0) {
                stat.setInt(1, timeStamp.getId());
                stat.setString(2, timeStamp.getIn().toString());
                stat.setString(3, timeStamp.getOut().toString());
                stat.setInt(4, emp.getNumber());
                stat.execute();
                return true;
            }
            else {
                query = "UPDATE TimeStamp SET timeStampID = '" + timeStamp.getId() +
                                                "', inTime = '" + timeStamp.getIn().toString() +
                                                "', outTime = '" + timeStamp.getOut().toString() +
                                                "', FK_employeeId = '" + timeStamp.getEmployee().getNumber() +
                        "' where timeStampId =" + timeStamp.getId() + ";";
                stmt.executeQuery(query);
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * This method takes in an arraylist of TimeStamp objects and writes the data to the database
     * @param Requires an arraylist of TimeStamp Objects
     * @return Returns true if the objects are saved and false if they are not saved
     */
    public boolean saveAll(ArrayList ar){
        try {
            if (ar.size()>0)
            {
                stmt = con.createStatement();
                stmt.execute("DELETE * FROM TimeStamp;");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        for(int i = 0; i < ar.size(); i++){
            try {
            TimeStamp timeStamp = (TimeStamp) ar.get(i);
            //(int id, char status, int seats, int xloc, int yloc)

            //stmt = con.createStatement();
            String query = "SELECT count(*) FROM TimeStamp WHERE " + timeStamp.getId() + " = timeStampId;";
            results = stmt.executeQuery(query);

            int count = 0;
            while(results.next())
            {
               count = results.getInt(1);
            }


            if (count == 0) {
                CallableStatement stat = con.prepareCall("call spAddTimeStamp(?,?,?,?);");
                stat.setInt(1, timeStamp.getId());
                stat.setString(2, timeStamp.getIn().toString());
                stat.setString(3, timeStamp.getOut().toString());
                stat.setInt(4, timeStamp.getEmployee().getNumber());
                stat.execute();

            }
            else {
                 query = "UPDATE TimeStamp SET timeStampID = '" + timeStamp.getId() +
                                                "', inTime = '" + timeStamp.getIn().toString() +
                                                "', outTime = '" + timeStamp.getOut().toString() +
                                                "', FK_employeeId = '" + timeStamp.getEmployee().getNumber() +
                        "' where timeStampId =" + timeStamp.getId() + ";";
                stmt.executeQuery(query);

            }

            } catch (SQLException ex) {
                Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        return true;
    }
    /**
     * This method takes in a TimeStamp ID number and returns the timeStamp from the database
     * @param Requires a TimeStampID number (int)
     * @return returns a TimeStamp Object
     */
    public TimeStamp get(int number){
        try {
            TimeStamp timeStamp = new TimeStamp();


            stmt = con.createStatement();
            String query = "SELECT * FROM TimeStamp WHERE '" + number + "' = timeStampId;";
            results = stmt.executeQuery(query);
            while(results.next()){
                timeStamp = new TimeStamp(results.getInt("timeStampID"), results.getDate("inTime"), results.getDate("outTime"), null);
                if(results.getInt("FK_employeeId") != 0)
                {
                    EmployeeBroker eb = EmployeeBroker.getBroker();
                    timeStamp.setEmployee((Employee) eb.get(results.getInt("FK_employeeId")));
                }
            }

            return timeStamp;
        } catch (SQLException ex) {
            Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    /**
     * This method is used to retrieve an arraylist of all timeStamps in the database
     * @return Returns an arraylist full of all timeStamps in the database
     */
    public ArrayList getAll(){
        try {
            TimeStamp timeStamp = new TimeStamp();
            ArrayList<TimeStamp> ar = new ArrayList<TimeStamp>();
            stmt = con.createStatement();
            String query = "SELECT * FROM TimeStamp;";
            results = stmt.executeQuery(query);

            while(results.next()){
                timeStamp = new TimeStamp(results.getInt("timeStampID"), results.getDate("inTime"), results.getDate("outTime"), null);
                if(results.getInt("FK_employeeId") != 0)
                {
                    EmployeeBroker eb = EmployeeBroker.getBroker();
                    timeStamp.setEmployee((Employee) eb.get(results.getInt("FK_employeeId")));
                }
                ar.add(timeStamp);
            }

            return ar;
        } catch (SQLException ex) {
            Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * This method takes in a TimeStamp ID number and deletes that timeStamp from the database
     * @param Requires a TimeStamp ID number (int)
     * @return Returns true if the timeStamp is removed and false if it is not removed
     */
    public boolean remove(int number){
        try {
            CallableStatement stat = con.prepareCall("call spDeleteTimeStamp(?);");
            stat.setInt(1, number);
            stat.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TimeStampDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }




}
