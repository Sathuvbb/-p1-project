package Exception;

public class CategoryDaoException extends Exception {
    public CategoryDaoException(String message) {
        super(message);
    }

    public CategoryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
}
