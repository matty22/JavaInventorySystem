package View_Controller;

import Model.Helpers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    
    // FXML variables for screen label
    @FXML private Label screenLabel;
    
    // Initialize the controller
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        outsourcedButton.setSelected(true);
        idField.setDisable(true);
        idField.setPromptText("ID Auto Generated");
    }    
    
    // Handles save button click
    public void saveButtonHandler() {
        // do something
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
    
}
