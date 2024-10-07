package dao;

import dto.ReviewRequest;
import dto.ReviewResponse;
import Exception.ReviewException;
import java.util.List;

public interface ReviewDao {
    boolean createReview(ReviewRequest request) throws ReviewException;
    ReviewResponse getReviewById(int reviewId) throws ReviewException;
    List<ReviewResponse> getReviewsByProductId(int productId) throws ReviewException;
    List<ReviewResponse> getAllReviewsByUserId(int userId) throws ReviewException;
    boolean updateReviewById(ReviewRequest request) throws ReviewException;
    boolean deleteReviewById(int reviewId) throws ReviewException;
}
