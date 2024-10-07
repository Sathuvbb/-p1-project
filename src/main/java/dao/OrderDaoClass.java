package dao;

import dto.OrderRequest;
import dto.OrderResponse;
import Exception.OrderDaoException;
import utils.ConnectionFactor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderDaoClass implements OrderDao {

    private static final Logger logger = Logger.getLogger(OrderDaoClass.class.getName());

    @Override
    public boolean createOrder(OrderRequest orderRequest) throws OrderDaoException {
        String sql = "INSERT INTO Orders (user_id, total_amount, order_date, shipping_address, billing_address, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderRequest.getUserId());
            pstmt.setDouble(2, orderRequest.getTotalAmount());
            pstmt.setTimestamp(3, orderRequest.getOrderDate());
            pstmt.setString(4, orderRequest.getShippingAddress());
            pstmt.setString(5, orderRequest.getBillingAddress());
            pstmt.setString(6, orderRequest.getStatus());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Created order with user ID: " + orderRequest.getUserId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error creating order: " + e.getMessage(), e);
            throw new OrderDaoException("Error creating order: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during order creation", e);
            throw new OrderDaoException("Unexpected error during order creation", e);
        }
    }

    @Override
    public OrderResponse getOrderById(int id) throws OrderDaoException {
        String sql = "SELECT * FROM Orders WHERE order_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderResponse(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getBigDecimal("total_amount"),
                        rs.getTimestamp("order_date"),
                        rs.getString("shipping_address"),
                        rs.getString("billing_address"),
                        rs.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching order by ID: " + id, e);
            throw new OrderDaoException("Error fetching order by ID: " + id, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching order by ID", e);
            throw new OrderDaoException("Unexpected error during fetching order by ID", e);
        }
        return null;  // or throw a custom exception if order not found
    }

    @Override
    public List<OrderResponse> getOrdersByBuyerId(int buyerId) throws OrderDaoException {
        List<OrderResponse> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders WHERE user_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, buyerId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderResponse(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getBigDecimal("total_amount"),
                        rs.getTimestamp("order_date"),
                        rs.getString("shipping_address"),
                        rs.getString("billing_address"),
                        rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching orders by buyer ID: " + buyerId, e);
            throw new OrderDaoException("Error fetching orders by buyer ID: " + buyerId, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching orders by buyer ID", e);
            throw new OrderDaoException("Unexpected error during fetching orders by buyer ID", e);
        }
        return orders;
    }

    // Other methods will follow the same pattern of throwing OrderDaoException

    @Override
    public List<OrderResponse> getOrdersByProductId(int productId) throws OrderDaoException {
        List<OrderResponse> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders o JOIN OrderItems oi ON o.order_id = oi.order_id WHERE oi.product_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderResponse(
                        rs.getInt("order_id"),
                        rs.getInt("user_id"),
                        rs.getBigDecimal("total_amount"),
                        rs.getTimestamp("order_date"),
                        rs.getString("shipping_address"),
                        rs.getString("billing_address"),
                        rs.getString("status")
                    ));
                }
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching orders by product ID: " + productId, e);
            throw new OrderDaoException("Error fetching orders by product ID: " + productId, e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching orders by product ID", e);
            throw new OrderDaoException("Unexpected error during fetching orders by product ID", e);
        }
        return orders;
    }
    @Override
    public boolean updateOrder(OrderRequest orderRequest) throws OrderDaoException {
        String sql = "UPDATE Orders SET user_id = ?, total_amount = ?, order_date = ?, shipping_address = ?, billing_address = ?, status = ? WHERE order_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderRequest.getUserId());
            pstmt.setDouble(2, orderRequest.getTotalAmount());
            pstmt.setTimestamp(3, orderRequest.getOrderDate());
            pstmt.setString(4, orderRequest.getShippingAddress());
            pstmt.setString(5, orderRequest.getBillingAddress());
            pstmt.setString(6, orderRequest.getStatus());
            pstmt.setInt(7, orderRequest.getOrderId());
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Updated order with ID: " + orderRequest.getOrderId());
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error updating order: " + e.getMessage(), e);
            throw new OrderDaoException("Error updating order: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during order update", e);
            throw new OrderDaoException("Unexpected error during order update", e);
        }
    }

    @Override
    public boolean deleteOrderById(int id) throws OrderDaoException {
        String sql = "DELETE FROM Orders WHERE order_id = ?";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            logger.info("Deleted order with ID: " + id);
            return rowsAffected > 0;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error deleting order: " + e.getMessage(), e);
            throw new OrderDaoException("Error deleting order: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during order deletion", e);
            throw new OrderDaoException("Unexpected error during order deletion", e);
        }
    }

    @Override
    public List<OrderResponse> getAllOrders() throws OrderDaoException {
        List<OrderResponse> orders = new ArrayList<>();
        String sql = "SELECT * FROM Orders";
        try (Connection conn = ConnectionFactor.getConnectionFactor().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                orders.add(new OrderResponse(
                    rs.getInt("order_id"),
                    rs.getInt("user_id"),
                    rs.getBigDecimal("total_amount"),
                    rs.getTimestamp("order_date"),
                    rs.getString("shipping_address"),
                    rs.getString("billing_address"),
                    rs.getString("status")
                ));
            }
            logger.info("Fetched all orders.");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error fetching all orders: " + e.getMessage(), e);
            throw new OrderDaoException("Error fetching all orders: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error during fetching all orders", e);
            throw new OrderDaoException("Unexpected error during fetching all orders", e);
        }
        return orders;
    }
}