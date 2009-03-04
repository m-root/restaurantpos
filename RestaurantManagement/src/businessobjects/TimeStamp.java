/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

import java.util.Date;
import java.util.Date;

/**
 *
 * @author 457226
 */
public class TimeStamp {
    private int id;
    private Date in;
    private Date out;
    private Employee employee;
    private Date d;
    public TimeStamp() {
    }

    public TimeStamp(int id, Date in, Date out, Employee employee) {
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

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }

}
