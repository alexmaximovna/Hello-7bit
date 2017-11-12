package it.sevenbits.packages.write.Implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import it.sevenbits.packages.IClosable;
import it.sevenbits.packages.write.IWriter;


/**
 * Write substring in outputString
 */
public class WriterFile implements IWriter, IClosable {
    private static BufferedWriter finalFile;

    /**
     * Constructor write in file
     * @param name Name of file
     * @throws IOException Exception IO
     */
    public WriterFile(final String name) throws IOException {
            finalFile = new BufferedWriter(new FileWriter(name));
        }

    /**
     Function write in file
     * @param symb Symbol from text
     * @throws IOException Exception IO
     *
     *  */
    public void writeChar(final char symb) throws Exception {
        try {
            finalFile.write(symb);
        } catch (IOException e) {
            throw new Exception("Cannot it.sevenbits.packages.write in file", e);
        }
    }

    /**
     * Close write
     * @throws Exception Exception of Writer
     */
    public void close() throws Exception {
        try {
            finalFile.close();
        } catch (IOException ex) {
            throw new Exception("Can't close output stream", ex);
        }
    }


}



