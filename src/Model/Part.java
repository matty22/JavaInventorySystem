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
    
    // Constructor
    public Part(int id, String name, double price, int stock, int min, int max) {
        setPartID(id);
        setPartName(name);
        setPartPrice(price);
        setPartStock(stock);
        setPartMin(min);
        setPartMax(max);
    }
    

    /**
     * @return the partID
     */
    public Integer getPartID() {
        return partID.get();
    }

    /**
     * @param partID the partID to set
     */
    public void setPartID(int partID) {
        this.partID.set(partID);
    }

    /**
     * @return the partName
     */
    public String getPartName() {
        return partName.get();
    }

    /**
     * @param partName the partName to set
     */
    public void setPartName(String partName) {
        this.partName.set(partName);
    }

    /**
     * @return the partPrice
     */
    public double getPartPrice() {
        return partPrice.get();
    }

    /**
     * @param partPrice the partPrice to set
     */
    public void setPartPrice(double partPrice) {
        this.partPrice.set(partPrice);
    }

    /**
     * @return the partStock
     */
    public int getPartStock() {
        return partStock.get();
    }

    /**
     * @param partStock the partStock to set
     */
    public void setPartStock(int partStock) {
        this.partStock.set(partStock);
    }

    /**
     * @return the partMin
     */
    public int getPartMin() {
        return partMin.get();
    }

    /**
     * @param partMin the partMin to set
     */
    public void setPartMin(int partMin) {
        this.partMin.set(partMin);
    }

    /**
     * @return the partMax
     */
    public int getPartMax() {
        return partMax.get();
    }

    /**
     * @param partMax the partMax to set
     */
    public void setPartMax(int partMax) {
        this.partMax.set(partMax);
    }
      
}
