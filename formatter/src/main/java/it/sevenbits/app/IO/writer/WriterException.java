package it.sevenbits.app.IO.writer;

/**
 *class of writer exception
 */
public class WriterException extends Exception {
    /**
     *WriterException for Writer.
     * @param cause Exception.
     */
    public WriterException(final Throwable cause) {
        super(cause);
    }

    /**
     * WriterException for Writer.
     * @param message Message Exception.
     * @param cause Exception.
     */
    public WriterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
