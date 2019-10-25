package View_Controller;

import Model.Helpers;
import Model.InhousePart;
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
    @FXML private TextField machineIdField;
    
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
        inhouseButton.setSelected(true);
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
        InhousePart newPart = new InhousePart(
                                        newPartId, 
                                        nameField.getText(),
                                        Double.parseDouble(priceField.getText()),
                                        Integer.parseInt(invField.getText()),
                                        Integer.parseInt(minField.getText()),
                                        Integer.parseInt(maxField.getText()),
                                        Integer.parseInt(machineIdField.getText())); 
      
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
        
            // Update or create part based on newPartAlreadyExists
            if (newPartAlreadyExists) {
                Inventory.updatePart(newPart);
            } else {
                Inventory.addPart(newPart);
            }
            
            // Change screen back to Main
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
    
    // Passes part data to modify part screen on modify part button click
    public void passInhousePartToModify(Part part, int machineId) {
        this.currentPart = part;
        screenLabel.setText("Modify Inhouse Part");
        idField.setText(part.getPartID().toString());
        nameField.setText(part.getPartName());
        priceField.setText(String.valueOf(part.getPartPrice()));
        invField.setText(String.valueOf(part.getPartStock()));
        maxField.setText(String.valueOf(part.getPartMax()));
        minField.setText(String.valueOf(part.getPartMin()));
        machineIdField.setText(String.valueOf(machineId));
    } 
    
    // Handle switching between inhouse/outsourced add and modify screens
    public void swapOutsourcedButtonHandler(ActionEvent event) throws IOException {
        Part part = this.currentPart;
        Parent root;
        Stage stage = (Stage) outsourcedButton.getScene().getWindow();
        if (this.currentPart != null && this.currentPart instanceof InhousePart) {
            // Create new outsourced part out of the values of the passed in inhouse part
            OutsourcedPart outsourcedPart = new OutsourcedPart(
                                                                part.getPartID(),
                                                                part.getPartName(),
                                                                part.getPartPrice(),
                                                                part.getPartStock(),
                                                                part.getPartMin(),
                                                                part.getPartMax(),
                                                                ""
            );
            
            // Change page to OutsourcedPart.fxml and pass newly created outsourcedPart
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OutsourcedPart.fxml"));
            root = loader.load();
            OutsourcedPartController controller = loader.getController();
            controller.passOutsourcedPartToModify(outsourcedPart, "");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else if (this.currentPart != null && this.currentPart instanceof OutsourcedPart) {
            Parent addOutsourcedParent = FXMLLoader.load(getClass().getResource("InhousePart.fxml"));
            Scene addPartScene = new Scene(addOutsourcedParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(addPartScene);
            window.show();
        } else if (this.currentPart == null) {
            Parent addOutsourcedParent = FXMLLoader.load(getClass().getResource("OutsourcedPart.fxml"));
            Scene addPartScene = new Scene(addOutsourcedParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(addPartScene);
            window.show();
        }
    }
}
