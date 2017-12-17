package it.sevenbits.app.io.writer;

/**
 * Interface for class Writer
 */
public interface IWriter {
       /**
        * Function write symbol in file
        * @param symb Symbol from text
        * @throws WriterException Exception Writer
        */
       void writeChar(char symb) throws WriterException;

       /**
        * writeString
        * @param s string
        */
       void writeString(String s);
}
