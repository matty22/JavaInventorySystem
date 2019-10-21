package Model;

public class OutsourcedPart extends Part {
    
    private int id;
    private String name;
    private int stock;
    private double price;
    private int min;
    private int max;
    private String companyName;
    
    // Constructor
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max, String company) {
        super(id, name, price, stock, min, max);
    }

    // Get the outsourced part company name
    public String getCompanyName() {
        return companyName;
    }

    // Set the outsourced part company name
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
   
    
    
    
    
}
