package Service;

import dao.ReviewDao;
import dao.ReviewDAOImpl;
import dto.ReviewRequest;
import dto.ReviewResponse;

import java.sql.Timestamp;
import java.util.List;

public class ReviewService {

    private final ReviewDao reviewDao;

    public ReviewService() {
        this.reviewDao = new ReviewDAOImpl();
    }

    public boolean createReview(ReviewRequest reviewRequest) {
        try {
            boolean result = reviewDao.createReview(reviewRequest);
            System.out.println("Create review operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating review: " + e.getMessage());
            return false;
        }
    }

    public ReviewResponse getReviewById(int reviewId) {
        try {
            ReviewResponse review = reviewDao.getReviewById(reviewId);
            if (review != null) {
                System.out.println("Fetched review by ID: " + reviewId);
            } else {
                System.out.println("No review found with ID: " + reviewId);
            }
            return review;
        } catch (Exception e) {
            System.out.println("Error fetching review by ID: " + e.getMessage());
            return null;
        }
    }

    public List<ReviewResponse> getReviewsByProductId(int productId) {
        try {
            List<ReviewResponse> reviews = reviewDao.getReviewsByProductId(productId);
            if (!reviews.isEmpty()) {
                System.out.println("Fetched reviews for product ID: " + productId);
            } else {
                System.out.println("No reviews found for product ID: " + productId);
            }
            return reviews;
        } catch (Exception e) {
            System.out.println("Error fetching reviews for product ID: " + e.getMessage());
            return null;
        }
    }

    public List<ReviewResponse> getAllReviewsByUserId(int userId) {
        try {
            List<ReviewResponse> reviews = reviewDao.getAllReviewsByUserId(userId);
            if (!reviews.isEmpty()) {
                System.out.println("Fetched reviews for user ID: " + userId);
            } else {
                System.out.println("No reviews found for user ID: " + userId);
            }
            return reviews;
        } catch (Exception e) {
            System.out.println("Error fetching reviews for user ID: " + e.getMessage());
            return null;
        }
    }

    public boolean updateReviewById(ReviewRequest reviewRequest) {
        try {
            boolean result = reviewDao.updateReviewById(reviewRequest);
            System.out.println("Update review operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating review: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteReviewById(int reviewId) {
        try {
            boolean result = reviewDao.deleteReviewById(reviewId);
            System.out.println("Delete review operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting review: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        ReviewService service = new ReviewService();

        // Create a new review
        ReviewRequest newReview = new ReviewRequest( 2,2, 2, "Great product!",new Timestamp(System.currentTimeMillis()));
        boolean isCreated = service.createReview(newReview);
        System.out.println("Review creation status: " + isCreated);

        // Fetch a review by ID
        ReviewResponse review = service.getReviewById(2);
        if (review != null) {
            System.out.println("Review found: " + review);
        } else {
            System.out.println("Review with ID 1 not found.");
        }

        // Update a review
        ReviewRequest reviewUpdate = new ReviewRequest( 4, "Good product, but could be improved",new Timestamp(System.currentTimeMillis()),2);
        boolean isUpdated = service.updateReviewById(reviewUpdate);
        System.out.println("Review update status: " + isUpdated);

        // Delete a review by ID
        boolean isDeleted = service.deleteReviewById(1);
        System.out.println("Review deletion status: " + isDeleted);
    }
}
