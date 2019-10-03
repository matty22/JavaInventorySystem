package View_Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class MainController implements Initializable {

    // FXML variables for parts table block
    @FXML private Button searchPartsButton;
    @FXML private Button addPartsButton;
    @FXML private Button modifyPartsButton;
    @FXML private Button deletePartsButton;
    @FXML private TextField searchPartsField;
    @FXML private TableView tableViewParts;
    
    // FXML variables for products table block
    @FXML private Button searchProductsButton;
    @FXML private Button addProductsButton;
    @FXML private Button modifyProductsButton;
    @FXML private Button deleteProductsButton;
    @FXML private TextField searchProductsField;
    @FXML private TableView tableViewProducts;
    
    // FXML variables for screen
    @FXML private Button exitButton;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    // Main screen parts panel button handlers
    public void partsSearchButtonHandler() {
        // do something
    }
    
    public void partsAddButtonHandler() {
        // do something
    }
    
    public void partsModifyButtonHandler() {
        // do something
    }
    
    public void partsDeleteButtonHandler() {
        // do something
    }
    
    
    // Main screen products panel button handlers
    public void productsSearchButtonHandler() {
        // do something
    }
    
    public void productsAddButtonHandler() {
        // do something
    }
    
    public void productsModifyButtonHandler() {
        // do something
    }
    
    public void productsDeleteButtonHandler() {
        // do something
    }
    
    // Exit button handler
    public void exitButtonHandler() {
        // do something
    }
    
}
