package it.sevenbits.app.io.writer.implementation;


import it.sevenbits.app.io.closable.IClosable;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.closable.ClosableException;
import it.sevenbits.app.io.writer.WriterException;

import java.io.*;


/**
 * Write substring in outputString
 */
public class WriterFile implements IWriter, IClosable {
    private static BufferedWriter bufferedWriter;

    /**
     * Constructor write in file
     * @param name Name of file
     * @throws WriterException Exception io
     */
    public WriterFile(final String name) throws WriterException {
        try {
            FileOutputStream outputStream =
                    new FileOutputStream(new File(name));
            Writer fileWriter =
                    new OutputStreamWriter(outputStream, "utf-8");
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            throw new WriterException("Opening file error", e);
        }
    }
    /**
     Function write in file
     * @param symb Symbol from text
     * @throws WriterException Exception io
     *
     *  */
    public void writeChar(final char symb) throws WriterException {
        try {
            bufferedWriter.write(symb);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
    }
 public void writeString(String s){

 }
    /**
     * Close write
     * @throws ClosableException Exception of Writer
     */
    public void close() throws ClosableException {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            throw new ClosableException("Can't close output stream", e);
        }
    }


}



