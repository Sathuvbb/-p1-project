package dto;

import java.security.Timestamp;

public class ReviewRequest {
		private int reviewId; // Included for update scenarios
		private int userId;
	    private int productId;
	    private int rating;
	    private String comment;
	    private Timestamp reviewDate;
	    // Getters and Setters
	    public ReviewRequest(int userId,int productId, int rating, String comment, java.sql.Timestamp timestamp) {
			super();
			
			this.userId = userId;
			this.productId = productId;
			this.rating = rating;
			this.comment = comment;
			this.reviewDate = reviewDate;
		}
	    
		

		public ReviewRequest(int rating, String comment, java.sql.Timestamp timestamp,int reviewId) {
			// TODO Auto-generated constructor stub
			super();
			this.rating = rating;
			this.comment = comment;
			this.reviewDate = reviewDate;
			this.reviewId = reviewId;
		}



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
	    }  public Timestamp getReviewDate() {
	        return reviewDate;
	    }
	    public Timestamp getOrderDate() {
	        return reviewDate;
	    }
	    public void setReviewDate(Timestamp reviewDate) {
	        this.reviewDate = reviewDate;
	    }

	
@Override
		public String toString() {
			return "ReviewRequest [reviewId=" + reviewId + ", userId=" + userId + ", productId=" + productId
					+ ", rating=" + rating + ", comment=" + comment + ", reviewDate=" + reviewDate + "]";
		}


}
