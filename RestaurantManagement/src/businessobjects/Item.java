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
    private ArrayList<ItemAddon> addons;

    public Item() {
    }

    /**
     *
     * @param id
     * @param price
     * @param parent
     * @param name
     * @param addons
     */
    public Item(int id, double price, Category parent, String name, ArrayList<ItemAddon> addons) {
        this.id = id;
        this.price = price;
        this.parent = parent;
        this.name = name;
        this.addons = addons;
    }

    public ArrayList<ItemAddon> getAddons() {
        return addons;
    }

    public void setAddons(ArrayList<ItemAddon> addons) {
        this.addons = addons;
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
