package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public abstract class Part {
    private final SimpleIntegerProperty partID = new SimpleIntegerProperty(0);
    private SimpleStringProperty partName = new SimpleStringProperty("");
    private SimpleDoubleProperty partPrice = new SimpleDoubleProperty(0.0);
    private SimpleIntegerProperty partStock = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty partMin = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty partMax = new SimpleIntegerProperty(0);
    private SimpleStringProperty partType = new SimpleStringProperty("");
    
    // Constructors
    public Part(int id, String name, double price, int stock, int min, int max) {
        setPartID(id);
        setPartName(name);
        setPartPrice(price);
        setPartStock(stock);
        setPartMin(min);
        setPartMax(max);
    }
    

    // Gets the part id
    public Integer getPartID() {
        return partID.get();
    }
    
    // Gets the part name
    public String getPartName() {
        return partName.get();
    }
    
    // Gets the part price
    public double getPartPrice() {
        return partPrice.get();
    }
    
    // Gets the part inventory
    public int getPartStock() {
        return partStock.get();
    }
    
    // Get the part min stock
    public int getPartMin() {
        return partMin.get();
    }
    
    // Get the part max stock
    public int getPartMax() {
        return partMax.get();
    }

    // Sets the part id
    public void setPartID(int partID) {
        this.partID.set(partID);
    }

    // Sets the part name
    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    // Sets the part price
    public void setPartPrice(double partPrice) {
        this.partPrice.set(partPrice);
    }

    // Sets the Part inventory
    public void setPartStock(int partStock) {
        this.partStock.set(partStock);
    }

    // Set the part min stock
    public void setPartMin(int partMin) {
        this.partMin.set(partMin);
    }

    // Set the part max stock
    public void setPartMax(int partMax) {
        this.partMax.set(partMax);
    }  
    
    // Set the type of part: inhouse or outsourced
    public void setPartType(String type) {
        this.partType.set(type);
    }
    
    // Get the type of part: inhouse or outsourced
    public String getPartType() {
        return this.partType.get();
    }
}
