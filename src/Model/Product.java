package Model;

import javafx.collections.ObservableList;


public class Product {
    private ObservableList<Part> associatedParts;
    private int productID;
    private String productName;
    private double productPrice;
    private int productStock;
    private int productMin;
    private int productMax;
    
    // Constructor
    public Product(int id, String name, double price, int stock, int min, int max) {
    
    }
    
    // Setters
    public void setId(int id) {
        this.productID = id;
    }
    
    public void setName(String name) {
        this.productName = name;
    }
    
    public void setPrice(double price) {
        this.productPrice = price;
    }
    
    public void setStock(int stock) {
        this.productStock = stock;
    }
    
    public void setMin(int min) {
        this.productMin = min;
    }
    
    public void setMax(int max) {
        this.productMax = max;
    }
    
    public void setPrice(int max) {
        this.productPrice = max;
    }
    
    // Getters
    public int getId() {
        return this.productID;
    }
    
    public String getName() {
        return this.productName;
    }
    
    public double getPrice() {
        return this.productPrice;
    }
    
    public int getStock() {
        return this.productStock;
    }
    
    public int getMin() {
        return this.productMin;
    }
    
    public int getMax() {
        return this.productMax;
    }
    
    // Deal with parts
    public void addAssociatedPart(Part part) {
    
    }
    
    public void deleteAssociatedPart(Part associatedPart) {
    
    }
    
    public ObservableList<Part> getAllAssociatedParts() {
        return this.associatedParts;
    }
    
}
