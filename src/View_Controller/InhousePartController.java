package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
