package dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class OrderResponse {
   
	private int orderId;
	private int userId;
    private BigDecimal totalAmount;
    private Timestamp orderDate;
    private String shippingAddress;
    private String billingAddress;
    private String status;
    public OrderResponse(int orderId, int userId, BigDecimal bigDecimal, Timestamp orderDate, String shippingAddress,
			String billingAddress, String status) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = bigDecimal;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.status = status;
	}

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    public Timestamp getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }
    public String getShippingAddress() {
        return shippingAddress;
    }
    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    public String getBillingAddress() {
        return billingAddress;
    }
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Override
   	public String toString() {
   		return "OrderResponse [orderId=" + orderId + ", userId=" + userId + ", totalAmount=" + totalAmount
   				+ ", orderDate=" + orderDate + ", shippingAddress=" + shippingAddress + ", billingAddress="
   				+ billingAddress + ", status=" + status + "]";
   	}
}

