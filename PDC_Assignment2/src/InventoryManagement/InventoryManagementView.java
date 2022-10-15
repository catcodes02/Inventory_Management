package InventoryManagement;

public class InventoryManagementView extends javax.swing.JFrame {

    /**
     * Creates new form InventoryManagementGUI
     */
    public InventoryManagementView() {
        //initialisation of form & components
        initComponents();
        setLocationRelativeTo(null);

        //Setting visibility
        setHomeVisibility();
    }
    
    public void setHomeVisibility(){
        pnlHome.setVisible(true);
        pnlCategory.setVisible(false);
        btnReturn.setVisible(false);
    }
    
    public void SetCategoryVisibility(){
        pnlHome.setVisible(false);
        pnlCategory.setVisible(true);
        btnReturn.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTitle = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        pnlHome = new javax.swing.JPanel();
        lblCategories = new javax.swing.JLabel();
        scrCategories = new javax.swing.JScrollPane();
        lstCategories = new javax.swing.JList<>();
        pnlCategory = new InventoryManagement.pnlCategory();
        btnReturn = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management");
        setBackground(new java.awt.Color(229, 229, 254));
        setMinimumSize(new java.awt.Dimension(410, 430));
        setPreferredSize(new java.awt.Dimension(410, 430));
        setResizable(false);
        setSize(new java.awt.Dimension(410, 430));
        getContentPane().setLayout(null);

        pnlTitle.setBackground(new java.awt.Color(51, 51, 51));
        pnlTitle.setLayout(null);

        lblTitle1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Miscellaneous Corporation's");
        pnlTitle.add(lblTitle1);
        lblTitle1.setBounds(4, 7, 400, 22);

        lblTitle2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Inventory Manager");
        lblTitle2.setPreferredSize(new java.awt.Dimension(223, 22));
        pnlTitle.add(lblTitle2);
        lblTitle2.setBounds(0, 30, 400, 22);

        lblTitle3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTitle3.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle3.setText(" ----------------------------------------");
        lblTitle3.setPreferredSize(new java.awt.Dimension(223, 22));
        pnlTitle.add(lblTitle3);
        lblTitle3.setBounds(0, 50, 400, 20);

        getContentPane().add(pnlTitle);
        pnlTitle.setBounds(0, 0, 570, 80);

        pnlHome.setLayout(null);

        lblCategories.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblCategories.setText("Categories: ");
        pnlHome.add(lblCategories);
        lblCategories.setBounds(20, 20, 130, 30);

        scrCategories.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lstCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        lstCategories.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Food", "Cleaning Supplies", "Cosmetics" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstCategoriesMouseClicked(evt);
            }
        });
        scrCategories.setViewportView(lstCategories);

        pnlHome.add(scrCategories);
        scrCategories.setBounds(20, 60, 360, 190);

        getContentPane().add(pnlHome);
        pnlHome.setBounds(0, 70, 400, 280);
        getContentPane().add(pnlCategory);
        pnlCategory.setBounds(0, 70, 400, 280);

        btnReturn.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnReturn.setText("RETURN");
        btnReturn.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn);
        btnReturn.setBounds(180, 360, 100, 30);

        btnQuit.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnQuit.setText("QUIT");
        btnQuit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuit);
        btnQuit.setBounds(290, 360, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        setHomeVisibility();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void lstCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCategoriesMouseClicked
        System.out.println(lstCategories.getSelectedValue());

        SetCategoryVisibility();
    }//GEN-LAST:event_lstCategoriesMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InventoryManagementView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InventoryManagementView().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel lblCategories;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JList<String> lstCategories;
    private InventoryManagement.pnlCategory pnlCategory;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrCategories;
    // End of variables declaration//GEN-END:variables
}