package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.implementation.State;
import it.sevenbits.app.token.IToken;

public interface ICommandRepository {
    ICommand getCommand(State state, IToken token);
}
