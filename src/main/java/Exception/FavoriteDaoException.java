package Exception;

public class FavoriteDaoException extends Exception {
    public FavoriteDaoException(String message) {
        super(message);
    }

    public FavoriteDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
