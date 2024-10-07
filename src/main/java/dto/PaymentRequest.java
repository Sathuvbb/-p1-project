package dto;

import java.sql.Timestamp;

public class PaymentRequest {
  
	private int paymentId; // Included for update scenarios
	private int orderId;
    private double amount;
    private String paymentMethod;
    private String status;
    private Timestamp paymentDate;
  public PaymentRequest( int orderId, double amount, String paymentMethod, String status,
			Timestamp paymentDate) {
		super();
		this.paymentId = paymentId;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paymentDate=paymentDate;
	}
 
	public PaymentRequest(double amount,String paymentMethod, String status,int paymentId) {
		// TODO Auto-generated constructor stub
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.paymentId = paymentId;
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
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	  @Override
		public String toString() {
			return "PaymentRequest [paymentId=" + paymentId + ", orderId=" + orderId + ", amount=" + amount
					+ ", paymentMethod=" + paymentMethod + ", status=" + status + ", paymentDate=" + paymentDate + "]";
		}
}
