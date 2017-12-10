package it.sevenbits.app.lexer;

public interface IContext {
    void appendLexeme(char c);

    void setTokenName(String name);

    void appendPostpone(char c);
}
