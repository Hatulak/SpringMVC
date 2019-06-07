package main.exceptions;

public class NoSuchStudentInDBException extends Exception {

    public NoSuchStudentInDBException() {
    }

    public NoSuchStudentInDBException(String message) {
        super(message);
    }

    public NoSuchStudentInDBException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchStudentInDBException(Throwable cause) {
        super(cause);
    }

    public NoSuchStudentInDBException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
