package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;

import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;

/**
 *class Lexer
 */
public class Lexer implements ILexer {

    private IReader input;
    private char prev ;
    private boolean  space = false, lineComment = false, str = false, multiLineComment = false ;

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
     * @throws LexerException Exception Reader
     */
    public boolean hasMoreTokens() throws LexerException {
        try {
            return input.hasChar();
        } catch (Exception e) {
            throw new LexerException("Error of lexer", e);
        }

    }

    /**
     *
     * @return Token
     * @throws LexerException Exception Reader
     */
    public IToken readToken() throws LexerException {
        final char temp = ' ';
        StringBuilder spaces = new StringBuilder();
        try {
            while (input.hasChar()) {
                char c = input.nextChar();
                if (!space && !spaces.toString().equals("")) {
                    spaces.delete(0, spaces.length());
                } else if (multiLineComment) {
                    return new Token("Comment", String.valueOf(c));
                } else if (lineComment) {
                    if (c != '\n') {
                        return new Token("String", String.valueOf(c));
                    } else {
                        str = false;
                        space = true;
                        prev = '\n';

                        return new Token("Separator", "\n");
                    }
                } else if (c == '\n') {
                    space = true;
                    prev = '\n';
                    return new Token("Separator", "\n");
                } else if (c == '{') {
                    prev = temp;
                    return new Token("OpenBracket", "{");
                } else if (c == '}') {
                    prev = temp;
                    return new Token("CloseBracket", "}");
                } else if (c == ';') {
                    prev = temp;
                    return new Token("Semicolon", ";");
                } else if (c == '/') {
                    if (prev == '/') {
                        prev = temp;
                        lineComment = true;
                        return new Token("Start of line comment", "//");
                    } else if (prev == '*') {
                        prev = temp;
                        multiLineComment = false;
                        return new Token("End of multiline comment", "*/");
                    } else {
                        prev = '/';
                    }
                } else if (c == '*') {
                    if (prev == '/') {
                        prev = temp;
                        multiLineComment = true;
                        return new Token("Start of multiline comment", "/*");
                    } else {
                        prev = '*';
                    }
                } else if (c == '"') {
                    if (!str) {
                        str = true;
                        return new Token("Start of string", String.valueOf(c));
                    } else {
                        str = false;
                        return new Token("End of string", String.valueOf(c));
                    }
                } else {
                    return new Token("Other", String.valueOf(c));
                }
            }
        } catch (Exception e) {
        throw new LexerException("error with token", e);
    }
        return new Token("default", "default");

    }
}
