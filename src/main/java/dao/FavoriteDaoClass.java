package dao;

import dto.FavoriteRequest;
import dto.FavoriteResponse;
import Exception.FavoriteDaoException;
import utils.ConnectionFactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDaoClass implements FavoriteDao {

    private static final Logger logger = LoggerFactory.getLogger(FavoriteDaoClass.class);

    @Override
    public boolean addFavorite(FavoriteRequest request) throws FavoriteDaoException {
        String sql = "INSERT INTO Favorites (user_id, product_id) VALUES (?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, request.getUserId());
            stmt.setInt(2, request.getProductId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Favorite added successfully for user ID: {} and product ID: {}", request.getUserId(), request.getProductId());
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error adding favorite for user ID: " + request.getUserId() + " and product ID: " + request.getProductId(), e);
            throw new FavoriteDaoException("Error adding favorite for user ID: " + request.getUserId() + " and product ID: " + request.getProductId(), e);
        }
        return false;
    }

    @Override
    public boolean removeFavorite(int favoriteId) throws FavoriteDaoException {
        String sql = "DELETE FROM Favorites WHERE favorite_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, favoriteId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Favorite removed successfully with favorite ID: {}", favoriteId);
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error removing favorite with favorite ID: " + favoriteId, e);
            throw new FavoriteDaoException("Error removing favorite with favorite ID: " + favoriteId, e);
        }
        return false;
    }

    @Override
    public List<FavoriteResponse> getFavoritesByUserId(int userId) throws FavoriteDaoException {
        String sql = "SELECT * FROM Favorites WHERE user_id=?";
        List<FavoriteResponse> favorites = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    favorites.add(new FavoriteResponse(
                        rs.getInt("favorite_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id")
                    ));
                }
                logger.info("Fetched favorites for user ID: {}, count: {}", userId, favorites.size());
            }
        } catch (SQLException e) {
            logger.error("Error fetching favorites for user ID: " + userId, e);
            throw new FavoriteDaoException("Error fetching favorites for user ID: " + userId, e);
        }
        return favorites;
    }

    @Override
    public boolean isFavorite(int userId, int productId) throws FavoriteDaoException {
        String sql = "SELECT COUNT(*) FROM Favorites WHERE user_id=? AND product_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, productId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && rs.getInt(1) > 0) {
                    logger.info("Product ID: {} is a favorite for user ID: {}", productId, userId);
                    return true;
                }
            }
        } catch (SQLException e) {
            logger.error("Error checking if product ID: " + productId + " is a favorite for user ID: " + userId, e);
            throw new FavoriteDaoException("Error checking if product ID: " + productId + " is a favorite for user ID: " + userId, e);
        }
        return false;
    }
}
