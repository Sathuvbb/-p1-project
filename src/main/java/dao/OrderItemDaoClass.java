package dao;

import dto.OrderItemRequest;
import dto.OrderItemResponse;
import Exception.OrderItemDaoException;
import utils.ConnectionFactor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoClass implements OrderItemDao {

    private static final Logger logger = LoggerFactory.getLogger(OrderItemDaoClass.class);

    @Override
    public boolean createOrderItem(OrderItemRequest request) throws OrderItemDaoException {
        String sql = "INSERT INTO OrderItems (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, request.getOrderId());
            stmt.setInt(2, request.getProductId());
            stmt.setInt(3, request.getQuantity());
            stmt.setDouble(4, request.getPrice());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Order item created successfully for order ID: {}", request.getOrderId());
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error creating order item for order ID: " + request.getOrderId(), e);
            throw new OrderItemDaoException("Error creating order item for order ID: " + request.getOrderId(), e);
        }
        return false;
    }

    @Override
    public OrderItemResponse getOrderItemByOrderId(int orderItemId) throws OrderItemDaoException {
        String sql = "SELECT * FROM OrderItems WHERE order_item_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, orderItemId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    logger.info("Order item found with id: {}", orderItemId);
                    return new OrderItemResponse(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                    );
                }
            }
        } catch (SQLException e) {
            logger.error("Error fetching order item with id: " + orderItemId, e);
            throw new OrderItemDaoException("Error fetching order item with id: " + orderItemId, e);
        }
        logger.warn("No order item found with id: {}", orderItemId);
        return null;
    }

    @Override
    public boolean updateOrderItem(OrderItemRequest request) throws OrderItemDaoException {
        String sql = "UPDATE OrderItems SET order_id=?, product_id=?, quantity=?, price=? WHERE order_item_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, request.getOrderId());
            stmt.setInt(2, request.getProductId());
            stmt.setInt(3, request.getQuantity());
            stmt.setDouble(4, request.getPrice());
            stmt.setInt(5, request.getOrderItemId());  // Corrected: Use request.getOrderItemId()

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Order item updated successfully with id: {}", request.getOrderItemId());
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error updating order item with id: " + request.getOrderItemId(), e);
            throw new OrderItemDaoException("Error updating order item with id: " + request.getOrderItemId(), e);
        }
        logger.warn("Order item update failed for id: {}", request.getOrderItemId());
        return false;
    }

    @Override
    public boolean deleteOrderItemById(int orderItemId) throws OrderItemDaoException {
        String sql = "DELETE FROM OrderItems WHERE order_item_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, orderItemId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Order item deleted successfully with id: {}", orderItemId);
                return true;
            }
        } catch (SQLException e) {
            logger.error("Error deleting order item with id: " + orderItemId, e);
            throw new OrderItemDaoException("Error deleting order item with id: " + orderItemId, e);
        }
        logger.warn("Order item deletion failed for id: {}", orderItemId);
        return false;
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByOrderId(int orderId) throws OrderItemDaoException {
        String sql = "SELECT * FROM OrderItems WHERE order_id=?";
        List<OrderItemResponse> orderItems = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    orderItems.add(new OrderItemResponse(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                    ));
                }
                logger.info("Fetched order items for order ID: {}, count: {}", orderId, orderItems.size());
            }
        } catch (SQLException e) {
            logger.error("Error fetching order items for order ID: " + orderId, e);
            throw new OrderItemDaoException("Error fetching order items for order ID: " + orderId, e);
        }
        return orderItems;
    }

    @Override
    public List<OrderItemResponse> getOrderItemsByBuyerId(int userId) throws OrderItemDaoException {
        String sql = "SELECT * FROM OrderItems WHERE buyer_id=?";
        List<OrderItemResponse> orderItems = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    orderItems.add(new OrderItemResponse(
                        rs.getInt("order_item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                    ));
                }
                logger.info("Fetched order items for buyer ID: {}, count: {}", userId, orderItems.size());
            }
        } catch (SQLException e) {
            logger.error("Error fetching order items for buyer ID: " + userId, e);
            throw new OrderItemDaoException("Error fetching order items for buyer ID: " + userId, e);
        }
        return orderItems;
    }
}
