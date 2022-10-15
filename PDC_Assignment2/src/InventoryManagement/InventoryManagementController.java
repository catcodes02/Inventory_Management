package InventoryManagement;

public class InventoryManagementController {

    public final InventoryManagementModel model;
    public final InventoryManagementView view;
    public final CategoryFactory categoryFactory;

    public State currentState = State.NONE;

    public InventoryManagementController() {
        this.model = new InventoryManagementModel();
        this.view = new InventoryManagementView();

        this.categoryFactory = new CategoryFactory();

        view.setController(this);
        this.view.startGUI();
    }

    public InventoryManagementController(InventoryManagementModel model, InventoryManagementView view) {
        this.model = model;
        this.view = view;

        this.categoryFactory = new CategoryFactory();

        view.setController(this);
        this.view.startGUI();
    }

    public void changeState(State state) {
        this.currentState = state;
    }

    //enum describes current page state
    public enum State {
        NONE, HOME,
        //add categories here
        CATEGORY_FOOD, CATEGORY_COSMETICS, CATEGORY_CLEANING_SUPPLIES
    };
}
