package it.sevenbits.packages.reader.Implemetation;

import it.sevenbits.packages.IClosable;
import it.sevenbits.packages.reader.IReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
/**
 * Read of one symbol and push file
 */
public class ReaderFile implements IReader, IClosable {

    private BufferedReader fileInput;
    private char symbol;

    /**
     * Function read text from file
     * @param namefile Name of File
     * @throws Exception Exception of Reader or Writer
     */
    public ReaderFile(final String namefile) throws Exception {
        File file=new File(namefile);
        if (!file.exists()) {
            throw new FileNotFoundException(namefile);
        }
        try {
           fileInput = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new Exception("File not found", e);
        }
    }

    /**
     * Function of checking
     * @return True or False
     * @throws Exception Exception of Writer or Reader
     */
   public boolean hasChar() throws Exception {
        int c = fileInput.read();
        if (c == -1) {
            return false;
        } else {
            symbol = (char) c;
            return true;
        }
    }

    /**
     * Function read symbol
     * @return Symbol
     * @throws Exception Exception of Writer or Reader
     */
    public char readChar() throws Exception {
        try {
            return symbol;
        } catch (Exception e) {
            throw new Exception("File not found", e);
        }
    }

    /**
     * Function close Stream
     * @throws Exception Exception Writer or Reader
     */
    public void close() throws Exception {
        try {
            fileInput.close();
        } catch (Exception e) {
            throw new Exception();
        }
    }
}




