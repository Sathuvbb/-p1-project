package Service;

import dao.PaymentDaoClass;

import dto.PaymentRequest;
import dto.PaymentResponse;

import java.sql.Timestamp;
import java.util.List;

public class PaymentService {

    private final PaymentDaoClass paymentDao;

    public PaymentService() {
        paymentDao = new PaymentDaoClass();
    }

    public boolean createPayment(PaymentRequest paymentRequest) {
        try {
            boolean result = paymentDao.createPayment(paymentRequest);
            System.out.println("Create payment operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error creating payment: " + e.getMessage());
            return false;
        }
    }

    public PaymentResponse getPaymentById(int paymentId) {
        try {
            PaymentResponse payment = paymentDao.getPaymentById(paymentId);
            if (payment != null) {
                System.out.println("Fetched payment by ID: " + paymentId);
            } else {
                System.out.println("No payment found with ID: " + paymentId);
            }
            return payment;
        } catch (Exception e) {
            System.out.println("Error fetching payment by ID: " + e.getMessage());
            return null;
        }
    }

    public List<PaymentResponse> getPaymentsByOrderId(int orderId) {
        try {
            List<PaymentResponse> payments = paymentDao.getPaymentsByOrderId(orderId);
            if (!payments.isEmpty()) {
                System.out.println("Fetched payments for Order ID: " + orderId);
            } else {
                System.out.println("No payments found for Order ID: " + orderId);
            }
            return payments;
        } catch (Exception e) {
            System.out.println("Error fetching payments for Order ID: " + e.getMessage());
            return null;
        }
    }

    public boolean updatePayment(PaymentRequest paymentRequest) {
        try {
            boolean result = paymentDao.updatePayment(paymentRequest);
            System.out.println("Update payment operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error updating payment: " + e.getMessage());
            return false;
        }
    }

    public boolean deletePayment(int paymentId) {
        try {
            boolean result = paymentDao.deletePayment(paymentId);
            System.out.println("Delete payment operation status: " + result);
            return result;
        } catch (Exception e) {
            System.out.println("Error deleting payment: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // Create an instance of the PaymentService
        PaymentService service = new PaymentService();

        // Create a new payment
        PaymentRequest newPayment = new PaymentRequest(2, 100.00, "Credit Card", "Completed",new Timestamp(System.currentTimeMillis()));
        boolean isCreated = service.createPayment(newPayment);
        System.out.println("Payment creation status: " + isCreated);

        // Fetch a payment by ID
        PaymentResponse payment = service.getPaymentById(2);
        if (payment != null) {
            System.out.println("Payment found: " + payment);
        } else {
            System.out.println("Payment with ID 1 not found.");
        }

        // Fetch payments by Order ID
        List<PaymentResponse> payments = service.getPaymentsByOrderId(2);
        if (payments != null && !payments.isEmpty()) {
            payments.forEach(System.out::println);
        } else {
            System.out.println("No payments found for Order ID 1.");
        }

        // Update a payment
        PaymentRequest paymentUpdate = new PaymentRequest(120.00, "Debit Card", "completed",1);
        boolean isUpdated = service.updatePayment(paymentUpdate);
        System.out.println("Payment update status: " + isUpdated);

        // Delete a payment
        boolean isDeleted = service.deletePayment(0);
        System.out.println("Payment deletion status: " + isDeleted);
    }
}
