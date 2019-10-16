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
    public InhousePart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        setPartID(id);
        setPartName(name);
        setPartPrice(price);
        setPartStock(stock);
        setPartMin(min);
        setPartMax(max);
    }
   
    /**
     * @return the machineId
     */
    public int getMachineId() {
        return machineId.get();
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(int machineId) {
        this.machineId.set(machineId);
    }
    
    
}
