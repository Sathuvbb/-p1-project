package dao;

import dto.CartRequest;
import dto.CartResponse;
import utils.ConnectionFactor;
import Exception.CartDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartDaoClass implements CartDao {

    private static final Logger logger = Logger.getLogger(CartDaoClass.class.getName());

    @Override
    public boolean addCart(CartRequest cartRequest) throws CartDaoException {
        String sql = "INSERT INTO Carts (user_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartRequest.getUserId());
            pstmt.setInt(2, cartRequest.getProductId());
            pstmt.setInt(3, cartRequest.getQuantity());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Added to cart: user_id=" + cartRequest.getUserId() +
                        ", product_id=" + cartRequest.getProductId() +
                        ", quantity=" + cartRequest.getQuantity());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding to cart: " + e.getMessage(), e);
            throw new CartDaoException("Error adding to cart for user_id=" + cartRequest.getUserId(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during adding to cart", e);
            throw new CartDaoException("Unexpected error during adding to cart", e);
        }
    }

    @Override
    public CartResponse getCartById(int id) throws CartDaoException {
        String sql = "SELECT * FROM Carts WHERE cart_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new CartResponse(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching cart by ID: " + id, e);
            throw new CartDaoException("Error fetching cart by ID: " + id, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching cart by ID", e);
            throw new CartDaoException("Unexpected error during fetching cart by ID", e);
        }
        return null;
    }

    @Override
    public boolean updateCart(CartRequest cartRequest) throws CartDaoException {
        String sql = "UPDATE Carts SET user_id = ?, product_id = ?, quantity = ? WHERE cart_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cartRequest.getUserId());
            pstmt.setInt(2, cartRequest.getProductId());
            pstmt.setInt(3, cartRequest.getQuantity());
            pstmt.setInt(4, cartRequest.getCartId());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Updated cart with ID: " + cartRequest.getCartId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating cart: " + e.getMessage(), e);
            throw new CartDaoException("Error updating cart with ID: " + cartRequest.getCartId(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during cart update", e);
            throw new CartDaoException("Unexpected error during cart update", e);
        }
    }

    @Override
    public boolean deleteCartById(int id) throws CartDaoException {
        String sql = "DELETE FROM Carts WHERE cart_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Deleted cart with ID: " + id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting cart: " + e.getMessage(), e);
            throw new CartDaoException("Error deleting cart with ID: " + id, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during cart deletion", e);
            throw new CartDaoException("Unexpected error during cart deletion", e);
        }
    }

    @Override
    public List<CartResponse> getAllCarts() throws CartDaoException {
        List<CartResponse> carts = new ArrayList<>();
        String sql = "SELECT * FROM Carts";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                carts.add(new CartResponse(
                    rs.getInt("cart_id"),
                    rs.getInt("user_id"),
                    rs.getInt("product_id"),
                    rs.getInt("quantity")
                ));
            }
            logger.info("Fetched all carts.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all carts: " + e.getMessage(), e);
            throw new CartDaoException("Error fetching all carts", e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching all carts", e);
            throw new CartDaoException("Unexpected error during fetching all carts", e);
        }
        return carts;
    }

    @Override
    public void addToCart(Integer userId, int productId) throws CartDaoException {
        // Check if the item already exists in the cart for this user
        String checkSql = "SELECT * FROM Carts WHERE user_id = ? AND product_id = ?";
        String insertSql = "INSERT INTO Carts (user_id, product_id, quantity) VALUES (?, ?, ?)";
        String updateSql = "UPDATE Carts SET quantity = quantity + ? WHERE user_id = ? AND product_id = ?";
        
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
            checkStmt.setInt(1, userId);
            checkStmt.setInt(2, productId);
            try (ResultSet rs = checkStmt.executeQuery()) {
                if (rs.next()) {
                    // Item already exists, update quantity
                    try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
                        updateStmt.setInt(1, 1); // Increment quantity by 1
                        updateStmt.setInt(2, userId);
                        updateStmt.setInt(3, productId);
                        updateStmt.executeUpdate();
                        logger.info("Updated cart for user_id=" + userId + ", product_id=" + productId);
                    }
                } else {
                    // Item does not exist, insert new entry
                    try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
                        insertStmt.setInt(1, userId);
                        insertStmt.setInt(2, productId);
                        insertStmt.setInt(3, 1); // Set quantity to 1
                        insertStmt.executeUpdate();
                        logger.info("Inserted into cart: user_id=" + userId + ", product_id=" + productId);
                    }
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error adding to cart: " + e.getMessage(), e);
            throw new CartDaoException("Error adding to cart for user_id=" + userId + ", product_id=" + productId, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during adding to cart", e);
            throw new CartDaoException("Unexpected error during adding to cart", e);
        }
    }

    @Override
    public void addToCart(int userId, int productId, int quantity) throws CartDaoException {
        // Check if the item already exists in the cart for this user
        CartResponse existingCart = getCartByProductAndUser(userId, productId);

        if (existingCart != null) {
            // Item already exists, update quantity
            CartRequest cartRequest = new CartRequest(existingCart.getCartId(), userId, productId, existingCart.getQuantity() + quantity);
            updateCart(cartRequest);
        } else {
            // Item does not exist, insert new entry
            CartRequest cartRequest = new CartRequest(0, userId, productId, quantity); // cartId will be auto-generated
            addCart(cartRequest);
        }
    }

    private CartResponse getCartByProductAndUser(int userId, int productId) throws CartDaoException {
        String sql = "SELECT * FROM Carts WHERE user_id = ? AND product_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new CartResponse(
                        rs.getInt("cart_id"),
                        rs.getInt("user_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching cart by user_id and product_id: " + e.getMessage(), e);
            throw new CartDaoException("Error fetching cart by user_id=" + userId + " and product_id=" + productId, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching cart by user_id and product_id", e);
            throw new CartDaoException("Unexpected error during fetching cart by user_id=" + userId + " and product_id=" + productId, e);
        }
        return null;
    }

}