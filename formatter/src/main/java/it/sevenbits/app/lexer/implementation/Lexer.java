package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;

import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.lexer.*;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;

/**
 *class Lexer
 */
public class Lexer implements ILexer, IContext {

    private IReader input;
    private String tokenName;
    private StringBuilder tokenLexeme;
    private ICommandRepository commands;
    private IStateTransitions  transitions;
    private StringBuilder postponeBuffer = new StringBuilder();

    /**
     * Constructor of Lexer
     *
     * @param input Value of IReader
     */
    public Lexer(final IReader input) {
        this(input, new CommandRepository(), new StateTransitions());

    }

    /**
     * Lexer
     * @param reader reader
     * @param commands commands
     * @param  transitions transitions
     */
    public Lexer(final IReader reader, final ICommandRepository commands, final IStateTransitions transitions) {
        this.input = reader;
        this.commands = commands;
        this.transitions = transitions;

    }
    /**
     * @return Symbol  of text
     * @throws LexerException Exception Reader
     */
    public boolean hasMoreTokens() throws LexerException {
        try {
            return postponeBuffer.length() > 0 || input.hasChar();
        } catch (Exception e) {
            throw new LexerException("Error of lexer", e);
        }


    }

    /**
     * @return Token
     * @throws LexerException Exception Lexer
     */
    public IToken readToken() throws LexerException {
        tokenLexeme = new StringBuilder();
        State state = new State("default");
        IReader postponeReader = new StringReader(postponeBuffer.toString());
        try {
            while (postponeReader.hasChar() && state != null) {

                char c = postponeReader.nextChar();
                ICommand command = commands.getCommand(state, c);
                command.execute(c, this);
                state = transitions.getNextState(state, c);

            }
            postponeBuffer = new StringBuilder();


            while (input.hasChar() && state != null) {

                char c = input.nextChar();
                ICommand command = commands.getCommand(state, c);
                command.execute(c, this);
                state = transitions.getNextState(state, c);
            }

            return new Token(tokenName, tokenLexeme.toString());

        } catch (ReaderException e) {
            throw new LexerException("reader error", e);
        }
    }

    @Override
    public void appendLexeme(final char c) {
            tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(final String name) {
            tokenName = name;
    }

    @Override
    public void appendPostpone(final char c) {
        postponeBuffer.append(c);

    }
}