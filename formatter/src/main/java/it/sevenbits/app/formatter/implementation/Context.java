package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.IContext;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

/**
 * ContextFormatter
 */
class Context implements IContext {
    private static final int FOUR = 4;
    private final IWriter writer;

    /**
     * Context
     * @param writer writer
     */
    public Context(final IWriter writer) {
        this.writer = writer;

    }
    @Override
    public void writeLexeme(final String lexeme) {
        writer.writeString(lexeme);
    }

    @Override
    public void writeNewLine() {
        writer.writeString("\n");
    }

    @Override
    public void writeSpace(final int level) throws WriterException {

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < FOUR; j++) {
                writer.writeChar(' ');
            }
        }

    }
}
