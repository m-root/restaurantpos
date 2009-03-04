/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

/**
 *
 * @author 457226
 */
public class OrderItem {
    private Item item;
    private double cost;

    public OrderItem() {
    }

    /**
     *
     * @param item
     * @param cost
     */
    public OrderItem(Item item, double cost) {
        this.item = item;
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    

   

}
