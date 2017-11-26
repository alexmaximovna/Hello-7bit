package it.sevenbits.app.stateMachineLexer.CommandRepository;

import it.sevenbits.app.stateMachineLexer.TokenBuilder;

public class Pass {
    /**
     *
     * @param builder
     * @param c Symbol
     */
    public void execute(final TokenBuilder builder, final char c) {

    }

    /**
     *
     * @return false.
     */
    public final boolean returnToken() {
        return false;
    }
}
