package it.sevenbits.packages.reader.Implemetation;

import it.sevenbits.packages.reader.IReader;

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
     */
    public boolean hasChar() {

        return index < str.length();
    }

    /**
     * The function returns an element corresponding to the number in the string
     * @return returns an element to the corresponding order in the row
     */
    public char readChar() {
        return str.charAt(index++);
    }
}
