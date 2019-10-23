/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Matty
 */
public class Helpers {
    
    // Observable Lists holding used ids
    private static ObservableList<Integer> usedPartIds = FXCollections.observableArrayList();
    private static ObservableList<Integer> usedProductIds = FXCollections.observableArrayList();
    
    // Add dummy data ids to lists
    public static void addIDs(String type, int id) {
        if (type.equals("part")) {
            usedPartIds.add(id);
        } else {
            usedProductIds.add(id);
        }
        
    }
    
    // Generate random id numbers for parts
    public static int generatePartId() {
        int randomNumber = (int)(Math.random() * 10000 + 1);   
        while(usedPartIds.contains(randomNumber)) {
            randomNumber = (int)(Math.random() * 10000 + 1);
        }
        usedPartIds.add(randomNumber);
        return randomNumber;
    }
    
    // Generate random id numbers for products
    public static int generateProductId() {
        int randomNumber = (int)(Math.random() * 10000 + 1);
        while(usedProductIds.contains(randomNumber)) {
            randomNumber = (int)(Math.random() * 10000 + 1);
        }
        usedProductIds.add(randomNumber);
        return randomNumber;
    }
    
    // Throws error alert
    public static void throwErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Min value cannot exceed Max value");
        alert.showAndWait();
    }
    
    // Throws confirmation alert
    public static String throwConfirmationAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        return result.get().getText();
    }
    
}
