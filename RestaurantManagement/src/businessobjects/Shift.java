/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author 457226
 */
public class Shift implements Serializable{
    private static final long serialVersionUID = 9040287304483793247L;
    private int id;
    private Calendar in;
    private Calendar out;
    private Employee employee;

    public Shift() {
    }

    public Shift(int id, Calendar in, Calendar out, Employee employee) {
        this.id = id;
        this.in = in;
        this.out = out;
        this.employee = employee;
    }

    public Calendar getOut() {
        return out;
    }

    public void setOut(Calendar out) {
        this.out = out;
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

    public int compareTo(Object o) {
        Shift ts = (Shift)o;
        return (int) (((getIn().get(Calendar.HOUR_OF_DAY) + (getIn().get(Calendar.DAY_OF_MONTH) + (getIn().get(Calendar.MONTH) + getIn().get(Calendar.YEAR) * 12) * 31) * 24)) - ((ts.getIn().get(Calendar.HOUR_OF_DAY) + (ts.getIn().get(Calendar.DAY_OF_MONTH) + (ts.getIn().get(Calendar.MONTH) + ts.getIn().get(Calendar.YEAR) * 12) * 31) * 24)));
    }

}
