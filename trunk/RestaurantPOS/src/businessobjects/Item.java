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
public class Item {
    private int id;
    private double price;
    private Category parent;
    private String name;
    private double cost;

    public Item() {
    }

    public Item(int id, double price, Category parent, String name, double cost) {
        this.id = id;
        this.price = price;
        this.parent = parent;
        this.name = name;
        this.cost = cost;
    }

    

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
