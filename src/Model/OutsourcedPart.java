package Model;

import javafx.beans.property.SimpleStringProperty;

public class OutsourcedPart extends Part {
    
    
    private SimpleStringProperty companyName = new SimpleStringProperty("");
    
    // Constructor
    public OutsourcedPart(int id, String name, double price, int stock, int min, int max, String company) {
        super(id, name, price, stock, min, max);
        setPartID(id);
        setPartName(name);
        setPartPrice(price);
        setPartStock(stock);
        setPartMin(min);
        setPartMax(max);
        setCompanyName(company);
    }

    
    // Overriding toString method for testing purposes
    @Override
    public String toString() {
        String string = "name: " + getPartName() + " | company: " + companyName;
        return string;
    }
    
    // Get the outsourced part company name
    public String getCompanyName() {
        return companyName.get();
    }

    // Set the outsourced part company name
    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
    
   
    
    
    
    
}
