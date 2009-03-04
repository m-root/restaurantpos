/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businessobjects;

/**
 *
 * @author 457226
 */
public class Table {
    private int id;
    private char status;
    private int seats;
    private int xLoc;
    private int yLoc;
    private char type;
    int floor;
    private Employee server;

    public Table() {
    }

    /**
     *
     * @param id
     * @param status
     * @param seats
     * @param xLoc
     * @param yLoc
     * @param type
     * @param server
     */
    public Table(int id, char status, int seats, int xLoc, int yLoc, char type, Employee server, int floor) {
        this.id = id;
        this.status = status;
        this.seats = seats;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.type = type;
        this.server = server;
        this.floor = floor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Employee getServer() {
        return server;
    }

    public void setServer(Employee server) {
        this.server = server;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

}