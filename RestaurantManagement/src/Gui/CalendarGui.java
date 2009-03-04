/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CalendarGui.java
 *
 * Created on Feb 9, 2009, 2:36:16 PM
 */

package Gui;

import Gui.*;
import Gui.InputPopup;
import Gui.KeyPad;
import businesscalendar.TimeKeeper;
import businessobjects.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import other.*;

/**
 *
 * @author 457226
 */
public class CalendarGui extends javax.swing.JFrame
{

    TimeKeeper tk = TimeKeeper.getTimeKeeper();
    CalendarEdit cedt;// = CalendarEdit.getGui();

    int barvalue = 50;

    Calendar selectedDate;
    Calendar ddt = Calendar.getInstance();
    Calendar dd1;
    Calendar dd2;
    Calendar dd3;
    Calendar dd4;
    Calendar dd5;
    Calendar dd6;
    Calendar dd7;

    Vector dv1 = new Vector();
    Vector dv2 = new Vector();
    Vector dv3 = new Vector();
    Vector dv4 = new Vector();
    Vector dv5 = new Vector();
    Vector dv6 = new Vector();
    Vector dv7 = new Vector();


    /** Creates new form Gui */
    private static CalendarGui gui;
    private CalendarGui(){
        
    }
    public static CalendarGui getGui(){
        if(gui==null)
        {
            gui = new CalendarGui();
        }
        return gui;
    }

    public void startGUI(){

                initComponents();
                //start up stuff
                dd1 = ddt.getInstance();
                setDates(0);
                jList2.addListSelectionListener(new ListListener());
                jList3.addListSelectionListener(new ListListener());
                jList4.addListSelectionListener(new ListListener());
                jList5.addListSelectionListener(new ListListener());
                jList6.addListSelectionListener(new ListListener());
                jList7.addListSelectionListener(new ListListener());
                jList8.addListSelectionListener(new ListListener());
    }

    public void setCedt(CalendarEdit cedt) {
        this.cedt = cedt;
    }


    //methodes


    /**
     * sets the Jlists to there correct display dependent on the dates to be displayed
     * @param amount the amount of days that the schedule will be shifted
     */
    private void setDates(int amount){
        jLabel1.setText(dd1.get(Calendar.YEAR)+"");
        dd1.add(Calendar.DAY_OF_MONTH, amount);
        dd2 = copyDate(dd1);
        dd2.add(Calendar.DAY_OF_MONTH, 1);
        dd3 = copyDate(dd2);
        dd3.add(Calendar.DAY_OF_MONTH, 1);
        dd4 = copyDate(dd3);
        dd4.add(Calendar.DAY_OF_MONTH, 1);
        dd5 = copyDate(dd4);
        dd5.add(Calendar.DAY_OF_MONTH, 1);
        dd6 = copyDate(dd5);
        dd6.add(Calendar.DAY_OF_MONTH, 1);
        dd7 = copyDate(dd6);
        dd7.add(Calendar.DAY_OF_MONTH, 1);

        System.out.println(dd1.get(ddt.YEAR)+" : "+dd2.get(ddt.YEAR)+" : "+dd3.get(ddt.YEAR)+" : "+dd4.get(ddt.YEAR)+" : "+dd5.get(ddt.YEAR)+" : "+dd6.get(ddt.YEAR)+" : "+dd7.get(ddt.YEAR)+" : ");

        jTextArea1.setText(printDate());

        setCellBlank(dv1);
        setCellBlank(dv2);
        setCellBlank(dv3);
        setCellBlank(dv4);
        setCellBlank(dv5);
        setCellBlank(dv6);
        setCellBlank(dv7);

        setCell(dv1,dd1);
        setCell(dv2,dd2);
        setCell(dv3,dd3);
        setCell(dv4,dd4);
        setCell(dv5,dd5);
        setCell(dv6,dd6);
        setCell(dv7,dd7);

        setList(dv1,jList2);
        setList(dv2,jList3);
        setList(dv3,jList4);
        setList(dv4,jList5);
        setList(dv5,jList6);
        setList(dv6,jList7);
        setList(dv7,jList8);

    }

    /**
     * sets the selected cell blank but full of empty slots
     * @param v the vector to be blanked out
     */
    private void setCellBlank(Vector v){
        v.clear();
        String s = " ";
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
        v.add(s);
    }

    /**
     * takes in a day(Calendar cl) then checks if any Shifts in the times arrayList are on this day
     * if they are it places the shift in the corect time slot on the day
     * @param v the vector that should be blanked that will now be filled with Shifts
     * @param cl the day
     */
    private void setCell(Vector v, Calendar cl){
        for(int i = 0;i<tk.times.size();i++){
            Shift sft = tk.times.get(i).get(0);
            if(sft.getIn().get(Calendar.YEAR)==cl.get(Calendar.YEAR)&&sft.getIn().get(Calendar.MONTH)==cl.get(Calendar.MONTH)&&sft.getIn().get(Calendar.DAY_OF_MONTH)==cl.get(Calendar.DAY_OF_MONTH)){
                if(tk.times.get(i).size()>1){
                    String dots = "*";
                    while(dots.length()<tk.times.get(i).size())
                        dots += "*";
                    v.set((int)sft.getIn().get(Calendar.HOUR_OF_DAY), new StringMod().center(dots, 12));
                }else{
                    v.set((int)sft.getIn().get(Calendar.HOUR_OF_DAY), new StringMod().center(sft.getEmployee().getFName(),12));
                }
            }
        }
    }

    /**
     * sets a JList to display the data in a Vector
     * @param v the vector to be displayed
     * @param j the JList to display the data
     */
    private void setList(Vector v, JList j){
        j.setListData(v);
    }

    /**
     * takes in a Calendar object and returns a copy of it
     * @param date the date that should be copyed
     * @return a copy of the date
     */
    private Calendar copyDate(Calendar date){
        Calendar date2 = Calendar.getInstance();
        date2.set(Calendar.MONTH, date.get(Calendar.MONTH));
        date2.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
        date2.set(Calendar.YEAR, date.get(Calendar.YEAR));
        return date2;
    }

    /**
     * creates a string of days of the week and corrasponding dates under them determaind by the dd calendar objects
     * @return a string of days of the week and corrasponding dates
     */
    private String printDate(){
        StringMod sm = new StringMod();
        int space = 5;
        String str = "";
        str = sm.addSpace(str, 2);
        str += sm.numToMonth(dd1.get(ddt.MONTH))+"/"+add2D(dd1.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd2.get(ddt.MONTH))+"/"+add2D(dd2.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd3.get(ddt.MONTH))+"/"+add2D(dd3.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd4.get(ddt.MONTH))+"/"+add2D(dd4.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd5.get(ddt.MONTH))+"/"+add2D(dd5.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd6.get(ddt.MONTH))+"/"+add2D(dd6.get(ddt.DAY_OF_MONTH)+"");
        str = sm.addSpace(str, space);
        str += sm.numToMonth(dd7.get(ddt.MONTH))+"/"+add2D(dd7.get(ddt.DAY_OF_MONTH)+"");
        str += "\n";
        space = 8;
        str = sm.addSpace(str, 3);
        str += sm.numToWeekDay(dd1.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd2.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd3.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd4.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd5.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd6.get(ddt.DAY_OF_WEEK));
        str = sm.addSpace(str, space);
        str += sm.numToWeekDay(dd7.get(ddt.DAY_OF_WEEK));
        return str;
    }

    /**
     * takes in a day of the month and if it is 1-9 adds a 0 to the begging of it to add unity to the display
     * @param s the day of the month to check if 0 is needed
     * @return the day with a 0 if needed
     */
    private String add2D(String s){
        if(s.length()<2){
            s = "0"+s;
        }
        return s;
    }

    /**
     * checks what index is selected in all of the 7 JLists and gets the shift arraylist that goes with the selected index
     */
    private ArrayList<Shift> getSelection(){
        ArrayList<Shift> shifts = new ArrayList();
        selectedDate = null;
        if(!jList2.isSelectionEmpty()){
            selectedDate = copyDate(dd1);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList2.getSelectedIndex());
        }else if(!jList3.isSelectionEmpty()){
            selectedDate = copyDate(dd2);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList3.getSelectedIndex());
        }else if(!jList4.isSelectionEmpty()){
            selectedDate = copyDate(dd3);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList4.getSelectedIndex());
        }else if(!jList5.isSelectionEmpty()){
            selectedDate = copyDate(dd4);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList5.getSelectedIndex());
        }else if(!jList6.isSelectionEmpty()){
            selectedDate = copyDate(dd5);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList6.getSelectedIndex());
        }else if(!jList7.isSelectionEmpty()){
            selectedDate = copyDate(dd6);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList7.getSelectedIndex());
        }else if(!jList8.isSelectionEmpty()){
            selectedDate = copyDate(dd7);
            selectedDate.set(selectedDate.HOUR_OF_DAY, jList8.getSelectedIndex());
        }

        for(int i = 0;i<tk.times.size();i++){
            Shift sft = tk.times.get(i).get(0);
            if(sft.getIn().get(Calendar.YEAR)==selectedDate.get(Calendar.YEAR)&&sft.getIn().get(Calendar.MONTH)==selectedDate.get(Calendar.MONTH)&&sft.getIn().get(Calendar.DAY_OF_MONTH)==selectedDate.get(Calendar.DAY_OF_MONTH)&&sft.getIn().get(Calendar.HOUR_OF_DAY)==selectedDate.get(Calendar.HOUR_OF_DAY)){
                shifts = tk.times.get(i);
                break;
            }
        }

        /*System.out.println("\nnum of Employees at "+ selectedDate.get(selectedDate.HOUR_OF_DAY) +" = "+shifts.size());
        for(int i = 0;i<shifts.size();i++){
            System.out.println(i+1+": "+shifts.get(i).getEmployee().getFName());
        }*/

        return shifts;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 22));
        jLabel1.setText("2000");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jList1.setFont(new java.awt.Font("Courier New", 0, 18));
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { " 0:00", " 1:00", " 2:00", " 3:00", " 4:00", " 5:00", " 6:00", " 7:00", " 8:00", " 9:00", "10:00", "11:00", "12:00", " 1:00", " 2:00", " 3:00", " 4:00", " 5:00", " 6:00", " 7:00", " 8:00", " 9:00", "10:00", "11:00" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jScrollBar1.setBlockIncrement(1);
        jScrollBar1.setMaximum(160);
        jScrollBar1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        jScrollBar1.setValue(50);
        jScrollBar1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollBar1MouseWheelMoved(evt);
            }
        });
        jScrollBar1.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                jScrollBar1AdjustmentValueChanged(evt);
            }
        });

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 1, 20));
        jTextArea1.setRows(5);
        jScrollPane9.setViewportView(jTextArea1);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(38, 132));

        jList2.setFont(new java.awt.Font("Courier New", 0, 18));
        jList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.setMinimumSize(new java.awt.Dimension(35, 80));
        jList2.setPreferredSize(new java.awt.Dimension(38, 80));
        jScrollPane2.setViewportView(jList2);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(38, 132));

        jList3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jList3.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList3.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane3.setViewportView(jList3);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(38, 132));

        jList4.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jList4.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList4.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane4.setViewportView(jList4);

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane5.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(38, 132));

        jList5.setFont(new java.awt.Font("Courier New", 0, 18));
        jList5.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList5.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane5.setViewportView(jList5);

        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane6.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(38, 132));

        jList6.setFont(new java.awt.Font("Courier New", 0, 18));
        jList6.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList6.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane6.setViewportView(jList6);

        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane7.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(38, 132));

        jList7.setFont(new java.awt.Font("Courier New", 0, 18));
        jList7.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList7.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane7.setViewportView(jList7);

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane8.setMinimumSize(new java.awt.Dimension(38, 8));
        jScrollPane8.setPreferredSize(new java.awt.Dimension(38, 132));

        jList8.setFont(new java.awt.Font("Courier New", 0, 18));
        jList8.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "12345678901234" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList8.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList8.setMinimumSize(new java.awt.Dimension(35, 80));
        jScrollPane8.setViewportView(jList8);

        jMenu1.setText("File");

        jMenuItem1.setText("Save");
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setText("Edit");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollBar1AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_jScrollBar1AdjustmentValueChanged
        if(jScrollBar1.getValueIsAdjusting()==true){
            setDates(jScrollBar1.getValue()-barvalue);

        }else{
            jScrollBar1.setValue(50);
        }
        barvalue = jScrollBar1.getValue();
}//GEN-LAST:event_jScrollBar1AdjustmentValueChanged

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        cedt.setVisible(true);
        cedt.setFields(getSelection(),selectedDate);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jScrollBar1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollBar1MouseWheelMoved
        jScrollBar1.setValue(1);
    }//GEN-LAST:event_jScrollBar1MouseWheelMoved

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalendarGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JList jList4;
    private javax.swing.JList jList5;
    private javax.swing.JList jList6;
    private javax.swing.JList jList7;
    private javax.swing.JList jList8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    //subclass
    public class ListListener implements ListSelectionListener
    {
        /**
         * if a new list is selected it deselects all other lists
         * @param e the list
         */
        public void valueChanged(ListSelectionEvent e)
        {
            if(e.getSource()==jList2 && jList2.hasFocus()){
                jList3.clearSelection();
                jList4.clearSelection();
                jList5.clearSelection();
                jList6.clearSelection();
                jList7.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList3 && jList3.hasFocus()){
                jList2.clearSelection();
                jList4.clearSelection();
                jList5.clearSelection();
                jList6.clearSelection();
                jList7.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList4 && jList4.hasFocus()){
                jList3.clearSelection();
                jList2.clearSelection();
                jList5.clearSelection();
                jList6.clearSelection();
                jList7.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList5 && jList5.hasFocus()){
                jList3.clearSelection();
                jList4.clearSelection();
                jList2.clearSelection();
                jList6.clearSelection();
                jList7.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList6 && jList6.hasFocus()){
                jList3.clearSelection();
                jList4.clearSelection();
                jList5.clearSelection();
                jList2.clearSelection();
                jList7.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList7 && jList7.hasFocus()){
                jList3.clearSelection();
                jList4.clearSelection();
                jList5.clearSelection();
                jList6.clearSelection();
                jList2.clearSelection();
                jList8.clearSelection();
            }else if(e.getSource()==jList8 && jList8.hasFocus()){
                jList3.clearSelection();
                jList4.clearSelection();
                jList5.clearSelection();
                jList6.clearSelection();
                jList7.clearSelection();
                jList2.clearSelection();
            }
        }
    }
}
