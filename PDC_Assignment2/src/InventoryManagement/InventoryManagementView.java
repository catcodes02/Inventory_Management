package InventoryManagement;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class InventoryManagementView extends javax.swing.JFrame {

    private InventoryManagementController controller = null;
    private DefaultListModel categoryListModel = new DefaultListModel(), inventoryListModel = new DefaultListModel();

    public InventoryManagementView() {
        //close operation
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.endProgram();
            }
        });
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
        controller.changeLocation(InventoryManagementController.Location.HOME);

        pnlHome.setVisible(true);
        pnlCategory.setVisible(false);
        btnReturn.setVisible(false);
        lstCategories.clearSelection();
    }

    public void categoryVisibility() {
        controller.categories.changeLocationToCategory(controller, lstCategories.getSelectedValue());
        fillInventory();

        pnlHome.setVisible(false);
        categoryComponentVisibility();
        pnlCategory.setVisible(true);
        btnReturn.setVisible(true);
    }

    public void categoryComponentVisibility() {
        pnlButtons.setVisible(true);
        pnlEditQuantity.setVisible(false);
    }

    public void setCategoryLabel(String name) {
        lblInventory.setText(name + " Stock:");
    }

    private void fillCategories() {
        for (String category : controller.categories.listOfCategories) {
            categoryListModel.addElement(category);
        }
    }

    public void fillInventory() {
        inventoryListModel.clear();
        for (String item : controller.getInventory()) {
            inventoryListModel.addElement(item);
        }
    }

    private boolean checkItemSelected() {
        boolean itemSelected = false;

        if (lstInventory.getSelectedValue() != null) {
            itemSelected = true;
        } else { //item not selected
            JOptionPane.showMessageDialog(null, "Please select an item", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return itemSelected;
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
        btnReturn = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        pnlCategory = new javax.swing.JPanel();
        lblInventory = new javax.swing.JLabel();
        scrCategories1 = new javax.swing.JScrollPane();
        lstInventory = new javax.swing.JList<>();
        pnlButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEditQuantity = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        pnlEditQuantity = new javax.swing.JPanel();
        spnQuantity = new javax.swing.JSpinner();
        btnConfirm = new javax.swing.JButton();
        btnCancelQuantity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
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

        pnlCategory.setBackground(new java.awt.Color(175, 199, 249));
        pnlCategory.setMinimumSize(new java.awt.Dimension(400, 280));
        pnlCategory.setLayout(null);

        lblInventory.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lblInventory.setText("(Category) Stock:");
        pnlCategory.add(lblInventory);
        lblInventory.setBounds(10, 20, 380, 30);

        scrCategories1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lstInventory.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lstInventory.setModel(this.inventoryListModel);
        lstInventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstInventoryMouseClicked(evt);
            }
        });
        scrCategories1.setViewportView(lstInventory);

        pnlCategory.add(scrCategories1);
        scrCategories1.setBounds(10, 60, 180, 180);

        pnlButtons.setBackground(new java.awt.Color(175, 199, 249));

        btnAdd.setBackground(new java.awt.Color(221, 221, 221));
        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAdd.setText("ADD ITEM");
        btnAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdd.setMaximumSize(new java.awt.Dimension(63, 23));
        btnAdd.setMinimumSize(new java.awt.Dimension(63, 23));
        btnAdd.setPreferredSize(new java.awt.Dimension(63, 23));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEditQuantity.setBackground(new java.awt.Color(221, 221, 221));
        btnEditQuantity.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnEditQuantity.setText("EDIT QUANTITY");
        btnEditQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditQuantity.setMaximumSize(new java.awt.Dimension(63, 23));
        btnEditQuantity.setMinimumSize(new java.awt.Dimension(63, 23));
        btnEditQuantity.setPreferredSize(new java.awt.Dimension(63, 23));
        btnEditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuantityActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(221, 221, 221));
        btnRemove.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnRemove.setText("REMOVE ITEM");
        btnRemove.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRemove.setMaximumSize(new java.awt.Dimension(63, 23));
        btnRemove.setMinimumSize(new java.awt.Dimension(63, 23));
        btnRemove.setPreferredSize(new java.awt.Dimension(63, 23));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(0, 35, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEditQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        pnlCategory.add(pnlButtons);
        pnlButtons.setBounds(190, 60, 210, 180);

        pnlEditQuantity.setBackground(new java.awt.Color(175, 199, 249));

        spnQuantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnConfirm.setBackground(new java.awt.Color(221, 221, 221));
        btnConfirm.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnConfirm.setText("CONFIRM");
        btnConfirm.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirm.setMaximumSize(new java.awt.Dimension(63, 23));
        btnConfirm.setMinimumSize(new java.awt.Dimension(63, 23));
        btnConfirm.setPreferredSize(new java.awt.Dimension(63, 23));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancelQuantity.setBackground(new java.awt.Color(221, 221, 221));
        btnCancelQuantity.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCancelQuantity.setText("CANCEL");
        btnCancelQuantity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelQuantity.setMaximumSize(new java.awt.Dimension(63, 23));
        btnCancelQuantity.setMinimumSize(new java.awt.Dimension(63, 23));
        btnCancelQuantity.setPreferredSize(new java.awt.Dimension(63, 23));
        btnCancelQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelQuantityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditQuantityLayout = new javax.swing.GroupLayout(pnlEditQuantity);
        pnlEditQuantity.setLayout(pnlEditQuantityLayout);
        pnlEditQuantityLayout.setHorizontalGroup(
            pnlEditQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(pnlEditQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEditQuantityLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnlEditQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlEditQuantityLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnlEditQuantityLayout.setVerticalGroup(
            pnlEditQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(pnlEditQuantityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlEditQuantityLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(10, 10, 10)
                    .addComponent(btnCancelQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnlCategory.add(pnlEditQuantity);
        pnlEditQuantity.setBounds(190, 60, 210, 180);

        getContentPane().add(pnlCategory);
        pnlCategory.setBounds(0, 80, 400, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        homeVisibility();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void lstCategoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstCategoriesMouseClicked
        setCategoryLabel(lstCategories.getSelectedValue());
        categoryVisibility();
    }//GEN-LAST:event_lstCategoriesMouseClicked

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        controller.endProgram();
    }//GEN-LAST:event_btnQuitActionPerformed

    private void lstInventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstInventoryMouseClicked
        System.out.println(lstInventory.getSelectedValue());
    }//GEN-LAST:event_lstInventoryMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        System.out.println("Add Button Pressed!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuantityActionPerformed
        System.out.println("Edit Quantity Button Pressed!");

        if (checkItemSelected()) { //error checking
            pnlButtons.setVisible(false);
            pnlEditQuantity.setVisible(true);
        }
    }//GEN-LAST:event_btnEditQuantityActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (checkItemSelected()) { //error checking
            int confirm = JOptionPane.showConfirmDialog(null, "Remove " + lstInventory.getSelectedValue(), "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                controller.remove(lstInventory.getSelectedValue());
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        if (controller.getQuantity(lstInventory.getSelectedValue()) + (int) spnQuantity.getValue() < 0) {
            int confirm = JOptionPane.showConfirmDialog(null, "New quantity will be negative. \nIs this okay?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                controller.updateQuantity(lstInventory.getSelectedValue(), (int) spnQuantity.getValue());
                JOptionPane.showMessageDialog(null, lstInventory.getSelectedValue() + " now has quantity: " + controller.getQuantity(lstInventory.getSelectedValue()), "QUANTITY CHANGED", JOptionPane.PLAIN_MESSAGE);
            }
        }
        categoryComponentVisibility();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelQuantityActionPerformed
        categoryComponentVisibility();
    }//GEN-LAST:event_btnCancelQuantityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelQuantity;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEditQuantity;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel lblCategories;
    private javax.swing.JLabel lblInventory;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle3;
    private javax.swing.JList<String> lstCategories;
    private javax.swing.JList<String> lstInventory;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCategory;
    private javax.swing.JPanel pnlEditQuantity;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlTitle;
    private javax.swing.JScrollPane scrCategories;
    private javax.swing.JScrollPane scrCategories1;
    private javax.swing.JSpinner spnQuantity;
    // End of variables declaration//GEN-END:variables
}
