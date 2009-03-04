/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InputPopup.java
 *
 * Created on Feb 20, 2009, 11:07:36 AM
 */

package Gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author 457226
 */
public class InputPopup extends javax.swing.JFrame
{
    boolean done;
    /** Creates new form Gui */
    public InputPopup(){

    }

    /**
     * pops up a text field and show the message(label) and returns the user input
     * @param com the component that the popup will be centered on
     * @param label the message displayed to the user
     * @param defaultValue the value that will be pre displayed in the text field
     * @param keypad enter true if a on screen keypad is needed for input
     * @return the users input
     */
    public String Activate(Component com, String label, String defaultValue, boolean keypad){
        jTextField1.setText(defaultValue);
        return Activate(com,label,keypad);
    }

    /**
     * pops up a text field and show the message(label) and returns the user input
     * @param label the message displayed to the user
     * @param defaultValue the value that will be pre displayed in the text field
     * @param keypad enter true if a on screen keypad is needed for input
     * @return the users input
     */
    public String Activate(String label, String defaultValue, boolean keypad){
        jTextField1.setText(defaultValue);
        return Activate(label,keypad);
    }

    /**
     * pops up a text field and show the message(label) and returns the user input
     * @param com the component that the popup will be centered on
     * @param label the message displayed to the user
     * @param keypad enter true if a on screen keypad is needed for input
     * @return the users input
     */
    public String Activate(Component com, String label, boolean keypad){
        return Activate(com.getX()+ com.getWidth()/2-this.getWidth()/2,com.getY()+ com.getHeight()/2-this.getHeight()/2,label,keypad);
    }

    /**
     * pops up a text field and show the message(label) and returns the user input
     * @param Xloc the x location the popup will be placed
     * @param Yloc the y location the popup will be placed
     * @param label the message displayed to the user
     * @param keypad enter true if a on screen keypad is needed for input
     * @return
     */
    public String Activate(int Xloc, int Yloc, String label, boolean keypad){
        this.setLocation(Xloc, Yloc);
        return Activate(label,keypad);
    }

    /**
     * pops up a text field and show the message(label) and returns the user input
     * @param label the message displayed to the user
     * @param keypad enter true if a on screen keypad is needed for input
     * @return the users input
     */
    public String Activate(String label, boolean keypad){
        initComponents();
        //start up stuff
        done = false;
        jLabel1.setText(label);
        this.setVisible(true);

        if(keypad){
            new KeyPad().Activate(jTextField1,this);
        }
        jPanel1.setOpaque(false);
        while(!done);

        this.setVisible(false);
        if(jTextField1.getText().compareTo("")==0){
            return null;
        }else{
            return jTextField1.getText();
        }
    }

    public String ActivateIn(JFrame com, String label, String defaultValue, boolean keypad){
        int Xloc = com.getX()+ com.getWidth()/2-176;
        int Yloc = com.getY()+ com.getHeight()/2-68;
        return ActivateIn(Xloc,Yloc,com,label,defaultValue,keypad);
    }

    /**
     * creats a JPanel on the glass layer of the JFrame
     * @param com the JFrame you want the popup applyed to
     * @param label the message displayed to the user
     * @param defaultValue the value that will be pre displayed in the text field
     * @param keypad enter true if a on screen keypad is needed for input
     * @return the users input
     */
    public String ActivateIn(int Xloc,int Yloc,JFrame com, String label, String defaultValue, boolean keypad){
        initComponents();
        //start up stuff
        done = false;
        jLabel1.setText(label);
        jTextField1.setText(defaultValue);

        if(keypad){
            new KeyPad().ActivateIn(jPanel2,jTextField1);
            jPanel2.setVisible(true);
        }else{
            jPanel2.setVisible(false);
            new KeyPad().ActivateIn(jPanel2,jTextField1);
        }
        
        JPanel glass = new JPanel(new SpringLayout());
        glass.setOpaque(false);

        Dimension dim = com.getSize();//new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        int change = 0;
        if(Yloc+jPanel1.getHeight()>dim.getHeight()){
            change = (int) (Yloc + jPanel1.getHeight() - dim.getHeight());
        }
        System.out.println("change = "+change);
        Box vBox1 = Box.createVerticalBox();
        vBox1.add(Box.createVerticalStrut(Yloc-change-30));
        vBox1.add(jPanel1);
        Box hBox1 = Box.createHorizontalBox();
        hBox1.add(Box.createHorizontalStrut(Xloc));
        hBox1.add(vBox1);
        glass.add(hBox1);

        com.setGlassPane(glass);
        glass.setVisible(true);
        MouseInputAdapter adapter = new MouseInputAdapter(){};
        glass.addMouseListener(adapter);
        glass.addMouseMotionListener(adapter);

        while(!done);

        glass.setVisible(false);
        jPanel1.setVisible(false);
        if(jTextField1.getText().compareTo("")==0){
            return null;
        }else{
            return jTextField1.getText();
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Label");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20));
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 342, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(178, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText("");
        done=true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        done=true;
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputPopup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}
