package it.sevenbits.app.token.implementation;

import it.sevenbits.app.token.IToken;

/**
 *Class Token
 */
public final class Token implements IToken {
    private String nameLexeme;
    private String lexeme;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        return nameLexeme != null ? nameLexeme.equals(token.nameLexeme) : token.nameLexeme == null;
    }

    @Override
    public int hashCode() {
        return nameLexeme != null ? nameLexeme.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Token{" +
                "nameLexeme='" + nameLexeme + '\'' +
                ", lexeme='" + lexeme + '\'' +
                '}';
    }

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
