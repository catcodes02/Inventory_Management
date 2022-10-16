package InventoryManagement;

public class InventoryManagementController {

    public final InventoryManagementModel model;
    public final InventoryManagementView view;

    public InventoryManagementController() {
        this.model = InventoryManagementModel.getInstance();
        this.view = new InventoryManagementView();

        //create example tables
        this.model.createExampleTables();

        //show GUI
        this.view.setVisible(true);
    }

    public InventoryManagementController(InventoryManagementModel model, InventoryManagementView view) {
        this.model = model;
        this.view = view;

        //create example tables
        this.model.createExampleTables();

        //show GUI
        this.view.setVisible(true);
    }

    //enum describes current page state
    public enum currentState {
        NONE, HOME,
        //add categories here
        CATEGORY_FOOD, CATEGORY_COSMETICS, CATEGORY_CLEANING_SUPPLIES
    };
}
