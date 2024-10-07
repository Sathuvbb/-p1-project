package Service;

import dao.FavoriteDao;
import dao.FavoriteDaoClass;
import dto.FavoriteRequest;
import dto.FavoriteResponse;

import java.util.List;

public class FavoriteService {

    private final FavoriteDao favoriteDao;

    public FavoriteService() {
        this.favoriteDao = new FavoriteDaoClass();
    }

    public boolean addFavorite(int userId, int productId) {
        try {
            FavoriteRequest request = new FavoriteRequest(userId, productId);
            if (!favoriteDao.isFavorite(userId, productId)) {
                boolean isAdded = favoriteDao.addFavorite(request);
                if (isAdded) {
                    System.out.println("Successfully added product " + productId + " to favorites for user " + userId);
                    return true;
                } else {
                    System.out.println("Failed to add product " + productId + " to favorites for user " + userId);
                    return false;
                }
            } else {
                System.out.println("Product " + productId + " is already a favorite for user " + userId);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error adding product " + productId + " to favorites for user " + userId + ": " + e.getMessage());
            return false;
        }
    }

    public boolean removeFavorite(int favoriteId) {
        try {
            boolean isRemoved = favoriteDao.removeFavorite(favoriteId);
            if (isRemoved) {
                System.out.println("Successfully removed favorite with ID " + favoriteId);
                return true;
            } else {
                System.out.println("Failed to remove favorite with ID " + favoriteId);
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error removing favorite with ID " + favoriteId + ": " + e.getMessage());
            return false;
        }
    }

    public List<FavoriteResponse> getFavoritesByUserId(int userId) {
        try {
            List<FavoriteResponse> favorites = favoriteDao.getFavoritesByUserId(userId);
            if (!favorites.isEmpty()) {
                System.out.println("Successfully fetched " + favorites.size() + " favorites for user " + userId);
            } else {
                System.out.println("No favorites found for user " + userId);
            }
            return favorites;
        } catch (Exception e) {
            System.out.println("Error fetching favorites for user " + userId + ": " + e.getMessage());
            return null;
        }
    }

    public boolean isFavorite(int userId, int productId) {
        try {
            boolean result = favoriteDao.isFavorite(userId, productId);
            System.out.println("Check if product " + productId + " is a favorite for user " + userId + ": " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error checking if product " + productId + " is a favorite for user " + userId + ": " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        FavoriteService favoriteService = new FavoriteService();

        // Add a product to favorites
        boolean isAdded = favoriteService.addFavorite(3, 2);
        System.out.println("Favorite added: " + isAdded);

        // Check if a product is a favorite
        boolean isFavorite = favoriteService.isFavorite(1, 1);
        System.out.println("Is favorite: " + isFavorite);

        // Get all favorites for a user
        List<FavoriteResponse> favorites = favoriteService.getFavoritesByUserId(1);
        System.out.println("Favorites for user 1: " + favorites);

        // Remove a favorite
        boolean isRemoved = favoriteService.removeFavorite(0);
        System.out.println("Favorite removed: " + isRemoved);
    }
}
