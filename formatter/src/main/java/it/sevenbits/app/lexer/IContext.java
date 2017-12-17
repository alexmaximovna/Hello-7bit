package it.sevenbits.app.lexer;

/**
 * interface IContext
 */
public interface IContext {
    /**
     * appendLexem
     * @param c char
     */
    void appendLexeme(char c);

    /**
     * setTokenName
     * @param name name
     */
    void setTokenName(String name);

    /**
     * appendPostpone
     * @param c char
     */
    void appendPostpone(char c);
}
