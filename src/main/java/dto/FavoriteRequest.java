package dto;

	public class FavoriteRequest {
	   
		private int favoriteId; // Included for update scenarios
	    private int userId;
	    private int productId;
	    private FavoriteRequest(int favoriteId, int userId, int productId) {
			super();
			this.favoriteId = favoriteId;
			this.userId = userId;
			this.productId = productId;
		}

	    public FavoriteRequest(int userId2, int productId2) {
			// TODO Auto-generated constructor stub
	    	super();
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
			return "FavoriteRequest [favoriteId=" + favoriteId + ", userId=" + userId + ", productId=" + productId
					+ "]";
		}

}
