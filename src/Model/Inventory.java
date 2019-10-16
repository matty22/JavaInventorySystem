package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    // Default constructor
    public Inventory() {
        
    }
    
    public static void addPart(Part newPart) {
        allParts.add(newPart); 
    }
    
    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
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
    public static Part lookupPart(String partName) {
        boolean found = false;
        for (Part part : allParts) {
            if (part.getPartName().contains(partName) || part.getPartID().toString().equals(partName)) {
                return part;
            }
        }
        return null;
    }
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
    
    public static ObservableList<Part> getAllParts() {
//        System.out.println(Inventory.allParts.toArray().length);
        return Inventory.allParts;
    }
    
    public ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }
}
