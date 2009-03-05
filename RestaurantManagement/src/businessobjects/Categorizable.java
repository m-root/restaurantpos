/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

/**
 *
 * @author 457226
 */
public abstract class Categorizable {
    private int id;
    private String name;
    private Category parent;
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
