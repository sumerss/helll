/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billingcp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Sumer
 */
public class frameR extends javax.swing.JFrame {

    /**
     * Creates new form frameR
     */
    public frameR() {
        initComponents();
        
             
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(550, 790, 108, 38);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 29, 108, 38);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CRITERIA");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(860, 120, 130, 30);

        jList1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Customer wise", "Month wise" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(110, 190, 160, 110);

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(330, 220, 90, 30);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(450, 220, 90, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(370, 280, 140, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("SELECT ONE OF THESE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 100, 240, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(750, 200, 100, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(950, 200, 100, 30);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(232, 360, 530, 402);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("FROM                                                     TO");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(750, 160, 290, 20);

        jButton5.setText("VIEW");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(840, 260, 120, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String item=jList1.getSelectedValue();
        if(item=="Customer wise")
        {
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biling","root","root");

            Statement stmt=con.createStatement();
            String querry="Select distinct(customer_name) from customer; ";
            ResultSet rs=stmt.executeQuery(querry);
            while(rs.next()){
            jComboBox1.addItem(rs.getString("customer_name"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        }
         if(item=="Month wise")
        {
            JOptionPane.showMessageDialog(null, "enter the date in YYYY/MM/DD in criteria");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        
        String criteria=(String) jComboBox1.getSelectedItem();
                                  
             try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biling","root","root");

            Statement stmt=con.createStatement();
            String querry="Select hsn from customer where customer_name='"+criteria+"';";
            ResultSet rs=stmt.executeQuery(querry);
             rs.next();
            int id=rs.getInt("hsn");
            querry="select goods,qnt,amt,date from invoice where code= "+id+";";
           
            rs=stmt.executeQuery(querry);
            
            DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                
                model.addColumn("Description");
                model.addColumn("Quantity");
                model.addColumn("Amount");  
                model.addColumn("Date");  
            while(rs.next()){
                
             model.addRow(new Object[]{rs.getString("goods"),rs.getDouble("qnt"),rs.getDouble("amt"),rs.getDate("date")});
            
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frame2 ob=new frame2();
        ob.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
         PrinterJob job = PrinterJob.getPrinterJob();
       job.setJobName("Print Data.");
       
       job.setPrintable(new Printable() {
           @Override
           public int print(Graphics pg, PageFormat pf, int pageNum){
               
               if(pageNum>0){
                   return Printable.NO_SUCH_PAGE;
               }
               Graphics2D gd=(Graphics2D)pg;
               gd.translate(pf.getImageableX(), pf.getImageableY());
               gd.scale(0.65, 0.45);
//               jPanel1.paint(pg);                            
               return Printable.PAGE_EXISTS;
           }           
       });
       job.printDialog();
         try {
             job.print();
         } catch (PrinterException ex) {
             Logger.getLogger(frameR.class.getName()).log(Level.SEVERE, null, ex);
         }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        
        String d1=jTextField1.getText();
        String d2=jTextField2.getText();
         DefaultTableModel model=(DefaultTableModel)jTable2.getModel();
                model.addColumn("cust_code");
                model.addColumn("Customer");
                model.addColumn("Inv_no");
                model.addColumn("Description");                
                model.addColumn("Amount");  
                model.addColumn("Date");  
        
         try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/biling","root","root");

            Statement stmt=con.createStatement();
            String querry="Select customer.hsn,customer.customer_name,invoice.inv_no,invoice.goods,invoice.amt,invoice.date from customer,invoice where (customer.hsn=invoice.code)AND(invoice.date BETWEEN '"+d1+"' AND '"+d2+"');";                                                     
            ResultSet rs=stmt.executeQuery(querry);
           
            while(rs.next()){
                
             model.addRow(new Object[]{rs.getInt("hsn"),rs.getString("customer_name"),rs.getInt("inv_no"),rs.getString("goods"),rs.getDouble("amt"),rs.getDate("date")});
            
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(frameR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frameR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
