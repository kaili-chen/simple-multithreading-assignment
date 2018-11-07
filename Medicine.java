package proj.classes;

public class Medicine {

    private int medID;
    private String name;
    private int qty;
    private String type;
    private String manufacturer;
    
    public Medicine(int medID, String name, int qty, String type, String manufacturer) {
        this.medID = medID;
        this.name = name;
        this.qty = qty;
        this.type = type;
        this.manufacturer = manufacturer;
    }

//use custom exception here?
    public boolean dispense(int qtyToDispense) {

        if (qtyToDispense > qty) {
            return false;
        } else {
            qty -= qtyToDispense;
            return true;
        }
    }

    //GETTERS
    public void replenish(int qtyToReplenish) {
        qty += qtyToReplenish;
    }

    public int getMedID() {
        return medID;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    //SETTERS
    public void setMedID(int newMedID) {
        medID = newMedID;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setQty(int newQty) {
        qty = newQty;
    }

    public void setManufacturer(String newManufacturer) {
        manufacturer = newManufacturer;
    }
}