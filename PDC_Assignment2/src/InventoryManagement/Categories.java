package InventoryManagement;

public class Categories {

    //available categories
    public final String[] listOfCategories
            = {"Food", "Cleaning Supplies", "Cosmetics"};

    public void changeStateToCategory(InventoryManagementController controller, String category) {

        switch (category) {
            case "Food":
                controller.changeLocation(InventoryManagementController.Location.CATEGORY_FOOD);
                break;
            case "Cosmetics":
                controller.changeLocation(InventoryManagementController.Location.CATEGORY_COSMETIC);
                break;
            case "Cleaning Supplies":
                controller.changeLocation(InventoryManagementController.Location.CATEGORY_CLEANING);
                break;
            default:
                controller.changeLocation(InventoryManagementController.Location.NONE);
                break;
        }
    }

    public String getCurrentCategory(InventoryManagementController controller) {
        String category = "";

        switch (controller.currentLocation) {
            case CATEGORY_FOOD:
                category = "FOOD";
                break;
            case CATEGORY_COSMETIC:
                category = "COSMETIC";
                break;
            case CATEGORY_CLEANING:
                category = "CLEANING";
                break;
            default:
                System.out.println("category unavailable");
                break;
        }

        return category;
    }
}
