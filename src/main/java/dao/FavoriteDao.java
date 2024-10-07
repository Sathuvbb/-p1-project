package dao;

import dto.FavoriteRequest;
import dto.FavoriteResponse;
import Exception.FavoriteDaoException;
import java.util.List;

public interface FavoriteDao {

    // Method to add a product to the user's favorites
    boolean addFavorite(FavoriteRequest request) throws FavoriteDaoException;

    // Method to remove a product from the user's favorites
    boolean removeFavorite(int favoriteId) throws FavoriteDaoException;

    // Method to retrieve all favorite products for a specific user
    List<FavoriteResponse> getFavoritesByUserId(int userId) throws FavoriteDaoException;

    // Method to check if a product is already in the user's favorites
    boolean isFavorite(int userId, int productId) throws FavoriteDaoException;
}
