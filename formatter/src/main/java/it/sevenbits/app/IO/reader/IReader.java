package it.sevenbits.app.IO.reader;


/**
 * interface for class Reader
 */
public interface IReader {
    /**
     * Function of checking
     * @return True or False
     * @throws ReaderException Exception of Writer or Reader
     */
    boolean hasChar() throws ReaderException;

    /**
     * Function read symbol
     * @return Symbol
     * @throws ReaderException Exception of Writer or Reader
     */
    char nextChar() throws ReaderException;
}
