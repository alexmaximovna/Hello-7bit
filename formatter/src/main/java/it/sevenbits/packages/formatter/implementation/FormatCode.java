package it.sevenbits.packages.formatter.implementation;

import it.sevenbits.packages.formatter.IFormatCode;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.write.IWriter;


/**
 * Class of formatting the text
 */
public class FormatCode implements IFormatCode {
    private int lvl = 0;
    private boolean flag = false ;
    private int openBracket = 0 ;
    private int closeBracket = 0 ;

    /**
     *
     * @param bufread nput interface FileReader
     * @param writ Input interface FileWriter.
     * @throws Exception Exception of REder or Writer
     */
    public  void checkSymb(final IReader bufread, final IWriter writ) throws Exception {
        try {
            while (bufread.hasChar()) {
                char symb ;
                symb = bufread.readChar();
                if (symb == '{') {
                    lvl++;
                    writ.writeChar('{');
                    openBracket++;
                    writ.writeChar('\n');
                    if (lvl != 1 || (lvl == 1 && openBracket > closeBracket)) {
                        if (openBracket - closeBracket != 0 && closeBracket == 0) {

                            checkOnSpace(writ);
                        }
                    }
                } else if (symb == '}') {
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
                } else if (symb == ';') {
                    flag = true;
                    writ.writeChar(symb);
                    writ.writeChar('\n');

                } else {
                    if (flag) {

                       checkOnSpace(writ);
                        writ.writeChar(symb);
                        flag = false;
                    } else {

                        writ.writeChar(symb);
                    }

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    private  void checkOnSpace(final IWriter output) throws Exception {

        for (int i = 0; i < lvl ; i++) {

            output.writeChar('\t');
        }
    }


}

