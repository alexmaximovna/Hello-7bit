package it.sevenbits.app.lexer;

import it.sevenbits.app.lexer.ICommand;
import it.sevenbits.app.lexer.implementation.State;

public interface ICommandRepository {
    ICommand getCommand(State state, char c);
}
