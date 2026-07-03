package exception;

/**
 * Thrown when attempting to insert a duplicate record.
 */
public class DuplicateRecordException extends RuntimeException {

    public DuplicateRecordException() {
        super();
    }

    public DuplicateRecordException(String message) {
        super(message);
    }

    public DuplicateRecordException(String message, Throwable cause) {
        super(message, cause);
    }

}