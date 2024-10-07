package Exception;

public class CartDaoException extends Exception {
    public CartDaoException(String message) {
        super(message);
    }

    public CartDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
