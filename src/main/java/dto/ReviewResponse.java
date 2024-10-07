package dto;

import java.security.Timestamp;

public class ReviewResponse {
	
	
		private int reviewId;
	    private int userId;
	    private int productId;
	    private int rating;
	    private String comment;
	    private java.sql.Timestamp reviewDate;
	

	
		
		public ReviewResponse(int reviewId, int userId, int productId, int rating, String comment, java.sql.Timestamp reviewDate) {
			// TODO Auto-generated constructor stub
			super();
			this.reviewId = reviewId;
			this.userId = userId;
			this.productId = productId;
			this.rating = rating;
			this.comment = comment;
			this.reviewDate = reviewDate;
		}
		// Getters and Setters
	    public int getReviewId() {
	        return reviewId;
	    }
	    public void setReviewId(int reviewId) {
	        this.reviewId = reviewId;
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
	    public int getRating() {
	        return rating;
	    }
	    public void setRating(int rating) {
	        this.rating = rating;
	    }
	    public String getComment() {
	        return comment;
	    }
	    public void setComment(String comment) {
	        this.comment = comment;
	    }
	    public java.sql.Timestamp getReviewDate() {
	        return reviewDate;
	    }
	    public void setReviewDate(java.sql.Timestamp reviewDate) {
	        this.reviewDate = reviewDate;
	    }
		@Override
		public String toString() {
			return "ReviewResponse [reviewId=" + reviewId + ", userId=" + userId + ", productId=" + productId + ", rating="
					+ rating + ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
		}

}
