package Model;

import javafx.collections.ObservableList;


public class Inventory {
    private ObservableList<Part> allParts;
    private ObservableList<Product> allProducts;
    
    public void addPart(Part newPart) {
    
    }
    
    public void addProduct(Product newProduct) {
    
    }
    
    // Commented until I have ObservableLists setup
//    public Part lookupPart(int partId) {
//        
//    }
//    
//    public Product lookupProduct(int productId) {
//    
//    }
//    
//    public ObservableList<Part> lookupPart(String partName) {
//        
//    }
//    
//    public ObservableList<Product> lookupProduct(String productName) {
//    
//    }
    
    public void updatePart(int index, Part selectedPart) {
    
    }
    
    public void updateProduct(int index, Product selectedProduct) {
    
    }
    
    public void deletePart(Part selectedPart) {
    
    }
    
    public void deleteProduct(Product selectedProduct) {
    
    }
    
    public ObservableList<Part> getAllParts() {
        return this.allParts;
    }
    
    public ObservableList<Product> getAllProducts() {
        return this.allProducts;
    }
}
