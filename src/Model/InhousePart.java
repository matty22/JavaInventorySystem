package Model;


public class InhousePart extends Part {
    private int machineId;
    private String name;
    private int stock;
    private double price;
    private int min;
    private int max;
  
    // Constructor
    public InhousePart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
        this.machineId = id;
    }
   
    /**
     * @return the machineId
     */
    public int getMachineId() {
        return machineId;
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    
    
    
}
