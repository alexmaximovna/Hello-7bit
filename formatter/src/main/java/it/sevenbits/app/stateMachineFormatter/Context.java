package it.sevenbits.app.stateMachineFormatter;

import it.sevenbits.app.token.implementation.Token;

/**
 * interface Context
 */
public interface Context {
    /**
     * indent
     */
    void indent();

    /**
     * writeLexeme
     * @param token token
     */
    void writeLexeme(Token token);

    /**
     * writeNewLine
     */
    void writeNewLine();

    /**
     * writeIndent
     */
    void writeIndent();

    /**
     * incrementindent
     */
    void incrementindent();

    /**
     * discrementindent
     */
    void discrementindent();
}
