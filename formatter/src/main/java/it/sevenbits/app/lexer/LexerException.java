package it.sevenbits.app.lexer;

/**
 * class of LexerException
 */
public class LexerException extends Exception {
    /**
     * Exception of formatter
     * @param cause Exception
     */
    public LexerException(final Throwable cause) {
        super(cause);
    }

    /**
     * Exception message
     * @param message Message of exception
     * @param cause Exception
     */
    public LexerException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
