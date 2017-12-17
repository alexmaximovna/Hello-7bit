package it.sevenbits.app.lexer;

import it.sevenbits.app.lexer.implementation.State;

/**
 * interface IStateTransitions
 */
public interface IStateTransitions {
    /**
     * getNextState
     * @param state state
     * @param c char
     * @return state
     */
    State getNextState(State state, char c);
}
