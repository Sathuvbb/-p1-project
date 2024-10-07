package entity;

import java.sql.Timestamp;

public class Review {
    private int reviewId;
    private int userId;
    private int productId;
    private int rating;
    private String comment;
    private Timestamp reviewDate;

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
    public Timestamp getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }
}
