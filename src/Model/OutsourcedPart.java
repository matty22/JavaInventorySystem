package Model;


public class OutsourcedPart extends Part {
    
    private String companyName;
    
    // Constructor
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
   
    
    
    
    
}
