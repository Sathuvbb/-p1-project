package Exception;

public class OrderDaoException extends Exception {

    public OrderDaoException(String message) {
        super(message);
    }

    public OrderDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
