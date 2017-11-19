package it.sevenbits.app.IO.writer.Implementation;

import java.io.*;
import it.sevenbits.app.IO.closable.IClosable;
import it.sevenbits.app.IO.writer.IWriter;
import it.sevenbits.app.IO.closable.ClosableException;
import it.sevenbits.app.IO.writer.WriterException;

/**
 * Write substring in outputString
 */
public class WriterFile implements IWriter, IClosable {
    private static BufferedWriter bufferedWriter;

    /**
     * Constructor write in file
     * @param name Name of file
     * @throws WriterException Exception IO
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
     * @throws WriterException Exception IO
     *
     *  */
    public void writeChar(final char symb) throws WriterException {
        try {
            bufferedWriter.write(symb);
        } catch (IOException e) {
            throw new WriterException("Writing error", e);
        }
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



