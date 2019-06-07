package main.exceptions;

public class StudentAlreadyExistsInDBException extends Exception {

    public StudentAlreadyExistsInDBException() {
    }

    public StudentAlreadyExistsInDBException(String message) {
        super(message);
    }

    public StudentAlreadyExistsInDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentAlreadyExistsInDBException(Throwable cause) {
        super(cause);
    }

    public StudentAlreadyExistsInDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
