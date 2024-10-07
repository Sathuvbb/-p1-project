package entity;

public class Seller {
    private int sellerId;
    private String email;
    private String password;
    private String businessName;
    private String businessDetails;

    // Getters and Setters
    public int getSellerId() {
        return sellerId;
    }
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getBusinessDetails() {
        return businessDetails;
    }
    public void setBusinessDetails(String businessDetails) {
        this.businessDetails = businessDetails;
    }
}



