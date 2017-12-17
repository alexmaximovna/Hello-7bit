package it.sevenbits.app.formatter;


import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.lexer.ILexer;


/**
* Class of interface of FormatCode
*/
public interface IFormatter {
    /**
     *Function formats text
     * @param input Input interface FileReader.
     * @param output Input interface FileWriter.
     * @throws FormatterException Exception of Reader or Writer
     */
    void format(ILexer input, IWriter output) throws FormatterException;


}
