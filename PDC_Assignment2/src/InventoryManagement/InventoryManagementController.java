package InventoryManagement;

public class InventoryManagementController {
    
    public final InventoryManagementModel model;
    public final InventoryManagementView view;
    
    public InventoryManagementController() {
        this.model = new InventoryManagementModel();
        this.view = new InventoryManagementView();
        
        view.setVisible(true);
    }
    
    public InventoryManagementController(InventoryManagementModel model, InventoryManagementView view) {
        this.model = model;
        this.view = view;
        
        view.setVisible(true);
    }
}
