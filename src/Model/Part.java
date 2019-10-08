package Model;


public abstract class Part {
    private int partID;
    private String partName;
    private double partPrice;
    private int partStock;
    private int partMin;
    private int partMax;
    
    // Constructor
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.partID = id;
        this.partName = name;
        this.partPrice = price;
        this.partStock = stock;
        this.partMin = min;
        this.partMax = max;
    }
    

    /**
     * @return the partID
     */
    public int getPartID() {
        return partID;
    }

    /**
     * @param partID the partID to set
     */
    public void setPartID(int partID) {
        this.partID = partID;
    }

    /**
     * @return the partName
     */
    public String getPartName() {
        return partName;
    }

    /**
     * @param partName the partName to set
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * @return the partPrice
     */
    public double getPartPrice() {
        return partPrice;
    }

    /**
     * @param partPrice the partPrice to set
     */
    public void setPartPrice(double partPrice) {
        this.partPrice = partPrice;
    }

    /**
     * @return the partStock
     */
    public int getPartStock() {
        return partStock;
    }

    /**
     * @param partStock the partStock to set
     */
    public void setPartStock(int partStock) {
        this.partStock = partStock;
    }

    /**
     * @return the partMin
     */
    public int getPartMin() {
        return partMin;
    }

    /**
     * @param partMin the partMin to set
     */
    public void setPartMin(int partMin) {
        this.partMin = partMin;
    }

    /**
     * @return the partMax
     */
    public int getPartMax() {
        return partMax;
    }

    /**
     * @param partMax the partMax to set
     */
    public void setPartMax(int partMax) {
        this.partMax = partMax;
    }
      
}
