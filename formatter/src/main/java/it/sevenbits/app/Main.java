package it.sevenbits.app;

import it.sevenbits.app.io.reader.implemetation.ReaderFile;
import it.sevenbits.app.io.writer.implementation.WriterFile;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.FormatCode;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;


/**
 *
 */
public class Main {
    /**
     * Function main
     * @param args FIle for console
     * @throws Exception Problems with file
     */
    public static void main(final String[] args) throws Exception {

        //IFormatter format = new FormatCode();
        try (ReaderFile in = new ReaderFile(args[0]);
              WriterFile out = new WriterFile(args[1])
        ) {
            ILexer lexer = new Lexer(in);
            IFormatter formatter = new FormatCode();
            formatter.format(lexer, out);

        } catch (Exception e) {
            throw new Exception("Program execution error",e);
        }



}
}

