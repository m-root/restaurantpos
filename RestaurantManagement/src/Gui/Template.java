/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableSelection.java
 *
 * Created on Mar 2, 2009, 6:22:18 PM
 */

package Gui;

import businessobjects.Table;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import persistence.TableBroker;

/**
 *
 * @author 349322
 */
public class Template extends javax.swing.JFrame {

    Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    int screenWidth = (int)dim.getWidth();
    int screenHeight = (int)dim.getHeight();
    static Template t=null;
    
    /** Creates new GUI */
    private Template() {
        initComponents();
        vSep.setBounds(130,80,vSep.getWidth(),jPanel1.getHeight()-80);
        jPanel2.setSize(screenWidth,jPanel2.getHeight());
        lblTitle.setLocation(screenWidth/2+lblTitle.getWidth()/2, lblTitle.getY());
    }

    /**
     * Singleton pattern that checks if an instance of the GUI has been created.
     * If not it creates one.
     * @return the GUI object
     */
    public static Template getGUI()
    {
        if (t==null)
        {
            t=new Template();

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gs = ge.getDefaultScreenDevice();

            try {
                gs.setFullScreenWindow(t);
                t.validate();
            } catch(Error e) {
                gs.setFullScreenWindow(null);
            }

            t.setVisible(true);
        }

        return t;
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        vSep.setOrientation(javax.swing.SwingConstants.VERTICAL);
        vSep.setBounds(130, 80, 50, 740);
        tableBack.add(vSep, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 22));
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/home.png"))); // NOI18N
        btnHome.setFocusable(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lblTitle.setText("Screen Title");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLayeredPane tableBack;
    private javax.swing.JSeparator vSep;
    // End of variables declaration//GEN-END:variables

}
