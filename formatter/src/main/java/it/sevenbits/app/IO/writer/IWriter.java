package it.sevenbits.app.IO.writer;
import it.sevenbits.app.IO.writer.WriterException;
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
}
