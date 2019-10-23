/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Matty
 */
public class Helpers {
    
    // Observable Lists holding used ids
    private static ObservableList<Integer> usedPartIds = FXCollections.observableArrayList();;
    private static ObservableList<Integer> usedProductIds = FXCollections.observableArrayList();;
    
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
    
}
