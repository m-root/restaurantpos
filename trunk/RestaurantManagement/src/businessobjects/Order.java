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
public class Order {
    private int id;
    private Table table;
    private int seat;
    private char paymentMethod;
    private boolean paid;
    private double paymentAmount;
    private ArrayList<Item> items;
    private ArrayList<Payment> payments;

    public Order() {
    }

    public Order(int id, Table table, int seat, char paymentMethod, boolean paid, double paymentAmount, ArrayList<Item> items) {
        this.id = id;
        this.table = table;
        this.seat = seat;
        this.paymentMethod = paymentMethod;
        this.paid = paid;
        this.paymentAmount = paymentAmount;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public char getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(char paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    

}
