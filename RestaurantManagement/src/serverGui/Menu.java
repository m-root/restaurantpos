/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableSelection.java
 *
 * Created on Mar 2, 2009, 6:22:18 PM
 */

package serverGui;

import businessobjects.*;
import businessobjects.Table;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import persistence.CategoryBroker;
import persistence.TableBroker;

/**
 *
 * @author 349322
 */
public class Menu extends javax.swing.JFrame {

    Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    int screenWidth = (int)dim.getWidth();
    int screenHeight = (int)dim.getHeight();
    int b1id = 0;
    int b2id = 0;
    int b3id = 0;
    int b4id = 0;
    int b5id = 0;
    int b6id = 0;
    int b7id = 0;
    int b8id = 0;
    int b9id = 0;
    int b10id = 0;
    int b11id = 0;
    int b12id = 0;
    int b13id = 0;
    int b14id = 0;
    int b15id = 0;
    int b16id = 0;
    static Menu t=null;
    
    /** Creates new GUI */
    private Menu() {
        initComponents();
        vSep.setBounds(130,80,vSep.getWidth(),jPanel1.getHeight()-80);
        jPanel2.setSize(screenWidth,jPanel2.getHeight());
        lblTitle.setLocation(screenWidth/2+lblTitle.getWidth()/2, lblTitle.getY());
        //btnUp.setVisible(false);
    }

    /**
     * Singleton pattern that checks if an instance of the GUI has been created.
     * If not it creates one.
     * @return the GUI object
     */
    public static Menu getGUI()
    {
        if (t==null)
        {
            t=new Menu();
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

    //methods
    //2 1 3 4 5 6 7 8 9 10 11 12 13 16 15 14

    public void setBase(){
        Category c = (Category)CategoryBroker.getBroker().get(0);
        getSub(c);
    }


    public void getSub(Category cat){
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jButton6.setVisible(false);
        jButton7.setVisible(false);
        jButton8.setVisible(false);
        jButton9.setVisible(false);
        jButton10.setVisible(false);
        jButton11.setVisible(false);
        jButton12.setVisible(false);
        jButton13.setVisible(false);
        jButton14.setVisible(false);
        jButton15.setVisible(false);
        jButton16.setVisible(false);

        int i = 1;
        if(cat.getSubs().size()>=i){
            jButton2.setText(cat.getSubs().get(i).getName());
            b2id = cat.getSubs().get(i).getId();
        jButton2.setVisible(false);
        }i = 2;
        if(cat.getSubs().size()>=i){
            jButton1.setText(cat.getSubs().get(i).getName());
            b1id = cat.getSubs().get(i).getId();
        jButton1.setVisible(false);
        }i = 3;
        if(cat.getSubs().size()>=i){
            jButton3.setText(cat.getSubs().get(i).getName());
            b3id = cat.getSubs().get(i).getId();
        jButton3.setVisible(false);
        }i = 4;
        if(cat.getSubs().size()>=i){
            jButton4.setText(cat.getSubs().get(i).getName());
            b4id = cat.getSubs().get(i).getId();
        jButton4.setVisible(false);
        }i = 5;
        if(cat.getSubs().size()>=i){
            jButton5.setText(cat.getSubs().get(i).getName());
            b5id = cat.getSubs().get(i).getId();
        jButton5.setVisible(false);
        }i = 6;
        if(cat.getSubs().size()>=i){
            jButton6.setText(cat.getSubs().get(i).getName());
            b6id = cat.getSubs().get(i).getId();
        jButton6.setVisible(false);
        }i = 7;
        if(cat.getSubs().size()>=i){
            jButton7.setText(cat.getSubs().get(i).getName());
            b7id = cat.getSubs().get(i).getId();
        jButton7.setVisible(false);
        }i = 8;
        if(cat.getSubs().size()>=i){
            jButton8.setText(cat.getSubs().get(i).getName());
            b8id = cat.getSubs().get(i).getId();
        jButton8.setVisible(false);
        }i = 9;
        if(cat.getSubs().size()>=i){
            jButton9.setText(cat.getSubs().get(i).getName());
            b9id = cat.getSubs().get(i).getId();
        jButton9.setVisible(false);
        }i = 10;
        if(cat.getSubs().size()>=i){
            jButton10.setText(cat.getSubs().get(i).getName());
            b10id = cat.getSubs().get(i).getId();
        jButton10.setVisible(false);
        }i = 11;
        if(cat.getSubs().size()>=i){
            jButton11.setText(cat.getSubs().get(i).getName());
            b11id = cat.getSubs().get(i).getId();
        jButton11.setVisible(false);
        }i = 12;
        if(cat.getSubs().size()>=i){
            jButton12.setText(cat.getSubs().get(i).getName());
            b12id = cat.getSubs().get(i).getId();
        jButton12.setVisible(false);
        }i = 13;
        if(cat.getSubs().size()>=i){
            jButton13.setText(cat.getSubs().get(i).getName());
            b13id = cat.getSubs().get(i).getId();
        jButton13.setVisible(false);
        }i = 14;
        if(cat.getSubs().size()>=i){
            jButton16.setText(cat.getSubs().get(i).getName());
            b16id = cat.getSubs().get(i).getId();
        jButton16.setVisible(false);
        }i = 15;
        if(cat.getSubs().size()>=i){
            jButton15.setText(cat.getSubs().get(i).getName());
            b15id = cat.getSubs().get(i).getId();
        jButton15.setVisible(false);
        }i = 16;
        if(cat.getSubs().size()>=i){
            jButton14.setText(cat.getSubs().get(i).getName());
            b14id = cat.getSubs().get(i).getId();
        jButton14.setVisible(false);
        }
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
        btnUp = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        vSep.setOrientation(javax.swing.SwingConstants.VERTICAL);
        vSep.setBounds(130, 80, 50, 740);
        tableBack.add(vSep, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);

        btnHome.setFocusable(false);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBounds(0, 0, 770, 80);
        tableBack.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        btnHelp.setToolTipText("Help");
        btnHelp.setBorderPainted(false);
        btnHelp.setContentAreaFilled(false);
        btnHelp.setFocusable(false);
        btnHelp.setBounds(40, 720, 50, 50);
        tableBack.add(btnHelp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton2.setText("MMMMMMMMM");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton1.setText("MMMMMMMMM");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton3.setText("MMMMMMMMM");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton4.setText("MMMMMMMMM");

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton5.setText("MMMMMMMMM");

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton6.setText("MMMMMMMMM");

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton7.setText("MMMMMMMMM");

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton8.setText("MMMMMMMMM");

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton9.setText("MMMMMMMMM");

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton10.setText("MMMMMMMMM");

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton11.setText("MMMMMMMMM");

        jButton12.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton12.setText("MMMMMMMMM");

        jButton13.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton13.setText("MMMMMMMMM");

        jButton14.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton14.setText("MMMMMMMMM");

        jButton15.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton15.setText("MMMMMMMMM");

        jButton16.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jButton16.setText("MMMMMMMMM");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel3.setBounds(130, 80, 1140, 740);
        tableBack.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tableBack, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
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
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getGUI();
                setBase();
            }
        });*/
        Menu m = Menu.getGUI();
        m.setVisible(true);
        m.setBase();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLayeredPane tableBack;
    private javax.swing.JSeparator vSep;
    // End of variables declaration//GEN-END:variables

}