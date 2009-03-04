/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package businesscalendar;

import Gui.CalendarEdit;
import Gui.CalendarGui;
import businessobjects.*;
import gui.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 457226
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();
        Calendar cl3 = Calendar.getInstance();
        Calendar cl4 = Calendar.getInstance();
        Calendar cl5 = Calendar.getInstance();
        Calendar cl6 = Calendar.getInstance();

        TimeKeeper tk = TimeKeeper.getTimeKeeper();
        Employee em = new Employee();
        em.setFName("Jack");


        cl1.set(Calendar.HOUR_OF_DAY, 8);
        Shift t1 = new Shift(1,cl1,em);
        tk.addShift(t1);

        cl2.set(Calendar.HOUR_OF_DAY, 10);
        Shift t2 = new Shift(2,cl2,em);
        tk.addShift(t2);

        cl3.set(Calendar.HOUR_OF_DAY, 8);
        Shift t3 = new Shift(3,cl3,em);
        tk.addShift(t3);

        cl4.set(Calendar.DAY_OF_MONTH, 19);
        cl5.set(Calendar.DAY_OF_MONTH, 19);
        cl6.set(Calendar.DAY_OF_MONTH, 22);
        Shift t4 = new Shift(4,cl4,em);
        tk.addShift(t4);

        cl5.set(Calendar.HOUR_OF_DAY, 15);
        Shift t5 = new Shift(5,cl5,em);
        tk.addShift(t5);

        cl6.set(Calendar.HOUR_OF_DAY, 8);
        Shift t6 = new Shift(6,cl6,em);
        tk.addShift(t6);
        
        
        tk.print();



        CalendarGui gui = CalendarGui.getGui();
        gui.setVisible(true);
        gui.startGUI();

        CalendarEdit cedt = CalendarEdit.getGui();
        cedt.startGUI();
        gui.setCedt(cedt);
        //cedt.setVisible(true);
    }

}
