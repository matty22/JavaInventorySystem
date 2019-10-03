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
    
}
