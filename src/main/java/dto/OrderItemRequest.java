package dto;

public class OrderItemRequest {
   
	private int orderItemId; // Included for update scenarios
    
	private int orderId;
    private int productId;
    private int quantity;
    private double price;
   
    public OrderItemRequest(int orderItemId, int orderId, int productId, int quantity, double price) {
		// TODO Auto-generated constructor stub
    	super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public OrderItemRequest(int orderItemId, int productId, int quantity, double  price) {
		// TODO Auto-generated constructor stub
		this.orderItemId = orderItemId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
	public String toString() {
		return "OrderItemRequest [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
}
