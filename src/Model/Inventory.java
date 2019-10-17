package Model;

import java.util.Objects;
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
    
    // Fully implement this method next
    public static void updatePart(Part modifiedPart) {
        for(Part part : allParts) {
            if(Objects.equals(part.getPartID(), modifiedPart.getPartID())) {
                allParts.remove(part);
                System.out.print("Removed: ");
                System.out.println(part);
                allParts.add(modifiedPart);
                System.out.print("Added: ");
                System.out.println(modifiedPart);
            }
        }
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
