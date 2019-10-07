package Model;


public class Part {
    private int partID;
    private String partName;
    private double partPrice;
    private int partStock;
    private int partMin;
    private int partMax;
    
    // Constructor
    public Part(int id, String name, double price, int stock, int min, int max) {
        // do some constuctor-y stuff
    }
    
    // Setters
    public void setId(int id) {
        this.partID = id;
    }
    
    public void setName(String name) {
        this.partName = name;
    }
    
    public void setPrice(double price) {
        this.partPrice = price;
    }
    
    public void setStock(int stock) {
        this.partStock = stock;
    }
    
    public void setMin(int min) {
        this.partMin = min;
    }
    
    public void setMax(int max) {
        this.partMax = max;
    }
    
    public void setPrice(int max) {
        this.partPrice = max;
    }
    
    // Getters
    public int getId() {
        return this.partID;
    }
    
    public String getName() {
        return this.partName;
    }
    
    public double getPrice() {
        return this.partPrice;
    }
    
    public int getStock() {
        return this.partStock;
    }
    
    public int getMin() {
        return this.partMin;
    }
    
    public int getMax() {
        return this.partMax;
    }
    
}
