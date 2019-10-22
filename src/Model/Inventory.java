package Model;

import static java.lang.Integer.parseInt;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    
    // Method to add a new part
    public static void addPart(Part newPart) {
        allParts.add(newPart); 
    }
    
    // Method to add a new product
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }
    
    // Method for searching for parts
    public static Part lookupPart(String partName) {
        for (Part part : allParts) {
            if (part.getPartName().equals(partName) || part.getPartID().toString().equals(partName)) {
                return part;
            }
        }
        return null;
    }
    
    // Method to search for products
    public static Product lookupProduct(String productName) {
      for (Product product : allProducts) {
            if (product.getProductName().equals(productName) || product.getProductId().toString().equals(productName)) {
                return product;
            }
        }
        return null;
    }
    
    // Method for updating an existing part
    public static void updatePart(Part modifiedPart) {
        for(Part part : allParts) {
            if(Objects.equals(part.getPartID(), modifiedPart.getPartID())) {
                allParts.remove(part);
                allParts.add(modifiedPart);
            }
        }
    }
    
    // Method for updating an existing product
    public static void updateProduct(Product modifiedProduct) {
        Product productToRemove = null;
        for(Product product : allProducts) {
            if(Objects.equals(product.getProductId(), modifiedProduct.getProductId())) {
                productToRemove = product;
            }
        }
        allProducts.remove(productToRemove);
        allProducts.add(modifiedProduct);
    }
    
    // Method for deleting a part
    public static void deletePart(Part selectedPart) {
        allParts.remove(selectedPart);
    }
    
    // Method for deleting a product
    public static void deleteProduct(Product selectedProduct) {
        allProducts.remove(selectedProduct);
    }
    
    // Method to get all existing parts
    public static ObservableList<Part> getAllParts() {
        return Inventory.allParts;
    }
    
    // Method to get all existing products
    public static ObservableList<Product> getAllProducts() {
        return Inventory.allProducts;
    }
}
