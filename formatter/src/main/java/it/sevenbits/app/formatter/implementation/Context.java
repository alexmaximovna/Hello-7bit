package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.IContext;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;

class Context implements IContext {

    private final IWriter writer;

    public Context(IWriter writer){
        this.writer = writer;

    }
    @Override
    public void writeLexeme(String lexeme) {
        writer.writeString(lexeme);
    }

    @Override
    public void writeNewLine() {
        writer.writeString("\n");
    }

    @Override
    public void writeSpace(int level) throws WriterException {
        int indent = 4;
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < indent; j++) {
                writer.writeChar(' ');
            }
        }

    }
}
