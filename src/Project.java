
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;


//when welcome screen is diplayed tabbed pane's don't work properly  ?welcome fade?
//check on print functionality
//populate Transcripts
//filling in forms on manage_accounts
//homescrean financial aid first two columns are uneditable from both accounts.  all fields should be editable from admin account
//homescreen enroll tables need population

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zach Bryant
 * @author Guillermo Macbeath
 * @author Monilito Castro
 */

public class Project extends javax.swing.JFrame {

    /**
     * Creates new form Project
     */
    private CardLayout cl;
    public manage_accounts manage;
    private JTabbedPane manageTab;
    public mainMenu main;
    public int flag1=0;
    private JTabbedPane homeTab;
    public Transcripts order;
    public homescreen home;
    public JTable publicTable;
    //add public arrays no need to be static. names. Count the the textfield, dropdown
    //arAddress	8
    //arNames	7
    //arPhone	4
    //arEmail	3
    //arEMC     4
    Array arAddress, arName, arPhone, arEmail, arEMC;
    private Integer inAddress, inName, inPhone, inEmail, inEMC;  ///index to keep track of current index of array
    
   
    public Project() {
        initComponents();
        publicTable = new JTable();
        inAddress=0; inName=0; inPhone=0; inEmail=0; inEMC=0;
        arAddress = new Array();
        arName = new Array();
        arPhone = new Array();
        arEmail = new Array();
        arEMC = new Array();
               
        creategui();
        generateGui("logon");
        
        
        add(card, "Card");
        setVisible(true);

        
    }
    public int availableRow(JTable table){
        for(int i = 0; i<table.getRowCount(); i++){
            try{
                if(table.getValueAt(i, 0).equals(null) ){
                    return i;
                }
            }catch(Exception e){
                System.out.println(i+ " "+e.getMessage() + " "+ e );
                return i;
            }
            
        }
        return -1;
    }
    private void creategui()
    {
        cl = new CardLayout();
        card.setLayout(cl);
        
        jButton4.setVisible(false);
        jPanel1.setVisible(false);
        jButton3.setVisible(false);
        
        //login screen
        main = new mainMenu( this );
        card.add("logon", main);
        
        //home tabbed pane
        home = new homescreen( this );
        homeTab = home.jTabbedPane1;
        homeTab.setSelectedIndex(-1);
        card.add("home", homeTab);

        //manage tabbed pane
        manage = new manage_accounts( this );
        manageTab = manage.jTabbedPane2;
        card.add("manage", manageTab);
        
        //panels for adding components
        add_address address = new add_address( this );
        JPanel AddressTab = address.jPanel6;
        JPanel NameTab = address.jPanel7;
        JPanel PhoneTab = address.jPanel8;
        JPanel EmailTab = address.jPanel9;
        JPanel EmergencyTab = address.jPanel10;
        card.add("addAddress", AddressTab);
        card.add("addName", NameTab);
        card.add("addPhone", PhoneTab);
        card.add("addEmail", EmailTab);
        card.add("addEmergency", EmergencyTab);
        
        //order official transcript
         order = new Transcripts( this );
         JPanel order1 = order.jPanel1;
         JPanel order3 = order.jPanel3;
         JPanel unoff  = order.jPanel4;
         JPanel credit  = order.jPanel5;
         JPanel chk_sv  = order.jPanel6;
         card.add("order1", order1);
         card.add("order3", order3);        
         card.add("unofficial", unoff);
         card.add("credit", credit);
         card.add("chk_sv", chk_sv);
         
         //selecting users
         select_user selectuser = new select_user( this );
         JPanel select = selectuser.sel;
         card.add("select", select);
         
         //claim account
         claimaccount claim = new claimaccount( this );
         card.add("claim",claim);
         
         //forgot password
         forgot_password forgot = new forgot_password( this );
         card.add("forgot", forgot);
    }

    public void generateGui(String text)
    {
        
         cl.show(card, text);
    }
    public void generateGui(String text , int index){
        
        if (index==10)
        {
         generateGui(text);
         jPanel1.setVisible(true);
         jButton4.setVisible(true);
         jLabel2.setText("You are logged in as: Admin");
         manage.jTextField1.setEnabled(true);
         manage.jTextField2.setEnabled(true);
         manage.jTextField3.setEnabled(true);
         manage.jTextField4.setEnabled(true);
         manage.jTextField5.setEnabled(true);
         manage.jTextField6.setEnabled(true);
        }
        else if (index==12)
        {
            generateGui(text);
            manage.jTextField1.setEnabled(false);
            manage.jTextField2.setEnabled(false);
            manage.jTextField3.setEnabled(false);
            manage.jTextField4.setEnabled(false);
            manage.jTextField5.setEnabled(false);
            manage.jTextField6.setEnabled(false);
            manage.jTextField1.setEditable(false);
            manage.jTextField2.setEditable(false);
            manage.jTextField3.setEditable(false);
            manage.jTextField4.setEditable(false);
            manage.jTextField5.setEditable(false);
            manage.jTextField6.setEditable(false);            
        }
        else
        {
            generateGui(text);
            manageTab.setSelectedIndex(index);
            homeTab.setSelectedIndex(index);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        card = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Khmer UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 150, 0));
        jLabel1.setText("UND");

        jButton1.setText("Manage Accounts");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Printer Friendly");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel2.setText("You are logged in as: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout cardLayout = new javax.swing.GroupLayout(card);
        card.setLayout(cardLayout);
        cardLayout.setHorizontalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        cardLayout.setVerticalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
        );

        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Logout");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(card, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        generateGui("manage",0);
        jButton3.setVisible(true);
        jButton1.setEnabled(false);    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    generateGui("home", 0);
    jButton3.setVisible(false);
    jButton1.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // logs out of current user
        cl.show(card, "logon");
        main.pfPassword1.setText("jPasswordField1");
        main.txtUser1.setText(null);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        jButton1.setEnabled(true);
        jPanel1.setVisible(false);
        homeTab.setSelectedIndex(-1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    //print code for just the current card
        //replace 'card' with 'this' to print out entire screen
        
    Toolkit tkp = card.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    card.print(g);
    g.dispose();
    pjp.end();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel card;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}