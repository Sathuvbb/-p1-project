package dto;


import java.security.Timestamp;
import java.sql.Date;

public class PaymentResponse {

		private int paymentId;
		private int orderId;
	    private double amount;
	    private String paymentMethod;
	    private String status;
	    private java.sql.Timestamp paymentDate;

	 
	

		public PaymentResponse(int paymentId, int orderId, java.sql.Timestamp  paymentDate, double amount, String paymentMethod,
				String status) {
			// TODO Auto-generated constructor stub
			// TODO Auto-generated constructor stub
	    	super();
			this.paymentId = paymentId;
			this.orderId = orderId;
			this.paymentDate = paymentDate;
			this.amount = amount;
			this.paymentMethod = paymentMethod;
			this.status = status;
		}





		// Getters and Setters
	    public int getPaymentId() {
	        return paymentId;
	    }
	    public void setPaymentId(int paymentId) {
	        this.paymentId = paymentId;
	    }
	    public int getOrderId() {
	        return orderId;
	    }
	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }
	    public double getAmount() {
	        return amount;
	    }
	    public void setAmount(double amount) {
	        this.amount = amount;
	    }
	    public String getPaymentMethod() {
	        return paymentMethod;
	    }
	    public void setPaymentMethod(String paymentMethod) {
	        this.paymentMethod = paymentMethod;
	    }
	    public String getStatus() {
	        return status;
	    }
	    public void setStatus(String status) {
	        this.status = status;
	    }
	    public java.sql.Timestamp getpaymentDate() {
	        return paymentDate;
	    }
	    public void setOrderDate(java.sql.Timestamp orderDate) {
	        this.paymentDate = orderDate;
	    }
	    @Override
		public String toString() {
			return "PaymentResponse [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
					+ ", paymentMethod=" + paymentMethod + ", status=" + status + ", paymentDate=" + paymentDate + "]";
		}

}
