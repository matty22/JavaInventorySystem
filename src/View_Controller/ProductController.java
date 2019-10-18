package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.Part;
import Model.Product;
import static View_Controller.MainController.initialized;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    
    // FXML variables for table columns
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInventoryColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;
    
    
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
        // Bind top table columns
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        
        // Add parts to top table
        // Set up dummy part data upon application first loading
        ObservableList<Part> blankList = null;
        topTable.setItems(blankList);
        topTable.setItems(Inventory.getAllParts());
    }    
    
    // Button Handlers
    
    public void searchButtonHandler() {
        // do something
    }
    
    public void addButtonHandler() {
        // do something
    }
    
    public void deleteButtonHandler() {
        // do something
    }
    
    public void saveButtonHandler(ActionEvent event) throws IOException {
        Product newProduct = new Product(Integer.parseInt(idField.getText()), 
                                           nameField.getText(),
                                           Double.parseDouble(priceField.getText()),
                                           Integer.parseInt(invField.getText()),
                                           Integer.parseInt(minField.getText()),
                                           Integer.parseInt(maxField.getText()),
                                           bottomTable.getItems()); 
        
        Inventory.addProduct(newProduct);
        Parent cancelProductParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene cancelProductScene = new Scene(cancelProductParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(cancelProductScene);
        window.show();
    }
    
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        Parent cancelProductParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene cancelProductScene = new Scene(cancelProductParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(cancelProductScene);
        window.show();
    }
    
}
