/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 457226
 */
public class TimeStamp {
    private int id;
    private Calendar in;
    private Calendar out;
    private Employee employee;
    private Date d;
    public TimeStamp() {
    }

    public TimeStamp(int id, Calendar in, Calendar out, Employee employee) {
        this.id = id;
        this.in = in;
        this.out = out;
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getIn() {
        return in;
    }

    public void setIn(Calendar in) {
        this.in = in;
    }

    public Calendar getOut() {
        return out;
    }

    public void setOut(Calendar out) {
        this.out = out;
    }

}
