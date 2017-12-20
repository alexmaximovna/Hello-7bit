package it.sevenbits.app.lexer;


import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.token.IToken;



/**
 * interface of ILexer
 */
public interface ILexer {
    /**
     * Function checks tokens
     * @return true/false
     * @throws LexerException Exception Lexer
     */
    boolean hasMoreTokens()throws LexerException;

    /**
     *
     * @return new Token
     * @throws LexerException Exception Lexer
     */
    