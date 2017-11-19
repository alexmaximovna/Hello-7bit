package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.IO.reader.IReader;
import it.sevenbits.app.IO.reader.ReaderException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;

/**
 *class Lexer
 */
public class Lexer implements ILexer {

    private IReader input;
    private StringBuilder lexeme = new StringBuilder();

    /**
     *Constructor of Lexer
     * @param input Value of IReader
     */
    public Lexer(final IReader input) {
        this.input = input;
    }

    /**
     *
     * @return Symbol  of text
     * @throws ReaderException Exception Reader
     */
    public boolean hasMoreTokens() throws ReaderException {
        return input.hasChar();
    }

    /**
     *
     * @return Token
     * @throws ReaderException Exception Reader
     */
    public IToken readToken() throws ReaderException {
        try {
            while (input.hasChar()) {
                char c = input.nextChar();
                if (c == '{') {
                    return new Token("OpenBracket", "{");
                } else if (c == '}') {
                    return new Token("CloseBracket", "}");
                } else if (c == ';') {
                    return new Token("Semicolon", ";");
                } else {
                    return new Token("Other", String.valueOf(c));
                }
            }
        } catch (ReaderException e) {
        throw new ReaderException("error with token", e);
    }
        return new Token("default", "default");

    }
}
