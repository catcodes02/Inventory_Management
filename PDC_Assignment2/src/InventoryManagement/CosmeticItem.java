package InventoryManagement;

public class CosmeticItem extends Item {

    private String application; //body part

//constructors
    public CosmeticItem() {
        super();
        this.setApplication("unknown");
    }

    public CosmeticItem(String name, double price, int quantity, String bodyPart) {
        super(name, price, quantity);
        this.setApplication(bodyPart);
    }

//getters & setters
    public String getApplication() {
        return this.application;
    }

    @Override
    public void setApplication(String bodyPart) {
        this.application = bodyPart;
    }

    //method used to add items to database
    @Override
    public String getSQLString() {
        return "('" + this.getName() + "'," + this.getQuantity() + ", "
                + this.getPrice() + ", " + this.getApplication() + ")";
    }

//item_name + quantity + price_NZD + application_body_part
    @Override
    public String toString() {
        return super.toString() + " " + this.getApplication();
    }
}
