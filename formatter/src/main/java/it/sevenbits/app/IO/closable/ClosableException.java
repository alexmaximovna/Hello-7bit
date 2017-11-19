package it.sevenbits.app.IO.closable;

/**
 * class of closableException
 */
public class ClosableException extends Exception {
    /**
     * Exception for Closable.
     * @param cause Exception
     */
    public ClosableException(final Throwable cause) {
        super(cause);
    }

    /**
     * Exception for Closable.
     * @param message Message Exception.
     * @param cause Exception.
     */
    public ClosableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
