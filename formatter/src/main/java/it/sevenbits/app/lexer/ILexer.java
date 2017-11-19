package it.sevenbits.app.lexer;

import it.sevenbits.app.IO.reader.ReaderException;
import it.sevenbits.app.token.IToken;


/**
 * interface of ILexer
 */
public interface ILexer {
    /**
     * Function checks tokens
     * @return true/false
     * @throws ReaderException Exception Reader
     */
    boolean hasMoreTokens()throws ReaderException;

    /**
     *
     * @return
     * @throws ReaderException Exception Reader
     */
    IToken readToken() throws ReaderException;
}
