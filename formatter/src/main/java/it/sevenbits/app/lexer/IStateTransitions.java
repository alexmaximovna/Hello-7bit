package it.sevenbits.app.lexer;

import it.sevenbits.app.lexer.implementation.State;

public interface IStateTransitions {

    State getNextState(State state, char c);
}
