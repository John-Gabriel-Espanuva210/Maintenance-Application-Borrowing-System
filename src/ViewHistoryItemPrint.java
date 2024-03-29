
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
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
public class ViewHistoryItemPrint extends javax.swing.JFrame {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/mabs";
    private static final String DB_USERNAME = "mabs";
    private static final String DB_PASSWORD = "admin";
    
    /**
     * Creates new form ViewReturnItem
     */
    public ViewHistoryItemPrint() {
        initComponents();
        
        Connection connection = null;
        PreparedStatement searchStatement = null;
        ResultSet searchRs = null;
        
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_CONNECTION_URL, DB_USERNAME, DB_PASSWORD);
        
            String searchQuery = "SELECT * FROM history WHERE borrowed_id = ?";
            searchStatement = connection.prepareStatement(searchQuery);
            searchStatement.setInt(1, Tables.getInstance().getRowId());
            searchRs = searchStatement.executeQuery();
            
            JTable table = Tables.getInstance().getHistoryTable();
        
            DefaultTableModel defaultTable = (DefaultTableModel) table.getModel();
            defaultTable.setRowCount(0); 

            if (searchRs.next()) {
                
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
        container = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
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
        printBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(816, 700));

        container.setBackground(new java.awt.Color(102, 102, 255));
        container.setPreferredSize(new java.awt.Dimension(816, 1056));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 153, 0));
        title.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        title.setText("Item Information");
        title.setOpaque(true);
        container.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, 40));

        nameField.setEditable(false);
        nameField.setBackground(new java.awt.Color(255, 255, 204));
        nameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 240, 30));

        idNumberField.setEditable(false);
        idNumberField.setBackground(new java.awt.Color(255, 255, 204));
        idNumberField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idNumberField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(idNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 240, 30));

        cellNumberField.setEditable(false);
        cellNumberField.setBackground(new java.awt.Color(255, 255, 204));
        container.add(cellNumberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 240, 30));

        courseField.setEditable(false);
        courseField.setBackground(new java.awt.Color(255, 255, 204));
        courseField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        courseField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(courseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 190, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Student Name");
        container.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText(" ID Number");
        container.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Cell No.");
        container.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Section");
        container.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 70, 30));

        itemNameField.setEditable(false);
        itemNameField.setBackground(new java.awt.Color(255, 255, 204));
        itemNameField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemNameField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(itemNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 240, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Item Name");
        container.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 80, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Purpose");
        container.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 81, 30));

        purposeField.setEditable(false);
        purposeField.setBackground(new java.awt.Color(255, 255, 204));
        purposeField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        purposeField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(purposeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 160, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Approved by");
        container.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 94, 30));

        approvedByField.setEditable(false);
        approvedByField.setBackground(new java.awt.Color(255, 255, 204));
        container.add(approvedByField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 420, 240, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Date borrowed  ");
        container.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Due Date ");
        container.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Year level");
        container.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Course");
        container.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 70, 30));

        sectionField.setEditable(false);
        sectionField.setBackground(new java.awt.Color(255, 255, 204));
        sectionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sectionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(sectionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 190, 30));

        yearLevelField.setEditable(false);
        yearLevelField.setBackground(new java.awt.Color(255, 255, 204));
        yearLevelField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yearLevelField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(yearLevelField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 190, 30));

        dateBorrowedField.setEditable(false);
        dateBorrowedField.setBackground(new java.awt.Color(255, 255, 204));
        dateBorrowedField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dateBorrowedField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(dateBorrowedField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 160, 30));

        dueDateField.setEditable(false);
        dueDateField.setBackground(new java.awt.Color(255, 255, 204));
        dueDateField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dueDateField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(dueDateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 160, 30));

        goodConditionField.setEditable(false);
        goodConditionField.setBackground(new java.awt.Color(255, 255, 204));
        goodConditionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        goodConditionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(goodConditionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 240, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Condition (Good)");
        container.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Condition (Bad)");
        container.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 110, 30));

        badConditionField.setEditable(false);
        badConditionField.setBackground(new java.awt.Color(255, 255, 204));
        badConditionField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        badConditionField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        container.add(badConditionField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 240, 30));

        exitBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        container.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 540, 90, 40));

        printBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        printBtn.setText("Print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });
        container.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 110, 40));

        jScrollPane1.setViewportView(container);

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
        Helper.displayHistoryTableItems();
        this.dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        
        // set design
        container.setBackground(Color.WHITE);
        title.setBackground(Color.WHITE);
        title.setForeground(Color.BLACK);
        printBtn.setVisible(false);
        exitBtn.setVisible(false);
        
        
        try {
            BufferedImage bi = new BufferedImage(container.getWidth(), container.getHeight(), BufferedImage.TYPE_INT_RGB);
            container.paint(bi.getGraphics());
            
//            String path = "D:\\Downloads\\request-form.jpg";
            String path = "C:\\mabsDownload\\request-form.jpg";
            
            File outputFile = new File(path);
            ImageIO.write(bi, "jpg", outputFile);
            
            // Check if the file exists before attempting to print
            if (outputFile.exists()) {
                Desktop.getDesktop().print(outputFile);
            } else {
                JOptionPane.showMessageDialog(null, "The file doesn't exist: " + path);
            }
            
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace for debugging
            JOptionPane.showMessageDialog(rootPane, "Unable to print. Please try again later.");
        }
        
        // design back to default
        container.setBackground(new Color(102,102,255));
        title.setBackground(new Color(102,102,255));
        title.setForeground(new Color(0,0,0));
        printBtn.setVisible(true);
        exitBtn.setVisible(true);
        
    }//GEN-LAST:event_printBtnActionPerformed

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
    private javax.swing.JPanel container;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton printBtn;
    private javax.swing.JTextField purposeField;
    private javax.swing.JTextField sectionField;
    private javax.swing.JLabel title;
    private javax.swing.JTextField yearLevelField;
    // End of variables declaration//GEN-END:variables
}
