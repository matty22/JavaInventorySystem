package View_Controller;

import Model.InhousePart;
import Model.Inventory;
import Model.Part;
import Model.Product;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class MainController implements Initializable {

    // FXML variables for parts table block
    @FXML private Button searchPartsButton;
    @FXML private Button addPartsButton;
    @FXML private Button modifyPartsButton;
    @FXML private Button deletePartsButton;
    @FXML private TextField searchPartsField;
    @FXML private TableView<Part> partTableView;
    @FXML private TableColumn<Part, Integer> partIdColumn;
    @FXML private TableColumn<Part, String> partNameColumn;
    @FXML private TableColumn<Part, Integer> partInventoryColumn;
    @FXML private TableColumn<Part, Double> partPriceColumn;
    
    // FXML variables for products table block
    @FXML private Button searchProductsButton;
    @FXML private Button addProductsButton;
    @FXML private Button modifyProductsButton;
    @FXML private Button deleteProductsButton;
    @FXML private TextField searchProductsField;
    @FXML private TableView<Product> productTableView;
    @FXML private TableColumn<Product, Integer> productIdColumn;
    @FXML private TableColumn<Product, String> productNameColumn;
    @FXML private TableColumn<Product, Integer> productInventoryColumn;
    @FXML private TableColumn<Product, Double> productPriceColumn;
    
    // FXML variables for screen
    @FXML private Button exitButton;
    static boolean entered;
    static boolean initialized = false;
    
    // Initialize the controller
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // Bind part table columns
       partIdColumn.setCellValueFactory(new PropertyValueFactory<>("partID"));
       partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
       partInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
       partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
       
       // Bind product table columns
       productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
       productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
       productInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("productStock"));
       productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("productPrice"));
       
       // Set up dummy part data upon application first loading
       if(!initialized) {
        Inventory.addPart(new InhousePart(1, "Screw", 1.20, 44, 0, 100));
        Inventory.addPart(new InhousePart(2, "Nail", 0.80, 66, 0, 100));
        Inventory.addPart(new InhousePart(3, "Washer", 0.15, 12, 0, 100));
        
        Inventory.addProduct(new Product(99, "Gizmo", 4.5, 99, 0, 100, null));
        Inventory.addProduct(new Product(98, "Widget", 4.0, 72, 0, 100, null));
        Inventory.addProduct(new Product(97, "Thingamajig", 3.9, 34, 0, 100, null));
        
        initialized = true;
       }
       partTableView.setItems(Inventory.getAllParts());
       productTableView.setItems(Inventory.getAllProducts());
    }   
    
    
    // Handles part search button click
    public void partsSearchButtonHandler(ActionEvent event) {
        Part foundPart = Inventory.lookupPart(searchPartsField.getText());
        partTableView.getSelectionModel().select(foundPart);
    }
    
    // Handles add part button click
    public void partsAddButtonHandler(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("InhousePart.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    // Handles modify part button click
    public void partsModifyButtonHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) modifyPartsButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("InhousePart.fxml"));
        
        root = loader.load();
        InhousePartController controller = loader.getController();
        Part part = partTableView.getSelectionModel().getSelectedItem();
        if(part != null) {
            controller.passPartToModify(part);
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    // Handles part delete button click
    public void partsDeleteButtonHandler() {
        Part partToDelete = partTableView.getSelectionModel().getSelectedItem();
        Inventory.deletePart(partToDelete);
    }
    
    
    // Handles product search button click
    public void productsSearchButtonHandler() {
        Product foundProduct = Inventory.lookupProduct(searchProductsField.getText());
        productTableView.getSelectionModel().select(foundProduct);
    }
    
    // Handles page change on add product button click
    public void productsAddButtonHandler(ActionEvent event) throws IOException {
        Parent addProductParent = FXMLLoader.load(getClass().getResource("Product.fxml"));
        Scene inhousePartScene = new Scene(addProductParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(inhousePartScene);
        window.show();
    }
    
    // Handles page change on modify product button click
    public void productsModifyButtonHandler(ActionEvent event) throws IOException {
        Parent root;
        Stage stage = (Stage) modifyProductsButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Product.fxml"));
        
        root = loader.load();
        ProductController controller = loader.getController();
        Product product = productTableView.getSelectionModel().getSelectedItem();
        if(product != null) {
            controller.passProductToModify(product);
        }
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    // Handles product delete button click
    public void productsDeleteButtonHandler() {
        Product productToDelete = productTableView.getSelectionModel().getSelectedItem();
        Inventory.deleteProduct(productToDelete);
    }
    
    // Handles exit button click
    public void exitButtonHandler(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
}
