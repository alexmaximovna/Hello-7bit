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

    /**
     * Classs FormatterForStateMachine
     * @throws WriterException WriterException
     */
    public FormatCode() throws WriterException {
    }

    /**
     * Function format
     * @param lexer lexer
     * @param writer writer
     * @throws FormatterException FormatterException
     */
    public void format(final ILexer lexer, final IWriter writer) throws FormatterException {
        IContext context = new Context(writer);
        State state = new State("default");
       try {
           while (lexer.hasMoreTokens() && state != null) {
               IToken token = lexer.readToken();
               ICommand command = commands.getCommand(state, token);
               command.execute(token, context);
               state = transitions.getNextState(state, token);
           }
       } catch (LexerException | WriterException lexExp) {
           throw new FormatterException("Exceptio