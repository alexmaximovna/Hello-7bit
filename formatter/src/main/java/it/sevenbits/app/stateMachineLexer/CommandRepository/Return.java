package it.sevenbits.app.stateMachineLexer.CommandRepository;

import it.sevenbits.app.stateMachineLexer.TokenBuilder;

public class Return {
    /**
     * @param builder TokenBuilder.
     * @param c char.*/
    public final void execute(final TokenBuilder builder, final char c) {
        builder.returnToken();
        builder.append(c);
    }

    /**
     * boolean.
     * @return true.
     */
    public final boolean returnToken() {
        return true;
    }
}
