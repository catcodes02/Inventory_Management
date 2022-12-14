package InventoryManagement;

import javax.swing.JOptionPane;

public class pnlAddItem extends javax.swing.JPanel {

    InventoryManagementView GUI;

    public pnlAddItem() {
        //initialisation of form & components
        initComponents();
    }

    //set connection to parent JFrame
    public void setGUI(InventoryManagementView GUI) {
        this.GUI = GUI;
    }

    //set visibility of input fields based on category
    public void setInputVisibility(String category) {
        switch (category) {
            case "food": //Food item
                lblOther.setText("Shelf Life: ");
                spnShelfLife.setVisible(true);
                break;
            case "cleaning": //Cleaning item
                lblOther.setText("Usage: ");
                txtUsage.setVisible(true);
                break;
            case "cosmetic": //Cosmetic item
                lblOther.setText("Application: ");
                txtApplication.setVisible(true);
                break;
        }
    }

    //get name input
    public String getName() {
        return txtName.getText().trim();
    }

    //get quantity input
    public int getQuantity() {
        return (int) spnQuantity.getValue();
    }

    //get price input
    public Double getPrice() {
        return Double.parseDouble(txtPrice.getText());
    }

    //get extra input
    //get shelf life input
    public String getShelfLife() {
        return spnShelfLife.getValue().toString();
    }

    //get usage input
    public String getUsage() {
        return txtUsage.getText().trim();
    }

    //get application input
    public String getApplication() {
        return txtApplication.getText().trim();
    }

    //remove previously entered input
    public void clearInput() {
        txtName.setText("");
        spnQuantity.setValue(0);
        txtPrice.setText("");

        spnShelfLife.setValue(0);
        txtUsage.setText("");
        txtApplication.setText("");

        spnShelfLife.setVisible(false);
        txtUsage.setVisible(false);
        txtApplication.setVisible(false);
    }

    //check all input is valid
    private boolean validateInput() {
        boolean valid = false;

        //validate name
        if (GUI.checkItemExists(getName())) { //name already assigned to item
            JOptionPane.showMessageDialog(null, "Item already exists by that name.", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (getName().equals("")) { //blank name
            JOptionPane.showMessageDialog(null, "Missing item name!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (validationBaseOnCategory()) {

            //validate quantity
            int Quantity = getQuantity();
            int confirm = -1;
            if (Quantity < 0) { //negative quantity
                confirm = JOptionPane.showConfirmDialog(null, "Quantity will be negative. \nIs this okay?", "CONFIRMATION", JOptionPane.YES_NO_OPTION);
            }

            //validate price
            if ((Quantity > -1) || (confirm == 0)) { //valid input or yes
                double price = -1;
                try {
                    price = Double.parseDouble(txtPrice.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Price must be a number!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (price <= 0) { //negative price
                    JOptionPane.showMessageDialog(null, "Price cannot be negative or zero.", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else { //input is valid
                    valid = true;
                }
            }
        }
        return valid;
    }

    //validation of extra input field
    private boolean validationBaseOnCategory() {
        boolean valid = true;

        switch (lblOther.getText()) {
            case "Shelf Life: ": //Food item
                //no extra validation needed
                break;
            case "Usage: ": //Cleaning item
                //validate usage
                if (txtUsage.getText().trim().equals("")) { //blank usage
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Missing item usage!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "Application: ": //Cosmetic item
                //validate application
                if (txtApplication.getText().trim().equals("")) { //blank application
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Missing item application!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
        }

        return valid;
    }

    //send input to be added to model
    private void sendInput() {
        String otherInput = "";

        switch (lblOther.getText()) {
            case "Shelf Life: ": //Food item
                otherInput = getShelfLife();
                break;
            case "Usage: ": //Cleaning item
                otherInput = getUsage();
                break;
            case "Application: ": //Cosmetic item
                otherInput = getApplication();
                break;
        }

        GUI.recieveNewItem(getName(), getQuantity(), getPrice(), otherInput);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        spnQuantity = new javax.swing.JSpinner();
        btnConfirmAdd = new javax.swing.JButton();
        btnCancelAdd = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblOther = new javax.swing.JLabel();
        spnShelfLife = new javax.swing.JSpinner();
        txtUsage = new javax.swing.JTextField();
        txtApplication = new javax.swing.JTextField();

        setBackground(new java.awt.Color(175, 199, 249));
        setMinimumSize(new java.awt.Dimension(210, 180));
        setPreferredSize(new java.awt.Dimension(210, 180));
        setLayout(null);

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtName.setToolTipText("e.g. Apples");
        add(txtName);
        txtName.setBounds(100, 10, 100, 23);

        txtPrice.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPrice.setToolTipText("($NZD)");
        txtPrice.setMinimumSize(new java.awt.Dimension(30, 24));
        txtPrice.setPreferredSize(new java.awt.Dimension(30, 24));
        add(txtPrice);
        txtPrice.setBounds(100, 70, 100, 24);

        spnQuantity.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spnQuantity.setToolTipText("Current number in stock");
        add(spnQuantity);
        spnQuantity.setBounds(100, 40, 100, 24);

        btnConfirmAdd.setBackground(new java.awt.Color(221, 221, 221));
        btnConfirmAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnConfirmAdd.setText("CONFIRM");
        btnConfirmAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfirmAdd.setMaximumSize(new java.awt.Dimension(63, 23));
        btnConfirmAdd.setMinimumSize(new java.awt.Dimension(63, 23));
        btnConfirmAdd.setPreferredSize(new java.awt.Dimension(63, 23));
        btnConfirmAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmAddActionPerformed(evt);
            }
        });
        add(btnConfirmAdd);
        btnConfirmAdd.setBounds(10, 150, 90, 23);

        btnCancelAdd.setBackground(new java.awt.Color(221, 221, 221));
        btnCancelAdd.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnCancelAdd.setText("CANCEL");
        btnCancelAdd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelAdd.setMaximumSize(new java.awt.Dimension(63, 23));
        btnCancelAdd.setMinimumSize(new java.awt.Dimension(63, 23));
        btnCancelAdd.setPreferredSize(new java.awt.Dimension(63, 23));
        btnCancelAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelAddActionPerformed(evt);
            }
        });
        add(btnCancelAdd);
        btnCancelAdd.setBounds(110, 150, 90, 23);

        lblName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblName.setText("Name: ");
        lblName.setMinimumSize(new java.awt.Dimension(30, 24));
        lblName.setPreferredSize(new java.awt.Dimension(30, 24));
        add(lblName);
        lblName.setBounds(10, 10, 80, 20);

        lblQuantity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblQuantity.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblQuantity.setText("Quantity: ");
        lblQuantity.setMinimumSize(new java.awt.Dimension(30, 24));
        lblQuantity.setPreferredSize(new java.awt.Dimension(30, 24));
        add(lblQuantity);
        lblQuantity.setBounds(10, 40, 80, 20);

        lblPrice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPrice.setText("Price: ");
        lblPrice.setMinimumSize(new java.awt.Dimension(30, 24));
        lblPrice.setPreferredSize(new java.awt.Dimension(30, 24));
        add(lblPrice);
        lblPrice.setBounds(10, 70, 80, 20);

        lblOther.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblOther.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOther.setText("Other: ");
        lblOther.setMinimumSize(new java.awt.Dimension(30, 24));
        lblOther.setPreferredSize(new java.awt.Dimension(30, 24));
        add(lblOther);
        lblOther.setBounds(10, 100, 80, 20);

        spnShelfLife.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spnShelfLife.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnShelfLife.setToolTipText("(days)");
        add(spnShelfLife);
        spnShelfLife.setBounds(100, 100, 100, 24);

        txtUsage.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUsage.setToolTipText("e.g. Windows");
        txtUsage.setMinimumSize(new java.awt.Dimension(30, 24));
        txtUsage.setPreferredSize(new java.awt.Dimension(30, 24));
        add(txtUsage);
        txtUsage.setBounds(100, 100, 100, 24);

        txtApplication.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtApplication.setToolTipText("e.g. Lips");
        txtApplication.setMinimumSize(new java.awt.Dimension(30, 24));
        txtApplication.setPreferredSize(new java.awt.Dimension(30, 24));
        add(txtApplication);
        txtApplication.setBounds(100, 100, 100, 24);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmAddActionPerformed
        if (validateInput()) {
            sendInput();
            clearInput();
            GUI.categoryVisibility();
        }
    }//GEN-LAST:event_btnConfirmAddActionPerformed

    private void btnCancelAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelAddActionPerformed
        clearInput();
        GUI.categoryVisibility();
    }//GEN-LAST:event_btnCancelAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelAdd;
    private javax.swing.JButton btnConfirmAdd;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblOther;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JSpinner spnShelfLife;
    private javax.swing.JTextField txtApplication;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtUsage;
    // End of variables declaration//GEN-END:variables
}
