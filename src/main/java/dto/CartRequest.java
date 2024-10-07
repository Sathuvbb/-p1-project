package dto;

public class CartRequest {
    private int cartId;
    private int userId;
    private int productId;
    private int quantity;

    public CartRequest(int cartId, int userId, int productId, int quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public CartRequest(int userId, int productId, int qauntity) {
		// TODO Auto-generated constructor stub
    	 this.userId = userId;
         this.productId = productId;
         this.quantity = quantity;
	}

	public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "CartRequest [cartId=" + cartId + ", userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
    }
}
