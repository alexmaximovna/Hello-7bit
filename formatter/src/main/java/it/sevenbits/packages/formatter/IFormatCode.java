package it.sevenbits.packages.formatter;

import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.write.IWriter;

/**
* Class of interface of FormatCode
*/
public interface IFormatCode {
    /**
     *Function formats text
     * @param input Input interface FileReader.
     * @param output Input interface FileWriter.
     * @throws Exception Exception of Reader or Writer
     */
    void checkSymb(IReader input, IWriter output) throws Exception;

}
