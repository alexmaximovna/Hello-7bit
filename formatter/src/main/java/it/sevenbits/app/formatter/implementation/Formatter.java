package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.token.IToken;

/**
 * OldFormatter
 */
public class Formatter {

   private int lvl = 0;
    private boolean flag = false ;
    private int openBracket = 0 ;
    private int closeBracket = 0 ;

    /**
     * Formatter
     * @param lexer lexer
     * @param writer writer
     * @throws FormatterException FormatterException

     */
    public  void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        try {
            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String lexeme = token.getLexeme();

                switch (lexeme) {
                    case "{":
                        lvl++;
                        writer.writeChar('{');
                        openBracket++;
                        writer.writeChar('\n');
                        if (lvl != 1 || (openBracket > closeBracket)) {
                            if (openBracket - closeBracket != 0 && closeBracket == 0) {

                                checkOnSpace(writer);
                            }
                        }
                        break;
                    case "}":
                        if (closeBracket != openBracket) {
                            flag = true;
                        }
                        if (flag) {
                            lvl--;
                            checkOnSpace(writer);
                            writer.writeChar('}');
                            closeBracket++;
                            writer.writeChar('\n');
                            if (lvl != 1 || (openBracket > closeBracket)) {
                                if (openBracket - closeBracket != 0 && closeBracket == 0) {

                                    checkOnSpace(writer);
                                }
                            }
                            flag = false;
                        } else {
                            lvl--;

                            writer.writeChar('}');
                            closeBracket++;
                            if (closeBracket < 0) {
                                checkOnSpace(writer);
                            }
                            writer.writeChar('\n');
                        }
                        break;
                    case ";":
                        flag = true;
                        writer.writeChar(';');
                        writer.writeChar('\n');

                        break;
                    default:
                        if (flag) {
                            checkOnSpace(writer);
                            write(writer, lexeme);
                            flag = false;
                        } else {
                            write(writer, lexeme);
                        }

                        break;
                }


            }
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        } catch (LexerException e) {
            throw new FormatterException("Error of lexer", e);
        }

    }


    private void write(final IWriter writer, final String lexeme) throws WriterException {
        char [] array = lexeme.toCharArray();
        try {
            for (char anArray : array) {
                writer.writeChar(anArray);
            }
        } catch (Exception e) {
            throw new WriterException("Error write symb", e);
        }
    }



    private  void checkOnSpace(final IWriter output) throws FormatterException {

        try {
            for (int i = 0; i < lvl; i++) {

                output.writeChar('\t');
            }
        } catch (Exception e) {
            throw new FormatterException