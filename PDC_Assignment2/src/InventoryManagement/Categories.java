package InventoryManagement;

public class Categories {

    //available categories
    public final String[] categories
            = {"Food", "Cleaning Supplies", "Cosmetics"};

    public void changeStateToCategory(InventoryManagementController controller, String category) {

        switch (category) {
            case "Food":
                controller.changeState(InventoryManagementController.Location.CATEGORY_FOOD);
                break;
            case "Cosmetics":
                controller.changeState(InventoryManagementController.Location.CATEGORY_COSMETICS);
                break;
            case "Cleaning Supplies":
                controller.changeState(InventoryManagementController.Location.CATEGORY_CLEANING_SUPPLIES);
                break;
            default:
                controller.changeState(InventoryManagementController.Location.NONE);
                break;
        }
    }
}
