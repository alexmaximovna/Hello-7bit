package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.implementation.State;
import it.sevenbits.app.token.IToken;

/**
 * interface IStateTransitions
 */
public interface IStateTransitions {
    /**
     * getNextState
     * @param state state
     * @param token token
     * @return state
     */
    State getNextState(State state, IToken token);
}
