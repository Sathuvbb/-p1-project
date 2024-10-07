package dao;

import dto.PaymentRequest;
import dto.PaymentResponse;

import java.util.List;

public interface PaymentDao {
    // Method to create a new payment record
    boolean createPayment(PaymentRequest request);
    
    // Method to get a payment by its ID
    PaymentResponse getPaymentById(int paymentId);
    
    // Method to get all payments for a specific order
    List<PaymentResponse> getPaymentsByOrderId(int orderId);
    
    // Method to update a payment record
    boolean updatePayment(PaymentRequest request);
    
    // Method to delete a payment record by its ID
    boolean deletePayment(int paymentId);
}
