package InventoryManagement;

public class CategoryFactory {

    //available categories
    public final String[] categories
            = {"Food", "Cleaning Supplies", "Cosmetics"};

    public void changeStateToCategory(InventoryManagementController controller, String category) {

        switch (category) {
            case "Food":
                controller.changeState(InventoryManagementController.State.CATEGORY_FOOD);
                break;
            case "Cosmetics":
                controller.changeState(InventoryManagementController.State.CATEGORY_COSMETICS);
                break;
            case "Cleaning Supplies":
                controller.changeState(InventoryManagementController.State.CATEGORY_CLEANING_SUPPLIES);
                break;
            default:
                controller.changeState(InventoryManagementController.State.NONE);
                break;
        }
    }
}
