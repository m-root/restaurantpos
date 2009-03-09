/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ServerTableSelection.java
 *
 * Created on Mar 2, 2009, 6:22:18 PM
 */

package Gui;

import businessobjects.Table;
import businessobjects.Employee;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JLabel;
import persistence.TableBroker;

/**
 *
 * @author 349322
 */
public class ServerTableSelection extends javax.swing.JFrame {

    int currFloor;
    Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    int screenWidth = (int)dim.getWidth();
    int screenHeight = (int)dim.getHeight();
    static ServerTableSelection t=null;

    Employee currEmp = null;

    ArrayList compArray = new ArrayList();

    /** Creates new form ServerTableSelection */
    private ServerTableSelection() {
        initComponents();
        currFloor=1;
        vSep.setBounds(130,80,vSep.getWidth(),jPanel1.getHeight()-80);
        jPanel2.setSize(screenWidth,jPanel2.getHeight());
        btnLogout.setLocation(screenWidth-btnLogout.getWidth()-30, btnLogout.getY());
        //loadTables();
    }

    public static ServerTableSelection getGUI()
    {
        if (t==null)
        {
            t=new ServerTableSelection();
            t.setVisible(true);
        }

        return t;
    }

    public void loadTables()
    {
        //TODO: Inactive (Gray), Open/Available (Green), Seated (Yellow), Active (Blue), Bussing (Purple)
        TableBroker tb = TableBroker.getBroker();
        ArrayList load = tb.getAll();

        for (int i=0;i<load.size();i++)
        {
            Table curr = (Table)load.get(i);

            if (curr.getFloor()==currFloor)
            {
                javax.swing.JLabel tempObjLabel = new javax.swing.JLabel();
                javax.swing.JLabel tempObj = new javax.swing.JLabel();
                javax.swing.JLabel tempObjSeats = new javax.swing.JLabel();

                tempObjLabel.setForeground(new java.awt.Color(255, 255, 255));
                tempObjLabel.setFont(new java.awt.Font("Tahoma", 0, 22));
                tempObjLabel.setBounds(20, 50, 90, 30);
                tempObjLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                tempObjLabel.setText(curr.getId()+"");

                if (curr.getType()=='T')
                {
                    if (curr.getServer()!=null&&curr.getServer().getNumber()==currEmp.getNumber())
                    {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table.png")));
                    } else {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/table-gray.png")));
                    }
                tempObj.setToolTipText("Table");
                } else if (curr.getType()=='B')
                {
                    if (curr.getServer()!=null&&curr.getServer().getNumber()==currEmp.getNumber())
                    {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/booth.png")));
                    } else {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/booth-gray.png")));
                    }
                tempObj.setToolTipText("Booth");
                } else if (curr.getType()=='R')
                {
                    if (curr.getServer()!=null&&curr.getServer().getNumber()==currEmp.getNumber())
                    {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bar.png"))); // NOI18N
                    } else {
                        tempObj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/bar-gray.png")));
                    }
                    tempObj.setToolTipText("Bar");
                }

                tableBack.add(tempObj);
                compArray.add(tempObj);

                tempObj.setBounds(curr.getXLoc(), curr.getYLoc(), 92, 92);

                tempObj.add(tempObjLabel, 0);
                tempObj.getComponent(0).setLocation(0,tempObj.getHeight()/2-15);

                tempObjSeats.setForeground(new java.awt.Color(255, 255, 255));
                tempObjSeats.setText(curr.getSeats()+"");
                tempObjSeats.setBounds(380, 270, 6, 14);
                tempObj.add(tempObjSeats, 1);

                tempObjSeats.setVisible(false);
            }
        }
    }

    public void setCurrEmp(Employee currEmp)
    {
        this.currEmp=currEmp;
        loadTables();
    }

    /**
     * Method that clears all the tables from the screen.
     * Used when user wants to start restaurant configuration from scratch.
     */
    public void clearTables()
    {
        for (int i=compArray.size()-1;i>=0;i--)
        {
            ((JLabel)compArray.get(i)).setVisible(false);
            compArray.remove(i);
        }
    }

    /**
     * Changes the floor that is currently being configured
     * @param floor - the floor to open for configuration
     */
    public void changeFloor(int floor)
    {
        currFloor=floor;
        clearTables();
        loadTables();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tableBack = new javax.swing.JLayeredPane();
        vSep = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        lblFloor = new javax.swing.JLabel();
        btnFloor2 = new javax.swing.JButton();
        btnFloor1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        vSep.setOrientation(javax.swing.SwingConstants.VERTICAL);
        vSep.setBounds(130, 80, 50, 740);
        tableBack.add(vSep, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 22));
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        btnHome.setFocusable(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48));
        lblTitle.setText("Table Selection");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(32, 32, 32)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addContainerGap())
        );

        jPanel2.setBounds(0, 0, 770, 80);
        tableBack.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/help.png"))); // NOI18N
        btnHelp.setToolTipText("Help");
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusable(false);
        btnHelp.setBounds(40, 720, 50, 50);
        tableBack.add(btnHelp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        lblFloor.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblFloor.setForeground(new java.awt.Color(255, 255, 255));
        lblFloor.setText("Area:");
        lblFloor.setBounds(10, 610, 110, -1);
        tableBack.add(lblFloor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnFloor2.setFont(new java.awt.Font("Tahoma", 0, 22));
        btnFloor2.setForeground(Color.gray);
        btnFloor2.setText("2");
        btnFloor2.setFocusable(false);
        btnFloor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFloor2MouseReleased(evt);
            }
        });
        btnFloor2.setBounds(70, 650, 50, 50);
        tableBack.add(btnFloor2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnFloor1.setFont(new java.awt.Font("Tahoma", 0, 22));
        btnFloor1.setForeground(Color.red);
        btnFloor1.setText("1");
        btnFloor1.setFocusable(false);
        btnFloor1.setRolloverEnabled(false);
        btnFloor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnFloor1MouseReleased(evt);
            }
        });
        btnFloor1.setBounds(10, 650, 50, 50);
        tableBack.add(btnFloor1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableBack, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableBack, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFloor1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFloor1MouseReleased
        if (currFloor!=1) {
            changeFloor(1);
            btnFloor2.setForeground(Color.gray);
            btnFloor1.setForeground(Color.red);
            btnFloor1.setRolloverEnabled(false);
            btnFloor2.setRolloverEnabled(true);
        }
}//GEN-LAST:event_btnFloor1MouseReleased

    private void btnFloor2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFloor2MouseReleased
        if (currFloor!=2) {
            changeFloor(2);
            btnFloor1.setForeground(Color.gray);
            btnFloor2.setForeground(Color.red);
            btnFloor2.setRolloverEnabled(false);
            btnFloor1.setRolloverEnabled(true);
        }
}//GEN-LAST:event_btnFloor2MouseReleased

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();

        try {
            gs.setFullScreenWindow(t);
            t.validate();
        } catch(Error e) {
            gs.setFullScreenWindow(null);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getGUI();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFloor1;
    private javax.swing.JButton btnFloor2;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFloor;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLayeredPane tableBack;
    private javax.swing.JSeparator vSep;
    // End of variables declaration//GEN-END:variables

}
