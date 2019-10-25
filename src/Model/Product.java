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
    
    // Sets product id
    public void setProductId(int id) {
        this.productID.set(id);
    }
    
    // Sets product name
    public void setProductName(String name) {
        this.productName.set(name);
    }
    
    // Sets product price
    public void setProductPrice(double price) {
        this.productPrice.set(price);
    }
    
    // Sets product inventory
    public void setProductStock(int stock) {
        this.productStock.set(stock);
    }
    
    // Sets product min stock
    public void setProductMin(int min) {
        this.productMin.set(min);
    }
    
    // Sets product max stock
    public void setProductMax(int max) {
        this.productMax.set(max);
    }
    
    // Sets product associated parts
    public void setAssociatedParts(ObservableList<Part> partList) {
        this.associatedParts = partList;
    }
    
    // Gets product id
    public Integer getProductId() {
        return productID.get();
    }
    
    // Gets product name
    public String getProductName() {
        return productName.get();
    }
    
    // Gets product price
    public double getProductPrice() {
        return productPrice.get();
    }
    
    // Gets product inventory
    public int getProductStock() {
        return productStock.get();
    }
    
    // Gets product min stock
    public int getProductMin() {
        return productMin.get();
    }
    
    // Gets product max stock
    public int getProductMax() {
        return productMax.get();
    }
    
    // Get all associated parts for a product
    public ObservableList<Part> getAllAssociatedParts() {
        return this.associatedParts;
    }  
}
