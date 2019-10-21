package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;


public class Product {
    private ObservableList<Part> associatedParts;
    private final SimpleIntegerProperty productID = new SimpleIntegerProperty(0);
    private final SimpleStringProperty productName = new SimpleStringProperty("");
    private final SimpleDoubleProperty productPrice = new SimpleDoubleProperty(0.0);
    private final SimpleIntegerProperty productStock = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty productMin = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty productMax = new SimpleIntegerProperty(0);
    
    // Constructor
    public Product(int id, String name, double price, int stock, int min, int max, ObservableList<Part> associatedParts) {
        setProductId(id);
        setProductName(name);
        setProductPrice(price);
        setProductStock(stock);
        setProductMin(min);
        setProductMax(max);
        setAssociatedParts(associatedParts);
    }
    
    // Setters
    public void setProductId(int id) {
        this.productID.set(id);
    }
    
    public void setProductName(String name) {
        this.productName.set(name);
    }
    
    public void setProductPrice(double price) {
        this.productPrice.set(price);
    }
    
    public void setProductStock(int stock) {
        this.productStock.set(stock);
    }
    
    public void setProductMin(int min) {
        this.productMin.set(min);
    }
    
    public void setProductMax(int max) {
        this.productMax.set(max);
    }
    
    public void setAssociatedParts(ObservableList<Part> partList) {
        this.associatedParts = partList;
    }
    
    // Getters
    public Integer getProductId() {
        return productID.get();
    }
    
    public String getProductName() {
        return productName.get();
    }
    
    public double getProductPrice() {
        return productPrice.get();
    }
    
    public int getProductStock() {
        return productStock.get();
    }
    
    public int getProductMin() {
        return productMin.get();
    }
    
    public int getProductMax() {
        return productMax.get();
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
