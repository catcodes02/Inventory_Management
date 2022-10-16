package InventoryManagement;

public class ItemFactory {

    public Item createItem(String category, String name, double price, int quantity, String other) {
        Item item;

        switch (category.toUpperCase()) {
            case "FOOD":
                item = new FoodItem();
                try {
                    item.setShelfLife(Integer.parseInt(other));
                } catch (NumberFormatException e) {
                    System.out.println("required integer!");
                }
                break;

            case "CLEANINGSUPPLIES":
                item = new CleaningSuppliesItem();
                item.setUsage(other);
                break;

            case "COSMETIC":
                item = new CosmeticItem();
                item.setApplication(other);
                break;

            default:
                item = null;
                System.out.println("No such category");
        }

        if (item != null) { //error checking
            item.setName(name);
            item.setPrice(price);
            item.setQuantity(quantity);
        }
        return item;
    }
}
