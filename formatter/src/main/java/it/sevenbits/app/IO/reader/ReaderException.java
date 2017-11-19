package it.sevenbits.app.IO.reader;

/**
 * class reader exception
 */
public class ReaderException  extends Exception {
    /**
     *Exception Reader
     * @param cause Exception
     */
    public ReaderException(final Throwable cause) {
        super(cause);
    }

    /**
     * ReaderException for Reader.
     * @param message Message Exception.
     * @param cause Exception.
     */
    public ReaderException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
