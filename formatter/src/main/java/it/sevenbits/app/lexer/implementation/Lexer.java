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
    private char prev;
    private boolean space = false, lineComment = false, str = false, multiLineComment = false;
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
        this(input, new CommandRepository(),new StateTransitions());

    }
    Lexer (IReader reader,ICommandRepository commands,IStateTransitions transitions ){
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
            return postponeBuffer.length()>0|| input.hasChar();
        } catch (Exception e) {
            throw new LexerException("Error of lexer", e);
        }

    }

    /**
     * @return Token
     * @throws LexerException Exception Reader
     */
    public IToken readToken() throws LexerException,ReaderException {
        tokenLexeme = new StringBuilder();
        State state = new State("default");
        IReader postponeReader = new StringReader(postponeBuffer.toString());
        while (postponeReader.hasChar() && state!=null){
            char c = postponeReader.nextChar();
            ICommand command = commands.getCommand(state,c);
            command.execute(c,this);
            state = transitions.getNextState(state,c);
        }
        postponeBuffer = new StringBuilder();


        while (input.hasChar() && state!=null){
            char c = input.nextChar();
            ICommand command = commands.getCommand(state,c);
            command.execute(c,this);
            state = transitions.getNextState(state,c);
        }

        return new Token(tokenName,tokenLexeme.toString());

    }

    @Override
    public void appendLexeme(char c) {
            tokenLexeme.append(c);
    }

    @Override
    public void setTokenName(String name) {
            tokenName = name;
    }

    @Override
    public void appendPostpone(char c) {
        postponeBuffer.append(c);

    }
}