package Exception;

public class OrderItemDaoException extends Exception {

    public OrderItemDaoException(String message) {
        super(message);
    }

    public OrderItemDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
