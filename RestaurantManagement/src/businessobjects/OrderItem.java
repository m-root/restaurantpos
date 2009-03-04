/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author 457226
 */
public class OrderItem {
    private int orderItemId;
    private Item item;
    private double price;
    private int seat;
    private ArrayList<ItemAddon> itemAddon;
    private int orderId;

    public OrderItem() {
    }

    public OrderItem(int orderItemId, Item item, double price, int seat, ArrayList<ItemAddon> itemAddon, int orderId) {
        this.orderItemId = orderItemId;
        this.item = item;
        this.price = price;
        this.seat = seat;
        this.itemAddon = itemAddon;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public ArrayList<ItemAddon> getItemAddon() {
        return itemAddon;
    }

    public void setItemAddon(ArrayList<ItemAddon> itemAddon) {
        this.itemAddon = itemAddon;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getprice() {
        return price;
    }

    public void setprice(double price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    

   

}
