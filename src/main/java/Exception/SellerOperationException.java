package Exception;

public class SellerOperationException extends Exception {
    public SellerOperationException(String message) {
        super(message);
    }

    public SellerOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
