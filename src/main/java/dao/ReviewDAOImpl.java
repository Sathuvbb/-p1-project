package dao;

import dto.ReviewRequest;
import dto.ReviewResponse;
import Exception.ReviewException;
import utils.ConnectionFactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDao {

    private static final Logger logger = LoggerFactory.getLogger(ReviewDAOImpl.class);

    @Override
    public boolean createReview(ReviewRequest reviewRequest) throws ReviewException {
        String sql = "INSERT INTO Reviews (user_id, product_id, rating, comment, review_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, reviewRequest.getUserId());
            stmt.setInt(2, reviewRequest.getProductId());
            stmt.setInt(3, reviewRequest.getRating());
            stmt.setString(4, reviewRequest.getComment());
            stmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));  // Current timestamp

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Review created successfully for product ID: {}", reviewRequest.getProductId());
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error creating review for product ID: " + reviewRequest.getProductId(), e);
            throw new ReviewException("Error creating review for product ID: " + reviewRequest.getProductId(), e);
        }
        return false;
    }

    @Override
    public ReviewResponse getReviewById(int reviewId) throws ReviewException {
        String sql = "SELECT * FROM Reviews WHERE review_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, reviewId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    logger.info("Review found with id: {}", reviewId);
                    return new ReviewResponse(
                        rs.getInt("review_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getTimestamp("review_date")
                    );
                } else {
                    throw new ReviewException("Review with ID " + reviewId + " not found.");
                }
            }
        } catch (SQLException e) {
            logger.error("Error fetching review with id: " + reviewId, e);
            throw new ReviewException("Error fetching review with id: " + reviewId, e);
        }
    }

    @Override
    public List<ReviewResponse> getReviewsByProductId(int productId) throws ReviewException {
        String sql = "SELECT * FROM Reviews WHERE product_id=?";
        List<ReviewResponse> reviews = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, productId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reviews.add(new ReviewResponse(
                        rs.getInt("review_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getTimestamp("review_date")
                    ));
                }
                logger.info("Fetched reviews for product ID: {}, count: {}", productId, reviews.size());
            }
        } catch (SQLException e) {
            logger.error("Error fetching reviews for product ID: " + productId, e);
            throw new ReviewException("Error fetching reviews for product ID: " + productId, e);
        }
        return reviews;
    }

    @Override
    public List<ReviewResponse> getAllReviewsByUserId(int userId) throws ReviewException {
        String sql = "SELECT * FROM Reviews WHERE user_id=?";
        List<ReviewResponse> reviews = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reviews.add(new ReviewResponse(
                        rs.getInt("review_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("rating"),
                        rs.getString("comment"),
                        rs.getTimestamp("review_date")
                    ));
                }
                logger.info("Fetched reviews for user ID: {}, count: {}", userId, reviews.size());
            }
        } catch (SQLException e) {
            logger.error("Error fetching reviews for user ID: " + userId, e);
            throw new ReviewException("Error fetching reviews for user ID: " + userId, e);
        }
        return reviews;
    }

    @Override
    public boolean updateReviewById(ReviewRequest request) throws ReviewException {
        String sql = "UPDATE Reviews SET rating=?, comment=?, review_date=? WHERE review_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, request.getRating());
            stmt.setString(2, request.getComment());
            stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));  // Current timestamp
            stmt.setInt(4, request.getReviewId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Review updated successfully with id: {}", request.getReviewId());
                return true;
            } else {
                throw new ReviewException("Failed to update review with ID " + request.getReviewId());
            }
        } catch (SQLException e) {
            logger.error("Error updating review with id: " + request.getReviewId(), e);
            throw new ReviewException("Error updating review with id: " + request.getReviewId(), e);
        }
    }

    @Override
    public boolean deleteReviewById(int reviewId) throws ReviewException {
        String sql = "DELETE FROM Reviews WHERE review_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, reviewId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Review deleted successfully with id: {}", reviewId);
                return true;
            } else {
                throw new ReviewException("Failed to delete review with ID " + reviewId);
            }
        } catch (SQLException e) {
            logger.error("Error deleting review with id: " + reviewId, e);
            throw new ReviewException("Error deleting review with id: " + reviewId, e);
        }
    }
}
