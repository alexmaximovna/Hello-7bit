package it.sevenbits.app.stateMachineLexer;

/**
 * class command of lexer
 */
public interface Context  {
    /**
     *
     * @param c symbol
     */
    void appendLexeme(char c);

    /**
     *
     * @param str string
     */
    void setTokenName(String str);

    /**
     *
     * @param c symbol
     */
    void appendPostpone(char c);

}
