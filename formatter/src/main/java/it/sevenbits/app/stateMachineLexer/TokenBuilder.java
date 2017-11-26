package it.sevenbits.app.stateMachineLexer;

/**
 * Class of TokenBuilder
 */
public class TokenBuilder {

    private StringBuilder builder;
    private String string;

    /**
     *Constructor of TokenBuilder
     * @param lexeme lexeme.
     */
    TokenBuilder(final StringBuilder lexeme) {
        this.builder = lexeme;
    }

    /**
     *Add symbol
     * @param c char.
     */
    public final void append(final Character c) {
        builder.append(c);
    }

    /**
     *In toString
     * @return string.
     */
    public final String toString() {
        return builder.toString();
    }

    /**
     * returnToken.
     */
    public final void returnToken() {
        string = builder.toString();
        builder = new StringBuilder("");
    }

    /**
     *
     * @return string.
     */
    public final String getString() {
        return string;
    }
}
