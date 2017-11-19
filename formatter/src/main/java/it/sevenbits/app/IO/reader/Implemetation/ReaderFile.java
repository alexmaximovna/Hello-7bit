package it.sevenbits.app.IO.reader.Implemetation;

import it.sevenbits.app.IO.closable.IClosable;
import it.sevenbits.app.IO.reader.IReader;
import java.io.IOException;
import it.sevenbits.app.IO.closable.ClosableException;
import it.sevenbits.app.IO.reader.ReaderException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Read of one symbol and push file
 */
public class ReaderFile implements IReader, IClosable {

    private Reader reader;
    private int readChar = -1;

    /**
     * Function read text from file
     * @param namefile Name of File
     * @throws ReaderException Exception of Reader
     */
    public ReaderFile(final String namefile) throws ReaderException {
        try {
            reader = Files.newBufferedReader(Paths.get(namefile), StandardCharsets.UTF_8);
            readChar = reader.read();
        } catch (IOException e) {
            throw new ReaderException("Unsupported encoding", e);
        }
    }

    /**
     * Function of checking
     * @return True or False
     * @throws ReaderException Exception of Writer or Reader
     */
    public boolean hasChar() throws ReaderException {
        return readChar >= 0;
    }


    /**
     * Function read symbol
     * @return Symbol
     * @throws ReaderException Exception of Writer or Reader
     */
    public char nextChar() throws ReaderException {
        int prevChar =readChar ;
        try {
           readChar=reader.read();
        } catch (IOException e) {
            throw new ReaderException("File not found", e);
        }
        return (char) prevChar;

    }

    /**
     * Function close Stream
     * @throws ClosableException Exception Writer or Reader
     */
    public void close() throws ClosableException {
        try {
            reader.close();
        } catch (IOException e) {
            throw new ClosableException("Closing stream error", e);
        }
    }
}




