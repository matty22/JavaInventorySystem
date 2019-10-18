package Model;

import static java.lang.Integer.parseInt;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    
    public static void addPart(Part newPart) {
        allParts.add(newPart); 
    }
    
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
        System.out.println("There are " + allProducts.toArray().length + " products");
    }
    
  
    public static Part lookupPart(String partName) {
        for (Part part : allParts) {
            if (part.getPartName().contains(partName) || part.getPartID().toString().equals(partName)) {
                return part;
            }
        }
        return null;
    }
    
    public static Product lookupProduct(String productName) {
      for (Product product : allProducts) {
            if (product.getProductName().contains(productName) || product.getProductId() == parseInt(productName)) {
                return product;
            }
        }
        return null;
    }
    
    public static void updatePart(Part modifiedPart) {
        for(Part part : allParts) {
            if(Objects.equals(part.getPartID(), modifiedPart.getPartID())) {
                allParts.remove(part);
                allParts.add(modifiedPart);
            }
        }
    }
    
    public void updateProduct(int index, Product selectedProduct) {
    
    }
    
    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    
    public void deleteProduct(Product selectedProduct) {
    
    }
    
    public static ObservableList<Part> getAllParts() {
        return Inventory.allParts;
    }
    
    public static ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }
}
