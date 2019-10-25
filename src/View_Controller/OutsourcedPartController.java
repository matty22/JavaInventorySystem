package View_Controller;

import Model.Helpers;
import Model.Inventory;
import Model.OutsourcedPart;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class OutsourcedPartController implements Initializable {

    // FXML variables for fields
    @FXML private RadioButton inhouseButton;
    @FXML private RadioButton outsourcedButton;
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField invField;
    @FXML private TextField priceField;
    @FXML private TextField maxField;
    @FXML private TextField minField;
    @FXML private TextField companyField;
    
    // FXML variables for buttons
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    @FXML private ToggleGroup partChooser;
    
    // FXML variables for screen label
    @FXML private Label screenLabel;
    Part currentPart;
    
    // Initialize the controller
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outsourcedButton.setSelected(true);
        idField.setDisable(true);
        idField.setPromptText("ID Auto Generated");
    }    
    
    // Handles save button click
    public void saveButtonHandler(ActionEvent event) throws IOException {
        ObservableList<Part> partList = Inventory.getAllParts();
        int newPartId;
        if (this.currentPart != null) {
            newPartId = Integer.parseInt(idField.getText());
        } else {
            newPartId = Helpers.generatePartId();
        }
        Part newPart = new OutsourcedPart(
                                           newPartId, 
                                           nameField.getText(),
                                           Double.parseDouble(priceField.getText()),
                                           Integer.parseInt(invField.getText()),
                                           Integer.parseInt(minField.getText()),
                                           Integer.parseInt(maxField.getText()),
                                           companyField.getText()); 
        
        // Make sure max > min && min < max
        if (Integer.parseInt(minField.getText()) > Integer.parseInt(maxField.getText())) {
            Helpers.throwErrorAlert();
        } else {
            // Determine if the part should be updated or created
            boolean newPartAlreadyExists = false;
            for(Part element : partList) {
                if (element.getPartID() == newPartId) {
                    newPartAlreadyExists = true;
                }
            }
        
            if (newPartAlreadyExists) {
                Inventory.updatePart(newPart);
            } else {
                Inventory.addPart(newPart);
            }
        
            Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene mainScene = new Scene(parent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(mainScene);
            window.show();
        }
    }
    
    // Handles cancel button click
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        String buttonClicked = Helpers.throwConfirmationAlert();
        if(buttonClicked.equals("OK")){
            Parent addPartParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene addPartScene = new Scene(addPartParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(addPartScene);
            window.show();
        }
    }
    
    // Handles swapping between outsourced and inhouse part screens
    public void swapOutsourcedButtonHandler(ActionEvent event) throws IOException {
        Parent addOutsourcedParent = FXMLLoader.load(getClass().getResource("InhousePart.fxml"));
        Scene addPartScene = new Scene(addOutsourcedParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(addPartScene);
        window.show();
    }
    
    // Passes part data to modify part screen on modify part button click
    public void passOutsourcedPartToModify(Part part, String companyName) {
        this.currentPart = part;
        this.partChooser.getToggles().forEach(toggle -> {
            Node node = (Node) toggle;
            node.setDisable(true);
        });
        screenLabel.setText("Modify Outsourced Part");
        idField.setText(part.getPartID().toString());
        nameField.setText(part.getPartName());
        priceField.setText(String.valueOf(part.getPartPrice()));
        invField.setText(String.valueOf(part.getPartStock()));
        maxField.setText(String.valueOf(part.getPartMax()));
        minField.setText(String.valueOf(part.getPartMin()));
        companyField.setText(companyName);
    }  
}
