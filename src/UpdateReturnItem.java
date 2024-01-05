
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class UpdateReturnItem extends javax.swing.JFrame {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/mabs";
    private static final String DB_USERNAME = "mabs";
    private static final String DB_PASSWORD = "admin";
    
    private String itemName;
    private int borrowId;
    private int goodItemBorrow;
    private int badItemBorrow;
    
    
    /**
     * Creates new form ViewReturnItem
     */
    public UpdateReturnItem() {
        initComponents();
        
        Connection connection = null;
        PreparedStatement searchStatement = null;
        ResultSet searchRs = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
        
            String searchQuery = "SELECT * FROM boroweditem WHERE borrowed_id = ?";
            searchStatement = connection.prepareStatement(searchQuery);
            searchStatement.setInt(1, Tables.getInstance().getRowId());
            searchRs = searchStatement.executeQuery();
            
            JTable table = Tables.getInstance().getReturnTable();
        
            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            defaultTable.setRowCount(0); 

            if (searchRs.next()) {
                
                // set the default value of text fields
                nameField.setText(searchRs.getString("student_name"));
                idNumberField.setText(searchRs.getString("id_number"));
                cellNumberField.setText(searchRs.getString("cell_number"));
                itemNameField.setText(searchRs.getString("item_name"));
                goodConditionField.setText(searchRs.getString("good_item"));
                badConditionField.setText(searchRs.getString("bad_item"));
                approvedByField.setText(searchRs.getString("approvedBy"));
                courseField.setText(searchRs.getString("course"));
                yearLevelField.setText(searchRs.getString("year_level"));
                sectionField.setText(searchRs.getString("section"));
                purposeField.setText(searchRs.getString("purpose"));
                dateBorrowedField.setText(searchRs.getString("borrow_date"));
                dueDateField.setText(searchRs.getString("due_date"));
                
                // set the essential value for update
                this.borrowId = searchRs.getInt("borrowed_id");
                this.itemName = searchRs.getString("item_name");
                try {
                    this.goodItemBorrow = Integer.parseInt(goodConditionField.getText());
                    this.badItemBorrow = Integer.parseInt(badConditionField.getText());
                } catch (NumberFormatException e) {
                    
                }
                
            }
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {
                if (searchRs != null) {
                    searchRs.close();
                }
                if (searchStatement != null) {
                    searchStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        idNumberField = new javax.swing.JTextField();
        cellNumberField = new javax.swing.JTextField();
        courseField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        purposeField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        approvedByField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sectionField = new javax.swing.JTextField();
        yearLevelField = new javax.swing.JTextField();
        dateBorrowedField = new javax.swing.JTextField();
        dueDateField = new javax.swing.JTextField();
        goodConditionField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        badConditionField = new javax.swing.JTextField();
        exitBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(816, 700));

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(816, 1056));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 153, 0));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("Item Information");
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, 40));

        nameField.setEditable(false);
        nameField.setBackground(new java.awt.Color(255, 255, 204));
        nameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 240, 30));

        idNumberField.setEditable(false);
        idNumberField.setBackground(new java.awt.Color(255, 255, 204));
        idNumberField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idNumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(idNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 240, 30));

        cellNumberField.setEditable(false);
        cellNumberField.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.add(cellNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 240, 30));

        courseField.setEditable(false);
        courseField.setBackground(new java.awt.Color(255, 255, 204));
        courseField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        courseField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(courseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 190, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Student Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText(" ID Number");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cell No.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Section");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 70, 30));

        itemNameField.setEditable(false);
        itemNameField.setBackground(new java.awt.Color(255, 255, 204));
        itemNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemNameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(itemNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 240, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Item Name");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 80, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Purpose");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 81, 30));

        purposeField.setEditable(false);
        purposeField.setBackground(new java.awt.Color(255, 255, 204));
        purposeField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        purposeField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(purposeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Approved by");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 94, 30));

        approvedByField.setEditable(false);
        approvedByField.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.add(approvedByField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 240, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Date borrowed  ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Due Date ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Year level");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 70, 30));

        sectionField.setEditable(false);
        sectionField.setBackground(new java.awt.Color(255, 255, 204));
        sectionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sectionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(sectionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 190, 30));

        yearLevelField.setEditable(false);
        yearLevelField.setBackground(new java.awt.Color(255, 255, 204));
        yearLevelField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yearLevelField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(yearLevelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 190, 30));

        dateBorrowedField.setEditable(false);
        dateBorrowedField.setBackground(new java.awt.Color(255, 255, 204));
        dateBorrowedField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateBorrowedField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(dateBorrowedField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 160, 30));

        dueDateField.setEditable(false);
        dueDateField.setBackground(new java.awt.Color(255, 255, 204));
        dueDateField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dueDateField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(dueDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 160, 30));

        goodConditionField.setBackground(new java.awt.Color(255, 255, 204));
        goodConditionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        goodConditionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(goodConditionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 240, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Condition (Good)");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Condition (Bad)");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 110, 30));

        badConditionField.setBackground(new java.awt.Color(255, 255, 204));
        badConditionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        badConditionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(badConditionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 240, 30));

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 90, 40));

        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 90, 40));

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        Helper.displayReturnTableItems();
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        
        // checking
        String goodConditionStr = goodConditionField.getText();
        String badConditionStr = badConditionField.getText();
        
        try {
            int goodItem = Integer.parseInt(goodConditionStr);
            int badItem = Integer.parseInt(badConditionStr);
            
//            if(badItem <= 0) {
//                JOptionPane.showMessageDialog(rootPane, "The minimum value of Good/Bad Condition value is 1.");
//                return;
//            }
//            if(goodItem <= 0) {
//                JOptionPane.showMessageDialog(rootPane, "The minimum value of Good/Bad Condition value is 1.");
//                return;
//            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Good/Bad Condition value should be an integer.");
            return;
        }
        
        
        
        Connection connection = null;
        PreparedStatement selectInventoryStatement = null;
        PreparedStatement updateBorrowStatement = null;
        PreparedStatement updateInventoryStatement = null;
        ResultSet selectInventoryRs = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
        
            // INVENTORY
            String selectInventoryQuery = "SELECT * FROM inventory WHERE name=?";
            selectInventoryStatement = connection.prepareStatement(selectInventoryQuery);
            selectInventoryStatement.setString(1, this.itemName);
            selectInventoryRs = selectInventoryStatement.executeQuery();
            
            if(selectInventoryRs.next()) {
                // get the good/bad item quantity from inventory
                int leftGoodItem = selectInventoryRs.getInt("good_item");
                int leftBadItem = selectInventoryRs.getInt("bad_item");
                
                // get new value
                int newGoodItem = Integer.parseInt(goodConditionField.getText());
                int newBadItem = Integer.parseInt(badConditionField.getText());
                
                // calculate new value
                if(newGoodItem > this.goodItemBorrow ) {
                    int tempGoodItem = newGoodItem - this.goodItemBorrow;
                    
                    // check if possible to borrow another item
                    if(tempGoodItem > leftGoodItem) {
                        // Sorry the good item left of this item is {leftGoodItem}. You exceed to the item we have.
                        JOptionPane.showMessageDialog(rootPane, "Sorry the good item left on this item is " + leftGoodItem + ". You exceed to the item we have.");
                        return;
                    } else {
                        // subtract inventory
                        // update
                        // borrow table
                        String updateBorrow = "UPDATE boroweditem SET good_item=? WHERE borrowed_id=?";
                        updateBorrowStatement = connection.prepareStatement(updateBorrow);
                        updateBorrowStatement.setInt(1, newGoodItem);
                        updateBorrowStatement.setInt(2, this.borrowId);
                        if(updateBorrowStatement.executeUpdate() < 1) {
                            return;
                        }
                        // inventory
                        String updateInventory = "UPDATE inventory SET good_item=? WHERE name=?";
                        updateInventoryStatement = connection.prepareStatement(updateInventory);
                        updateInventoryStatement.setInt(1, leftGoodItem - tempGoodItem);
                        updateInventoryStatement.setString(2, this.itemName);
                        if(updateInventoryStatement.executeUpdate() < 1) {
                            return;
                        }
                        
                    }
                } else {
                    // add inventory
                    // update
                    
                    int tempGoodItem = this.goodItemBorrow - newGoodItem;
                    
                    // borrow table
                    String updateBorrow = "UPDATE boroweditem SET good_item=? WHERE borrowed_id=?";
                    updateBorrowStatement = connection.prepareStatement(updateBorrow);
                    updateBorrowStatement.setInt(1, newGoodItem);
                    updateBorrowStatement.setInt(2, this.borrowId);
                    if(updateBorrowStatement.executeUpdate() < 1) {
                        return;
                    }
                    // inventory
                    String updateInventory = "UPDATE inventory SET good_item=? WHERE name=?";
                    updateInventoryStatement = connection.prepareStatement(updateInventory);
                    updateInventoryStatement.setInt(1, leftGoodItem + tempGoodItem);
                    updateInventoryStatement.setString(2, this.itemName);
                    if(updateInventoryStatement.executeUpdate() < 1) {
                        return;
                    }
                    
                    
                }
                if(newBadItem > this.badItemBorrow ) {
                    int tempBadItem = newBadItem - this.badItemBorrow;
                    
                    // check if possible to borrow another item
                    if(tempBadItem > leftBadItem) {
                        // Sorry the good item left of this item is {leftGoodItem}. You exceed to the item we have.
                        JOptionPane.showMessageDialog(rootPane, "Sorry the bad item left on this item is " + leftBadItem + ". You exceed to the item we have.");
                        return;
                    } else {
                        // subtract inventory
                        // update
                        // borrow table
                        String updateBorrow = "UPDATE boroweditem SET bad_item=? WHERE borrowed_id=?";
                        updateBorrowStatement = connection.prepareStatement(updateBorrow);
                        updateBorrowStatement.setInt(1, newBadItem);
                        updateBorrowStatement.setInt(2, this.borrowId);
                        updateBorrowStatement.executeUpdate();
                        if(updateBorrowStatement.executeUpdate() < 1) {
                            return;
                        }
                        // inventory
                        String updateInventory = "UPDATE inventory SET bad_item=? WHERE name=?";
                        updateInventoryStatement = connection.prepareStatement(updateInventory);
                        updateInventoryStatement.setInt(1, leftBadItem - tempBadItem);
                        updateInventoryStatement.setString(2, this.itemName);
                        if(updateInventoryStatement.executeUpdate() < 1) {
                            return;
                        }
                        
                        
                    }
                } else {
                    // add inventory
                    // update
                    
                    int tempBadItem = this.badItemBorrow - newBadItem;
                    
                    // borrow table
                    String updateBorrow = "UPDATE boroweditem SET bad_item=? WHERE borrowed_id=?";
                    updateBorrowStatement = connection.prepareStatement(updateBorrow);
                    updateBorrowStatement.setInt(1, newBadItem);
                    updateBorrowStatement.setInt(2, this.borrowId);
                    updateBorrowStatement.executeUpdate();
                    if(updateBorrowStatement.executeUpdate() < 1) {
                        return;
                    }
                    // inventory
                    String updateInventory = "UPDATE inventory SET bad_item=? WHERE name=?";
                    updateInventoryStatement = connection.prepareStatement(updateInventory);
                    updateInventoryStatement.setInt(1, leftBadItem + tempBadItem);
                    updateInventoryStatement.setString(2, this.itemName);
                    updateInventoryStatement.executeUpdate();
                    if(updateInventoryStatement.executeUpdate() < 1) {
                        return;
                    }
                    
                    
                }
                
                JOptionPane.showMessageDialog(rootPane, "Update Successfully.");
                Helper.displayInventoryItems();
                Helper.displayReturnTableItems();
                this.dispose();
            }
            
        
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            
        } finally {
            try {

                if (selectInventoryRs != null) {
                    selectInventoryRs.close();
                }
                if (selectInventoryStatement != null) {
                    selectInventoryStatement.close();
                }
                if (updateBorrowStatement != null) {
                    updateBorrowStatement.close();
                }
                if (updateInventoryStatement != null) {
                    updateInventoryStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField approvedByField;
    private javax.swing.JTextField badConditionField;
    private javax.swing.JTextField cellNumberField;
    private javax.swing.JTextField courseField;
    private javax.swing.JTextField dateBorrowedField;
    private javax.swing.JTextField dueDateField;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTextField goodConditionField;
    private javax.swing.JTextField idNumberField;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField purposeField;
    private javax.swing.JTextField sectionField;
    private javax.swing.JButton updateBtn;
    private javax.swing.JTextField yearLevelField;
    // End of variables declaration//GEN-END:variables
}
