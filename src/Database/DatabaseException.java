package Database;

/**
 * Standard exception thrown when something wrong with database
 */
public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 4187053082188070490L;

    DatabaseException() {
        super();
    }

    DatabaseException(final String message) {
        super(message);
    }

    DatabaseException(final Throwable cause) {
        super(cause);
    }

    DatabaseException(final String message, final Throwable cause) {
        super(message, cause);
    }
}