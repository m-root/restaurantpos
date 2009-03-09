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
    public static int TYPE_CATEGORY = 0;
    public static int TYPE_ITEM = 1;
    private int id;
    private String name;
    private Category parent;
    private int type;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
