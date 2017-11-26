package it.sevenbits.app.io.reader.implemetation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;

/**
 * Класс для чтения файла посимвольно
 */
public class StringReader implements IReader {

    private String str;
    private int index = 0;

    /**
     * Constructor of StringReader
     * @param str Object of StringReader
     */
    public StringReader(final String str) {

        this.str = str;
    }

    /**
     * Function check of end of line
     * @return  True,if index symbol less than the length of string
     * @throws ReaderException  Failed or interrupted I/O operations.
     */
    public boolean hasChar() throws ReaderException  {

        return index < str.length();
    }

    /**
     * The function returns an element corresponding to the number in the string
     * @return returns an element to the corresponding order in the row
     * @throws ReaderException Exception of Reader
     */
    public char nextChar() throws ReaderException {
        return str.charAt(index++);
    }
}
