/**
 * class of exception formatter
 */
package it.sevenbits.app.formatter;

/**
 * Exception of formatter
 */
public class FormatterException extends Exception {
    /**
     * Exception of formatter
     * @param cause Exception
     */
    public FormatterException(final Throwable cause) {
        super(cause);
    }

    /**
     * Exception message
     * @param message Message of exception
     * @param cause Exception
     */
    public FormatterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
