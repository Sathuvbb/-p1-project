package dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderRequest {
    private int orderId;
    private int userId;
    private Double totalAmount;
    private Timestamp orderDate;
    private String shippingAddress;
    private String billingAddress;
    private String status;

    // Constructor
    public OrderRequest(Double totalAmount, Timestamp orderDate, String shippingAddress, String billingAddress, String status) {
    
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = status;
    }
 // Constructor
    public OrderRequest(int orderId, int userId, Double totalAmount, Timestamp orderDate, String shippingAddress, String billingAddress, String status) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
        this.status = status;
    }

	// Getters and setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }

    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public String getBillingAddress() { return billingAddress; }
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


	    
		@Override
		public String toString() {
			return "OrderRequest [orderId=" + orderId + ", userId=" + userId + ", totalAmount=" + totalAmount
					+ ", shippingAddress=" + shippingAddress + ", orderDate=" + orderDate + ", billingAddress="
					+ billingAddress + ", status=" + status + "]";
		}
}
