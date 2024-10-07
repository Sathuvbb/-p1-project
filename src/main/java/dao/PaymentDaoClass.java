package dao;

import dto.PaymentRequest;
import dto.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConnectionFactor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PaymentDaoClass implements PaymentDao {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDaoClass.class);

    @Override
    public boolean createPayment(PaymentRequest request) {
        String sql = "INSERT INTO Payments (order_id, amount, payment_method, payment_status,payment_date) VALUES (?, ?, ?, ?,?)";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, request.getOrderId());
            stmt.setDouble(2, request.getAmount());
            stmt.setString(3, request.getPaymentMethod());
            stmt.setString(4, request.getStatus());
            stmt.setTimestamp(5, request.getPaymentDate());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Payment created successfully for Order ID {}", request.getOrderId());
                return true;
            } else {
                logger.warn("No rows affected while creating payment for Order ID {}", request.getOrderId());
                return false;
            }
        } catch (SQLException e) {
            logger.error("Error creating payment for Order ID {}: {}", request.getOrderId(), e.getMessage());
            return false;
        }
    }

    @Override
    public PaymentResponse getPaymentById(int paymentId) {
        String sql = "SELECT * FROM Payments WHERE payment_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, paymentId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PaymentResponse(
                            rs.getInt("payment_id"),
                            rs.getInt("order_id"),
                            rs.getTimestamp("payment_date"),
                            rs.getDouble("amount"),
                            rs.getString("payment_method"),
                            rs.getString("payment_status")
                    );
                }
            }
        } catch (SQLException e) {
            logger.error("Error fetching payment with ID {}: {}", paymentId, e.getMessage());
        }
        return null;
    }

    @Override
    public List<PaymentResponse> getPaymentsByOrderId(int orderId) {
        String sql = "SELECT * FROM Payments WHERE order_id=?";
        List<PaymentResponse> payments = new ArrayList<>();
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PaymentResponse payment = new PaymentResponse(
                            rs.getInt("payment_id"),
                            rs.getInt("order_id"),
                            rs.getTimestamp("payment_date"),
                            rs.getDouble("amount"),
                            rs.getString("payment_method"),
                            rs.getString("payment_status")
                    );
                    payments.add(payment);
                }
                logger.info("Fetched {} payments for Order ID {}", payments.size(), orderId);
            }
        } catch (SQLException e) {
            logger.error("Error fetching payments for Order ID {}: {}", orderId, e.getMessage());
        }
        return payments;
    }

    @Override
    public boolean updatePayment(PaymentRequest request) {
        String sql = "UPDATE Payments SET amount=?, payment_method=?, payment_status=? WHERE payment_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setDouble(1, request.getAmount());
            stmt.setString(2, request.getPaymentMethod());
            stmt.setString(3, request.getStatus());
            stmt.setInt(4, request.getPaymentId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Payment updated successfully: Payment ID {}", request.getPaymentId());
                return true;
            } else {
                logger.warn("No rows affected while updating payment: Payment ID {}", request.getPaymentId());
                return false;
            }
        } catch (SQLException e) {
            logger.error("Error updating payment with ID {}: {}", request.getPaymentId(), e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePayment(int paymentId) {
        String sql = "DELETE FROM Payments WHERE payment_id=?";
        try (Connection con = ConnectionFactor.getConnectionFactor().getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, paymentId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                logger.info("Payment deleted successfully: Payment ID {}", paymentId);
                return true;
            } else {
                logger.warn("No rows affected while deleting payment: Payment ID {}", paymentId);
                return false;
            }
        } catch (SQLException e) {
            logger.error("Error deleting payment with ID {}: {}", paymentId, e.getMessage());
            return false;
        }
    }
}
