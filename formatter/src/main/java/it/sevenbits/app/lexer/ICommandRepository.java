package it.sevenbits.app.lexer;

import it.sevenbits.app.lexer.ICommand;
import it.sevenbits.app.lexer.implementation.State;

/**
 * interface ICommandRepository
 */
public interface ICommandRepository {
    /**
     * getCommand
     * @param state state
     * @param c symbol
     * @return command
     */
    ICommand getCommand(State state, char c);
}
