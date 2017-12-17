package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.Pair;
import it.sevenbits.app.formatter.IStateTransitions;
import it.sevenbits.app.token.IToken;



import java.util.HashMap;
import java.util.Map;

/**
 * StateTransitions
 */
public class StateTransitions implements IStateTransitions {
    private Map<Pair<State, String>, State> transitions = new HashMap<>();

    /**
     * Constructor StateTransitions
     */
    public StateTransitions() {
        transitions.put(new Pair<>(new State("default"), null), new State("default"));
        transitions.put(new Pair<>(new State("default"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("default"), "semicolon"), new State("newline"));
        transitions.put(new Pair<>(new State("default"), "openBracket"), new State("newline"));
        transitions.put(new Pair<>(new State("default"), "closeBracket"), new State("closeBracketState"));

        transitions.put(new Pair<>(new State("newline"), null), new State("default"));
        transitions.put(new Pair<>(new State("newline"), "newLine"), new State("newline"));
        transitions.put(new Pair<>(new State("newline"), "space"), new State("newline"));
        transitions.put(new Pair<>(new State("newline"), "char"), new State("default"));
        transitions.put(new Pair<>(new State("newline"), "openBracket"), new State("newline"));
        transitions.put(new Pair<>(new State("newline"), "closeBracket"), new State("closeBracketState"));

        transitions.put(new Pair<>(new State("closeBracketState"), null), new State("default"));
        transitions.put(new Pair<>(new State("closeBracketState"), "space"), new State("closeBracketState"));
        transitions.put(new Pair<>(new State("closeBracketState"), "openBracket"), new State("newline"));
        transitions.put(new Pair<>(new State("closeBracketState"), "newline"), new State("closeBracketState"));
        transitions.put(new Pair<>(new State("closeBracketState"), "closingBracket"), new State("closeBracketState"));
    }

    @Override
    public State getNextState(final State state, final  IToken token) {
        State nextState =  transitions.get(new Pair<>(state, token.getName()));
        if (nextState == null) {
            nextState =  transitions.get(new Pair<>(state, (String) null));
        }
        return nextState;
    }
}
