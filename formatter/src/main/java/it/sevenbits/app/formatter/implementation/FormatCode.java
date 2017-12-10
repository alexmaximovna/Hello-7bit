package it.sevenbits.app.formatter.implementation;
import it.sevenbits.app.formatter.*;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.ILexer;


import it.sevenbits.app.token.IToken;


/**
 * Class of formatting the text
 */
public class FormatCode implements IFormatter {
    private ICommandRepository commands = new CommandRepository();
    private IStateTransitions  transitions = new StateTransitions();

    public FormatCode() throws WriterException {
    }

    public void format(ILexer lexer, IWriter writer ) throws LexerException,ReaderException,WriterException{
        IContext context = new Context(writer);
        State state = new State("default");
        while (lexer.hasMoreTokens() && state != null){
            IToken token = lexer.readToken();
            ICommand command = commands.getCommand(state,token);
            command.execute(token,context);
            state = transitions.getNextState(state,token);
        }
    }


    /*private int lvl = 0;
    private boolean flag = false ;
    private int openBracket = 0 ;
    private int closeBracket = 0 ;
    public  void format(final ILexer lexer, final IWriter writer) throws FormatterException,LexerException,ReaderException {
        try {
            while (lexer.hasMoreTokens()) {
                IToken token = lexer.readToken();
                String lexeme = token.getLexeme();

                if (lexeme.equals("{")) {
                    lvl++;
                    writer.writeChar('{');
                    openBracket++;
                    writer.writeChar('\n');
                    if (lvl != 1 || (openBracket > closeBracket)) {
                        if (openBracket - closeBracket != 0 && closeBracket == 0) {

                            checkOnSpace(writer);
                        }
                    }
                } else if (lexeme.equals("}")) {
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
                } else if (lexeme.equals(";")) {
                    flag = true;
                    writer.writeChar(';');
                    writer.writeChar('\n');

                } else {
                    if (flag) {
                        checkOnSpace(writer);
                        write(writer, lexeme);
                        flag = false;
                    } else {
                        write(writer, lexeme);
                    }

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
            for (int i = 0; i < array.length; i++) {
                writer.writeChar(array[i]);
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
            throw new FormatterException("spacing failed ", e);
        }
    }*/


}




