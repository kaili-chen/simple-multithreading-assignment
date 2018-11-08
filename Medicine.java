package proj.classes;

public class Medicine {

    private int medID;
    private String name;
    private int qty;
    private String type;    //eg syrup, pill, injection etc.
    private String unit;    //uom eg g, mg etc
    private double amountPerUnit;
    
    public Medicine(int medID, String name, double amountPerUnit, String unit, int qty, String type) {
        this.medID = medID;
        this.name = name;
        this.amountPerUnit = amountPerUnit;
        this.qty = qty;
        this.unit = unit;
        this.type = type;
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

    public double getAmountPerUnit() {
        return amountPerUnit;
    }

    public int getUnit() {
        return unit;
    }

    public String getType() {
        return type;
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

    public void setAmountPerUnit(double newAmount) {
        amountPerUnit = newAmount;
    }

    public void setUnit(String newUnit) {
        unit = newUnit;
    }
}