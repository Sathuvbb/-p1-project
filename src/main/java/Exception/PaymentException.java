package Exception;

public class PaymentException extends Exception {
    // Constructor with a message argument
    public PaymentException(String message) {
        super(message);
    }

    // Constructor with a message and a cause argument
    public PaymentException(String message, Throwable cause) {
        super(message, cause);
    }
}
