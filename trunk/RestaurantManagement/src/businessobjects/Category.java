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
public class Category extends Categorizable{
    private int id;
    private String name;
    private Category parent;
    private ArrayList<Categorizable> sub;//a category can have both items and Categorys!!! i think a rename should be done items is not fitting anymore...

    public Category() {
    }

    public Category(int id, String name, Category parent, ArrayList<Categorizable> sub) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        this.sub = sub;
    }

    public ArrayList<Categorizable> getSubs() {
        return sub;
    }

    public void setSubs(ArrayList<Categorizable> sub) {
        this.sub = sub;
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


}
