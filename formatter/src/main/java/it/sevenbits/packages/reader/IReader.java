package it.sevenbits.packages.reader;


/**
 * interface for class Reader
 */
public interface IReader {
    /**
     * Function of checking
     * @return True or False
     * @throws Exception Exception of Writer or Reader
     */
    boolean hasChar() throws Exception;

    /**
     * Function read symbol
     * @return Symbol
     * @throws Exception Exception of Writer or Reader
     */
    char readChar() throws Exception;
}
