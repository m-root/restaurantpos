/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

/**
 *
 * @author 457226
 */
public class Category {
    private int id;
    private String name;
    private Category parent;

    public Category() {
    }

    public Category(int id, String name, Category parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
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
