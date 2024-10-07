package entity;
public class Favorite {
	private int favoriteId;
	private int userId;
    private int productId;
    
private Favorite(int favoriteId, int userId, int productId) {
		super();
		this.favoriteId = favoriteId;
		this.userId = userId;
		this.productId = productId;
	}
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
}