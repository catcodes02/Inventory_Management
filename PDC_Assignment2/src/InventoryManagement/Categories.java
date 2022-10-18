package InventoryManagement;

public class Categories {

    //available categories
    public final String[] listOfCategories
            = {"Food", "Cleaning Supplies", "Cosmetics"};

    //return string based on controllers current location enum variable
    public String getCurrentCategory(InventoryManagementController controller) {
        String category = "unknown";

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

    //change controllers location enum variable to a given category
    public void changeLocationToCategory(InventoryManagementController controller, String category) {
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

    //get string of item information based on the current location category
    public String getItemInfo(InventoryManagementController controller, Item item) {
        String returnString
                = "Name: " + item.getName()
                + "\nQuantity: " + item.getQuantity()
                + "\nPrice: $" + item.getPrice();

        switch (controller.currentLocation) {
            case CATEGORY_FOOD:
                returnString += "\nShelf Life: " + item.getShelfLife() + " days";
                break;
            case CATEGORY_COSMETIC:
                returnString += "\nApplication: " + item.getApplication();
                break;
            case CATEGORY_CLEANING:
                returnString += "\nUsage: " + item.getUsage()
                        + "\n\nWarnings:\n" + item.getWarning();
                break;
            default:
                System.out.println("ERROR: item type not found");
                break;
        }
        return returnString;
    }
}
