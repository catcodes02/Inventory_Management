package InventoryManagement;

public class InventoryManagementController {

    public final InventoryManagementModel model;
    public final InventoryManagementView view;
    public final Categories categories;

    public Location currentLocation = Location.NONE;

    public InventoryManagementController() {
        this.model = new InventoryManagementModel();
        this.view = new InventoryManagementView();

        this.categories = new Categories();

        view.setController(this);
        this.view.startGUI();
    }

    public InventoryManagementController(InventoryManagementModel model, InventoryManagementView view) {
        this.model = model;
        this.view = view;

        this.categories = new Categories();

        view.setController(this);
        this.view.startGUI();
    }

    public void changeState(Location location) {
        this.currentLocation = location;
    }

    //enum describes current page state
    public enum Location {
        NONE, HOME,
        //add categories here
        CATEGORY_FOOD, CATEGORY_COSMETICS, CATEGORY_CLEANING_SUPPLIES
    };
}
