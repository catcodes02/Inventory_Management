package InventoryManagement;

public class CleaningSuppliesItem extends Item {

    private String usage; //what it cleans
    private final String warningMessage
            = "Wear gloves while using, seek a doctor attention if irritation occurs"
            + "Not suitable for consumption, call the poison centre (0800 764 766) if ingested.";

//constructors
    public CleaningSuppliesItem() {
        super();
        this.setUsage("unknown");
    }

    public CleaningSuppliesItem(String name, double price, int quantity, String objectToClean) {
        super(name, price, quantity);
        this.setUsage(objectToClean);
    }

//getters & setters
    public String getUsage() {
        return this.usage;
    }

    @Override
    public void setUsage(String objectToClean) {
        this.usage = objectToClean;
    }

    public String getWarning() {
        return this.warningMessage;
    }

//print functions
    public void printWarning() {
        System.out.println(this.getWarning());
    }

//item_name + quantity + price_NZD + application_body_part
    @Override
    public String toString() {
        return super.toString() + " " + this.getUsage();
    }
}
