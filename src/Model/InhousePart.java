package Model;


public class InhousePart extends Part {
    private int machineId;
  
    // Constructor
    public InhousePart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }
    
    // Setter
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    
    // Getter
    public int getMachineId() {
        return this.machineId;
    }
    
}
