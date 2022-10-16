package InventoryManagement;

public class InventoryManagementController {

    public final InventoryManagementModel model;
    public final InventoryManagementView view;
    public final Categories categories;

    public Location currentLocation = Location.NONE;

    public InventoryManagementController() {
        this.model = InventoryManagementModel.getInstance();
        this.view = new InventoryManagementView();
        this.categories = new Categories();
    }

    public InventoryManagementController(InventoryManagementModel model, InventoryManagementView view) {
        this.model = model;
        this.view = view;
        this.categories = new Categories();
    }

    public void startProgram() {
        //create example tables
        this.model.createExampleTables();

        //start GUI
        view.setController(this);
        this.view.startGUI();
    }

    public void endProgram() {
        this.changeLocation(Location.NONE);
        model.closeConnections();
        view.dispose();
    }

    public void changeLocation(Location location) {
        this.currentLocation = location;
    }

//model & view communication
    public String[] getInventory() {
        return model.getItemNames(categories.getCurrentCategory(this));
    }

    public void remove(String name) {
        this.model.removeItem(categories.getCurrentCategory(this), name);
        this.view.fillInventory();
    }

//enum describes current page state
    public enum Location {
        NONE, HOME,
        //add categories here
        CATEGORY_FOOD, CATEGORY_COSMETIC, CATEGORY_CLEANING
    };
}
