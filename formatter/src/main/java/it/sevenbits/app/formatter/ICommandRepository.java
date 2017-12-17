package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.implementation.State;
import it.sevenbits.app.token.IToken;

/**
 * interface ICommandRepository
 */
public interface ICommandRepository {
    /**
     * getCommand
     * @param state state
     * @param token token
     * @return command
     */
    ICommand getCommand(State state, IToken token);
}
