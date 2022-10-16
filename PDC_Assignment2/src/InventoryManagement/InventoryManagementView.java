package InventoryManagement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class InventoryManagementView extends javax.swing.JFrame {

    private InventoryManagementController controller = null;
    private DefaultListModel categoryListModel = new DefaultListModel();

    public InventoryManagementView() {
        //constructor
    }

    public void startGUI() {
        //initialisation of form & components
        initComponents();
        fillCategories();
        setLocationRelativeTo(null);

        //Set visibilities
        homeVisibility();

        //background colour
        this.getContentPane().setBackground(new java.awt.Color(175, 199, 249));

        //show GUI
        this.setVisible(true);
    }

    public void setController(InventoryManagementController controller) {
        this.controller = controller;
    }

    public void homeVisibility() {
        controller.changeState(InventoryManagementController.Location.HOME);

        pnlHome.setVisible(true);
        pnlCategory.setVisible(false);
        btnReturn.setVisible(false);
        lstCategories.clearSelection();
    }

    public void categoryVisibility() {
        controller.categories.changeStateToCategory(controller, lstCategories.getSelectedValue());

        pnlHome.setVisible(false);
        pnlCategory.defaultVisibility();
        pnlCategory.setVisible(true);
        btnReturn.setVisible(true);
    }

    private void fillCategories() {
        for (String category : controller.categories.categories) {
            categoryListModel.addElement(category);
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

        pnlTitle = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        lblTitle3 = new javax.swing.JLabel();
        pnlHome = new javax.swing.JPanel();
        lblCategories = new javax.swing.JLabel();
        scrCategories = new javax.swing.JScrollPane();
        lstCategories = new JList(categoryListModel);
        pnlCategory = new InventoryManagement.pnlCategory();
        btnReturn = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management");
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(410, 430));
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

        pnlHome.setBackground(new java.awt.Color(175, 199, 249));
        pnlHome.setLayout(null);

        lblCategories.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblCategories.setText("Categories: ");
        pnlHome.add(lblCategories);
        lblCategories.setBounds(20, 20, 130, 30);

        scrCategories.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lstCategories.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
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
        homeVisibility();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void lstCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCategoriesMouseClicked
        pnlCategory.setCategoryLabel(lstCategories.getSelectedValue());
        categoryVisibility();
    }//GEN-LAST:event_lstCategoriesMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        controller.changeState(InventoryManagementController.Location.NONE);
        this.dispose();
    }//GEN-LAST:event_btnQuitActionPerformed


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
