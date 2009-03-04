/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

import java.util.ArrayList;

/**
 *
 * @author 457226
 */
public class Employee {
    private int number;
    private char role;
    private String fName;
    private String lName;
    private String phone;
    private String sin;
    private String address;
    private double wage;

    public Employee() {
    }

    public Employee(int number, char role, String fName, String lName, String phone, String sin, String address, double wage) {
        this.number = number;
        this.role = role;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.sin = sin;
        this.address = address;
        this.wage = wage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double pay) {
        this.wage = pay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getRole() {
        return role;
    }

    public void setRole(char role) {
        this.role = role;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

}
