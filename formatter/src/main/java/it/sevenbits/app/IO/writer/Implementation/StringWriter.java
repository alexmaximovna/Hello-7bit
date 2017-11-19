package it.sevenbits.app.IO.writer.Implementation;

import it.sevenbits.app.IO.writer.IWriter;
import it.sevenbits.app.IO.writer.WriterException;
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
     * @throws WriterException Exception Writer
     */
        public void writeChar(final char symb)throws WriterException {
            try {
                builder.append(symb);
            }catch (Exception e) {
                throw new WriterException("Writing error", e);
            }

        }
    }

