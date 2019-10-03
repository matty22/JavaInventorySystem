package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class ProductController implements Initializable {

    // FXML variables for left side text fields
    @FXML private Label screenLabel;
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField invField;
    @FXML private TextField priceField;
    @FXML private TextField maxField;
    @FXML private TextField minField;
    
    // FXML variable for search box
    @FXML private TextField searchBox;
    
    // FXML variables for tables
    @FXML private TableView topTable;
    @FXML private TableView bottomTable;
    
    // FXML variables for buttons
    @FXML private Button searchButton;
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
