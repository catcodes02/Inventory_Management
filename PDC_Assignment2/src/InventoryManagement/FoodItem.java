package InventoryManagement;

import java.time.LocalDate;

public class FoodItem extends Item {

    private int shelfLife; //days

//constructors
    public FoodItem() {
        super();
        this.setShelfLife(0);
    }

    public FoodItem(String name, double price, int quantity, int days) {
        super(name, price, quantity);
        this.setShelfLife(days);
    }

//getters & setters
    public int getShelfLife() {
        return this.shelfLife;
    }

    @Override
    public void setShelfLife(int days) {
        this.shelfLife = days;
    }

//functionality
    public LocalDate expiryFromNow() {
        return LocalDate.now().plusDays(this.shelfLife);
    }

//item_name + quantity + price_NZD + shelf_life_days
    @Override
    public String toString() {
        return super.toString() + " " + this.getShelfLife();
    }
}
