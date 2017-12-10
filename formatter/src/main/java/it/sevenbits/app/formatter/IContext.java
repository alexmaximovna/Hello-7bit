package it.sevenbits.app.formatter;

import it.sevenbits.app.io.writer.WriterException;

public interface IContext {
    void writeLexeme(String lexeme);

    void writeNewLine();
    void writeSpace(int level) throws WriterException;
}
