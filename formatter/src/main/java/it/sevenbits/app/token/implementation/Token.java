package it.sevenbits.app.token.implementation;

import it.sevenbits.app.token.IToken;

/**
 *Class Token
 */
public class Token implements IToken {
    private String nameLexeme;
    private String lexeme;

    /**
     *Constructor of Token
     * @param nameLex Name of lexeme
     * @param lexeme Lexeme
     */
    public Token(final String nameLex, final String lexeme) {
        this.nameLexeme = nameLex;
        this.lexeme = lexeme;
    }

    public String getName() {
        return nameLexeme;
    }


    public String getLexeme() {
        return lexeme;
    }

}
