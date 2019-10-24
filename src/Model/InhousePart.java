package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


public class InhousePart extends Part {
    private SimpleIntegerProperty machineId = new SimpleIntegerProperty(0);
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleIntegerProperty stock = new SimpleIntegerProperty(0);
    private SimpleDoubleProperty price = new SimpleDoubleProperty(0.0);
    private SimpleIntegerProperty min = new SimpleIntegerProperty(0);
    private SimpleIntegerProperty max = new SimpleIntegerProperty(0);
  
    // Constructor
    public InhousePart(int id, String name, double price, int stock, int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        setPartID(id);
        setPartName(name);
        setPartPrice(price);
        setPartStock(stock);
        setPartMin(min);
        setPartMax(max);
        setMachineId(machineId);
        setPartType("Inhouse");
    }
    
    // Get the inhouse part machine id
    public Integer getMachineId() {
        return machineId.get();
    }

    // Set the inhouse part machine id
    public void setMachineId(int machineId) {
        this.machineId.set(machineId);
    }
    
    
}
