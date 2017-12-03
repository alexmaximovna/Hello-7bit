package it.sevenbits.app.stateMachineLexer;

/**
 * Class of TokenBuilder
 */
public class TokenBuilder  {

    private StringBuilder lexeme;
    private String string;
    private boolean done;

    /**
     *Constructor of TokenBuilder
     * @param lexeme lexeme.
     */
    TokenBuilder(final StringBuilder lexeme) {
        this.lexeme = lexeme;
        done = false;
    }

    /**
     *Add symbol
     * @param c char.
     */
    void append(final Character c) {
        lexeme.append(c);
    }
    public boolean getDone() {
        return done;
    }
    /**
     *In toString
     * @return string.
     */
    public final String toString() {
        return lexeme.toString();
    }
    void setDone(final boolean done) {
        this.done = done;
    }
    /**
     * returnToken.
     */
    public final void returnToken() {
        string = lexeme.toString();
        lexeme = new StringBuilder("");
    }


    public final String getString() {
        return string;
    }


    void setLexeme(StringBuilder lexeme) {
        this.lexeme = lexeme;
    }
}
