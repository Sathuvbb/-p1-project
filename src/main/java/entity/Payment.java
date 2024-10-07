
	package entity;

	
	import java.sql.Timestamp;

	public class Payment {
	    private int paymentId;
	    private int orderId;
	    private Timestamp paymentDate;
	    private Double amount;
	    private String paymentMethod;
	    private String paymentStatus;

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

	    public Timestamp getPaymentDate() {
	        return paymentDate;
	    }

	    public void setPaymentDate(Timestamp paymentDate) {
	        this.paymentDate = paymentDate;
	    }

	    public Double getAmount() {
	        return amount;
	    }

	    public void setAmount(Double amount) {
	        this.amount = amount;
	    }

	    public String getPaymentMethod() {
	        return paymentMethod;
	    }

	    public void setPaymentMethod(String paymentMethod) {
	        this.paymentMethod = paymentMethod;
	    }

	    public String getPaymentStatus() {
	        return paymentStatus;
	    }

	    public void setPaymentStatus(String paymentStatus) {
	        this.paymentStatus = paymentStatus;
	    }


}
