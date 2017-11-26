package it.sevenbits.app.stateMachineLexer.CommandRepository;

import it.sevenbits.app.stateMachineLexer.TokenBuilder;

public class Append {
    /**
     * @param builder TokenBuilder.
     * @param c char.*/
    public final void execute(final TokenBuilder builder, final char c) {
        builder.append(c);
    }

    /**
     *
     * @return false.
     */
    public final boolean returnToken() {
        return false;
    }
}
