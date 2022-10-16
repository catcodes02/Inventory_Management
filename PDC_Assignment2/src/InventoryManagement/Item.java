package InventoryManagement;

public abstract class Item {

    protected String name;
    protected double price;
    protected int quantity;

//constructors
    public Item() {
        this.setName("unknown");
        this.setPrice(0);
        this.setQuantity(0);
    }

    public Item(String name, double price, int quantity) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

//getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//item_name + quantity + price_NZD 
    @Override
    public String toString() {
        return this.getName() + " " + this.getQuantity() + " " + this.getPrice();
    }

//hook methods
    public void setShelfLife(int days) {
    }

    public void setUsage(String objectToClean) {
    }

    public void setApplication(String bodyPart) {
    }
}
