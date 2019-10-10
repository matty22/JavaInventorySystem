package View_Controller;

import Model.InhousePart;
import Model.ListOfInhouseParts;
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
    @FXML private TableView<InhousePart> partTableView;
    @FXML private TableColumn<InhousePart, Integer> partIdColumn;
    @FXML private TableColumn<InhousePart, String> partNameColumn;
    @FXML private TableColumn<InhousePart, Integer> partInventoryColumn;
    @FXML private TableColumn<InhousePart, Double> partPriceColumn;
    
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       partIdColumn.setCellValueFactory(new PropertyValueFactory<>("machineId"));
       partNameColumn.setCellValueFactory(new PropertyValueFactory<>("partName"));
       partInventoryColumn.setCellValueFactory(new PropertyValueFactory<>("partStock"));
       partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("partPrice"));
       
       ListOfInhouseParts.parts.add(new InhousePart(1, "Screw", 1.20, 44, 0, 100));
       ListOfInhouseParts.parts.add(new InhousePart(2, "Nail", 0.80, 66, 0, 100));
       ListOfInhouseParts.parts.add(new InhousePart(3, "Washer", 0.15, 12, 0, 100));

                 
       partTableView.setItems(ListOfInhouseParts.parts);
    }   
    
    
    
    
    
    // Main screen parts panel button handlers
    public void partsSearchButtonHandler() {
        // do something
    }
    
    public void partsAddButtonHandler(ActionEvent event) throws IOException {
        Parent inhousePartParent = FXMLLoader.load(getClass().getResource("InhousePart.fxml"));
        Scene inhousePartScene = new Scene(inhousePartParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(inhousePartScene);
        window.show();
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
    public void exitButtonHandler(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    
}
