package it.sevenbits.app.formatter;

import it.sevenbits.app.io.writer.WriterException;

/**
 * interface IContext
 */
public interface IContext {
    /**
     * writeLexeme
     * @param lexeme  lexeme
     */
    void writeLexeme(String lexeme);

    /**
     * writeNewLine();
     */
    void writeNewLine();

    /**
     * writeSpace
     * @param level level
     * @throws WriterException WriterException
     */
    void writeSpace(int level) throws WriterException;
}
