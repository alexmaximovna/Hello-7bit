package it.sevenbits.packages.write.Implementation;

import it.sevenbits.packages.write.IWriter;

/**
 * Class for writing rich text to a file using a string
 */
public class StringWriter implements IWriter {
    private static StringBuilder builder = new StringBuilder();

    /**
     * The function changes the type of the string, with StringBuilder in String
     * @return return string type String
     */
        public String toString() {

            return builder.toString();
        }

    /**
     * The function writes a character to a string of type StringBuilder
     * @param symb Symbol from text
     */
        public void writeChar(final char symb) {
            builder.append(symb);
            System.out.println(symb);
        }
    }

