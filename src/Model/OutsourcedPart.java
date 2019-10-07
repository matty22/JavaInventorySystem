package Model;


public class OutsourcedPart extends Part {
    
    private String companyName;
    
    // Constructor
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }
    
    // Setter
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    // Getter
    public String getCompanyName() {
        return this.companyName;
    }
    
    
    
    
}
