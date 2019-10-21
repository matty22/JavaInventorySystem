package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class InhousePartController implements Initializable {

    // FXML variables for fields
    @FXML private RadioButton inhouseButton;
    @FXML private RadioButton outsourcedButton;
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField invField;
    @FXML private TextField priceField;
    @FXML private TextField maxField;
    @FXML private TextField minField;
    @FXML private TextField machineID;
    
    // FXML variables for buttons
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    // FXML variables for screen label
    @FXML private Label screenLabel;
    Part currentPart;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inhouseButton.setSelected(true);
    }    
    
    // Handles save button click
    public void saveButtonHandler(ActionEvent event) throws IOException {
        ObservableList<Part> partList = Inventory.getAllParts();
        Part newPart = new Part(Integer.parseInt(idField.getText()), 
                                           nameField.getText(),
                                           Double.parseDouble(priceField.getText()),
                                           Integer.parseInt(invField.getText()),
                                           Integer.parseInt(minField.getText()),
                                           Integer.parseInt(maxField.getText())) {}; 
        //Below needs a refactor
        boolean newPartAlreadyExists = false;
        for(Part element : partList) {
            if (element.getPartID() == Integer.parseInt(idField.getText())) {
                newPartAlreadyExists = true;
                
            }
        }
        
        if (newPartAlreadyExists) {
            Inventory.updatePart(newPart);
        } else {
            Inventory.addPart(newPart);
        }
       
        // end refactor
        
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene mainScene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    
    // Handles cancel button click
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Parent addPartParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene addPartScene = new Scene(addPartParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(addPartScene);
        window.show();
    }
    
    // Handles swapping to outsourced part screen on radio button click
    public void swapOutsourcedButtonHandler(ActionEvent event) throws IOException {
        Parent addOutsourcedParent = FXMLLoader.load(getClass().getResource("OutsourcedPart.fxml"));
        Scene addPartScene = new Scene(addOutsourcedParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(addPartScene);
        window.show();
    }
    
    
    // Other methods
    public void passPartToModify(Part part) {
    this.currentPart = part;
    idField.setText(part.getPartID().toString());
    nameField.setText(part.getPartName());
    priceField.setText(String.valueOf(part.getPartPrice()));
    invField.setText(String.valueOf(part.getPartStock()));
    maxField.setText(String.valueOf(part.getPartMax()));
    minField.setText(String.valueOf(part.getPartMin()));
    }
    
}
