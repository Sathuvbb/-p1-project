package dto;


public class SellerResponse {
	
	private int sellerId; // Included for update scenarios
		private String email;
	    private String password;
	    private String businessName;
	    private String businessDetails;
	    public SellerResponse(int sellerId, String email, String password, String businessName, String businessDetails) {
			super();
			this.sellerId = sellerId;
			this.email = email;
			this.password = password;
			this.businessName = businessName;
			this.businessDetails = businessDetails;
		}
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
		@Override
		public String toString() {
			return "SellerResponse [sellerId=" + sellerId + ", email=" + email + ", password=" + password
					+ ", businessName=" + businessName + ", businessDetails=" + businessDetails + "]";
		}
}