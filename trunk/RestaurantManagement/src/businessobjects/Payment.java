/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

/**
 *
 * @author Owner
 */
public class Payment {

    private int id;
    private char paymentMethod;
    private double paymentAmount;
    private double tip;

    public Payment(int id, char paymentMethod, double paymentAmount, double tip) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.paymentAmount = paymentAmount;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }



}
