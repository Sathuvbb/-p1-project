package dto;

public class FavoriteResponse {
  
	private int favoriteId;
	private int userId;
    private int productId;
    public FavoriteResponse(int favoriteId, int userId, int productId) {
  		super();
  		this.favoriteId = favoriteId;
  		this.userId = userId;
  		this.productId = productId;
  	}
    // Getters and Setters
    public int getFavoriteId() {
        return favoriteId;
    }
    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
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
    @Override
	public String toString() {
		return "FavoriteResponse [favoriteId=" + favoriteId + ", userId=" + userId + ", productId=" + productId + "]";
    }
}
