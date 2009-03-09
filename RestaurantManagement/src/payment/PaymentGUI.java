/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TableSelection.java
 *
 * Created on Mar 2, 2009, 6:22:18 PM
 */

package payment;

import Gui.*;
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
public class PaymentGUI extends javax.swing.JFrame {

    Dimension dim = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    int screenWidth = (int)dim.getWidth();
    int screenHeight = (int)dim.getHeight();
    static PaymentGUI t=null;
    
    /** Creates new GUI */
    private PaymentGUI() {
        initComponents();
        vSep.setBounds(130,80,vSep.getWidth(),jPanel1.getHeight()-80);
        jPanel2.setSize(screenWidth,jPanel2.getHeight());
        lblTitle.setLocation(screenWidth/2+lblTitle.getWidth()/2, lblTitle.getY());
        btnUp.setVisible(false);
    }

    /**
     * Singleton pattern that checks if an instance of the GUI has been created.
     * If not it creates one.
     * @return the GUI object
     */
    public static PaymentGUI getGUI()
    {
        if (t==null)
        {
            t=new PaymentGUI();
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
        btnUp = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

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
        lblTitle.setText("Pay Bill");

        btnUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/up.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(37, 37, 37)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
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
                    .addComponent(btnUp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(lblTitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, Short.MAX_VALUE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
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

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 20));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/giftcard.png"))); // NOI18N
        jButton2.setFocusPainted(false);
        jButton2.setBounds(570, 190, 110, 60);
        tableBack.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gift");
        jLabel2.setBounds(600, 160, 60, 20);
        tableBack.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton3.setText("Clear");
        jButton3.setFocusPainted(false);
        jButton3.setBounds(10, 530, 110, 60);
        tableBack.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 20));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Debit.png"))); // NOI18N
        jButton4.setFocusPainted(false);
        jButton4.setBounds(310, 190, 110, 60);
        tableBack.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 20));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/credit_card.png"))); // NOI18N
        jButton5.setFocusPainted(false);
        jButton5.setBounds(440, 190, 110, 60);
        tableBack.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Method");
        jLabel3.setBounds(370, 100, 130, 40);
        tableBack.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Debit");
        jLabel5.setBounds(330, 160, 70, 20);
        tableBack.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Credit");
        jLabel6.setBounds(460, 160, 72, 20);
        tableBack.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Gold");
        jLabel7.setBounds(210, 160, 70, 20);
        tableBack.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel8.setText("Sale Amount:");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel4.setText("Tip Amount:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setText("Due Amount:");

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setText("Paid Amount:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setText("Balance:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, 0, 0, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBounds(220, 430, 410, 250);
        tableBack.add(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField6.setAutoscrolls(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setText("Order Number:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setText("Table Number:");

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField7.setAutoscrolls(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel4.setBounds(220, 280, 410, 120);
        tableBack.add(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 20));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Cash.png"))); // NOI18N
        jButton6.setFocusPainted(false);
        jButton6.setBounds(180, 190, 110, 60);
        tableBack.add(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jButton7.setText("Tip");
        jButton7.setFocusPainted(false);
        jButton7.setBounds(10, 460, 110, 60);
        tableBack.add(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUp;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLayeredPane tableBack;
    private javax.swing.JSeparator vSep;
    // End of variables declaration//GEN-END:variables

}
