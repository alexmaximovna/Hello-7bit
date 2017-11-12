package it.sevenbits.packages.write;

/**
 * Interface for class Writer
 */
public interface IWriter {
       /**
        * Function write symbol in file
        * @param symb Symbol from text
        * @throws Exception Exception Writer
        */
       void writeChar(char symb) throws Exception;
}
