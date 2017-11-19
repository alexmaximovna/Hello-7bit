package it.sevenbits.app.formatter.implementation;
import it.sevenbits.app.IO.reader.ReaderException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.IO.reader.IReader;
import it.sevenbits.app.IO.writer.IWriter;
import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.IO.writer.WriterException;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.token.IToken;

import java.io.IOException;


/**
 * Class of formatting the text
 */
public class FormatCode implements IFormatter {
    private int lvl = 0;
    private boolean flag = false ;
    private int openBracket = 0 ;
    private int closeBracket = 0 ;

    /**
     *
     * @param lexer  interface Lexer
     * @param writ Input interface FileWriter.
     * @throws FormatterException Exception of REder or Writer
     */
    public  void format(final ILexer lexer, final IWriter writ) throws FormatterException {
        try {
            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String lexeme = token.getLexeme();

                if (lexeme.equals("{")) {
                    lvl++;
                    writ.writeChar('{');
                    openBracket++;
                    writ.writeChar('\n');
                    if (lvl != 1 || (lvl == 1 && openBracket > closeBracket)) {
                        if (openBracket - closeBracket != 0 && closeBracket == 0) {

                            checkOnSpace(writ);
                        }
                    }
                } else if (lexeme.equals("}")) {
                    if (closeBracket != openBracket) {
                        flag = true;
                    }
                    if (flag) {
                        lvl--;
                        checkOnSpace(writ);
                        writ.writeChar('}');
                        closeBracket++;
                        writ.writeChar('\n');
                        if (lvl != 1 || ( lvl == 1 && openBracket > closeBracket)) {
                            if (openBracket - closeBracket != 0 && closeBracket == 0) {

                               checkOnSpace(writ);
                            }
                        }
                        flag = false;
                    } else {
                        lvl--;

                        writ.writeChar('}');
                        closeBracket++;
                        if (closeBracket < 0) {
                            checkOnSpace(writ);
                        }
                        writ.writeChar('\n');
                    }
                } else if (lexeme.equals(";")){
                    flag = true;
                    writ.writeChar(';');
                    writ.writeChar('\n');

                } else {
                    if (flag) {
                        checkOnSpace(writ);
                        write(writ,lexeme);
                       // writ.writeChar(lexeme);
                        flag = false;
                    } else {
                        write(writ,lexeme);
                       // writ.writeChar(symb);
                    }

                }


            }


        } catch (ReaderException e) {
            throw new FormatterException("Reading error", e);
        } catch (WriterException e) {
            throw new FormatterException("Writing error", e);
        }

    }

//какая-то функция write,в нее передаем writ,lexeme
    private void write(IWriter writ,String lexeme) throws WriterException {
     char [] array = lexeme.toCharArray();
    try {
        for (int i = 0; i < array.length; i++)
            writ.writeChar(array[i]);
    }catch (WriterException e) {
        new WriterException("Error write symb",e);
    }
     }



    private  void checkOnSpace(final IWriter output) throws FormatterException {

       try {
           for (int i = 0; i < lvl; i++) {

               output.writeChar('\t');
           }
       }catch (Exception e) {
           throw new FormatterException("spacing failed ", e);
       }
    }


}

