package View_Controller;

import Model.Helpers;
import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
    
    @FXML private TableColumn<Product, Integer> productPartIdColumn;
    @FXML private TableColumn<Product, String> productPartNameColumn;
    @FXML private TableColumn<Product, Integer> productPartInventoryColumn;
    @FXML private TableColumn<Product, Double> productPartPriceColumn;
    
    
    // FXML variables for buttons
    @FXML private Button searchButton;
    @FXML private Button addButton;
    @FXML private Button deleteButton;
    @FXML private Button cancelButton;
    @FXML private Button saveButton;
    ObservableList<Part> productParts = FXCollections.observableArrayList();
    Product currentProduct = new Product(0, "Placeholder", 0.0, 0, 0, 0, productParts);
    // Initialize the controller
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Disable id field so it cannot be directly manipulated 
        idField.setDisable(true);
        idField.setPromptText("ID Auto Generated");
        
        // Disable add and remove part buttons unless part is selected from table views
        addButton.setDisable(true);
        deleteButton.setDisable(true);
        
        // Bind top table columns
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
        partInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        
        // Bind product table columns
       productPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
       productPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
       productPartInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
       productPartPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
        
        // Add parts to top table
        // Set up dummy part data upon application first loading
        topTable.setItems(Inventory.getAllParts());
    } 
    
    public void populateBottomTable() {
        Product localCurrentProduct = currentProduct;
        bottomTable.setItems(currentProduct.getAllAssociatedParts());
    }
    
    // Handles product screen search button click
    public void searchButtonHandler() {
        Part foundPart = Inventory.lookupPart(searchBox.getText());
        topTable.getSelectionModel().select(foundPart);
    }
    
    // Handles add part to product button click
    public void addButtonHandler() {
        // Adds part to product
        Part selectedPart = (Part) (topTable.getSelectionModel().getSelectedItem());
        if(!bottomTable.getSelectionModel().isEmpty()) {
            productParts = bottomTable.getItems();
        }
        productParts.add(selectedPart);
        // This line is the likely culprit
        currentProduct.setAssociatedParts(productParts);
        
        // Repopulate bottom table with updated associated parts
        bottomTable.setItems(currentProduct.getAllAssociatedParts());
        
    }
    
    // Handles delete part from product button click
    public void deleteButtonHandler() {
        String buttonClicked = Helpers.throwConfirmationAlert();
        if(buttonClicked.equals("OK")){
            Part selectedPart = (Part) (bottomTable.getSelectionModel().getSelectedItem());
            productParts = bottomTable.getItems();
            productParts.remove(selectedPart);
        
            // Repopulate bottom table with updated associated parts
            bottomTable.setItems(currentProduct.getAllAssociatedParts());
        }
    }
    
    // Handles save product button click
    public void saveButtonHandler(ActionEvent event) throws IOException {
        ObservableList<Product> productList = Inventory.getAllProducts();
        int newProductId;
        if (this.currentProduct.getProductId() != 0) {
            newProductId = Integer.parseInt(idField.getText());
        } else {
            newProductId = Helpers.generateProductId();
        }
        
        Product newProduct = new Product(
                                           newProductId, 
                                           nameField.getText(),
                                           Double.parseDouble(priceField.getText()),
                                           Integer.parseInt(invField.getText()),
                                           Integer.parseInt(minField.getText()),
                                           Integer.parseInt(maxField.getText()),
                                           bottomTable.getItems()
                                        ); 
        // Make sure max > min && min < max
        if (Integer.parseInt(minField.getText()) > Integer.parseInt(maxField.getText())) {
            Helpers.throwErrorAlert();
        } else {
            // Determines if product should be updated or created
            boolean newProductAlreadyExists = false;
            for(Product element : productList) {
                if (element.getProductId() == newProductId) {
                    newProductAlreadyExists = true;   
                }
            }

            if (newProductAlreadyExists) {
                Inventory.updateProduct(newProduct);
            } else {
                Inventory.addProduct(newProduct);
            }
       
            Parent cancelProductParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene cancelProductScene = new Scene(cancelProductParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(cancelProductScene);
            window.show();
        }
        
        
    }
    
    // Handles cancel button click
    public void cancelButtonHandler(ActionEvent event) throws IOException {
        String buttonClicked = Helpers.throwConfirmationAlert();
        if(buttonClicked.equals("OK")){
            Parent cancelProductParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene cancelProductScene = new Scene(cancelProductParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(cancelProductScene);
            window.show();
        }
    }
    
    // Passes product to product screen upon main screen modify button click
    public void passProductToModify(Product product) {
        this.currentProduct = product;
        ObservableList<Part> tempPartList = null;
        idField.setText(product.getProductId().toString());
        nameField.setText(product.getProductName());
        priceField.setText(String.valueOf(product.getProductPrice()));
        invField.setText(String.valueOf(product.getProductStock()));
        maxField.setText(String.valueOf(product.getProductMax()));
        minField.setText(String.valueOf(product.getProductMin()));
        screenLabel.setText("Modify Product");
        populateBottomTable();
    }
    
    // Enable modify and delete part buttons when part selected in part table
    public void enableAddDeleteButtons() {
        if (topTable.getSelectionModel().getSelectedItem() != null) {
            addButton.setDisable(false);
        }
        if(bottomTable.getSelectionModel().getSelectedItem() != null) {
            deleteButton.setDisable(false);
        }
    }
}
