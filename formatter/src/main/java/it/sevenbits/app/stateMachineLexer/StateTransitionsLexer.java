package it.sevenbits.app.stateMachineLexer;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * State transitions
 */
public class StateTransitionsLexer {

   // private static State startState = new State("START");
    private final Map<Pair<State, Character>, State> hashMap;

    /**
     *Transition for StateLexer
     */
    public StateTransitionsLexer() {
        hashMap = new HashMap<>();
        State defaultState = new State("DEFAULT");
        State spaceState = new State("SPACING");
        State reservedState = new State("RESERVED");
       //For DEFAULT
        hashMap.put(new Pair<>(defaultState, '{'), reservedState);
        hashMap.put(new Pair<>(defaultState, '}'), reservedState);
        hashMap.put(new Pair<>(defaultState, ';'), reservedState);
        hashMap.put(new Pair<>(defaultState, '\n'), reservedState);
        hashMap.put(new Pair<>(defaultState, '\t'), reservedState);

        hashMap.put(new Pair<>(defaultState, '{'), spaceState);
        hashMap.put(new Pair<>(defaultState, '}'), spaceState);
        hashMap.put(new Pair<>(defaultState, ';'), spaceState);
        hashMap.put(new Pair<>(defaultState, '\n'), spaceState);
        hashMap.put(new Pair<>(defaultState, '\t'), spaceState);
       //For SPACING
        hashMap.put(new Pair<>(spaceState, '{'), defaultState);
        hashMap.put(new Pair<>(spaceState, '}'), defaultState);
        hashMap.put(new Pair<>(spaceState, ';'), defaultState);
        hashMap.put(new Pair<>(spaceState, '\n'), defaultState);
        hashMap.put(new Pair<>(spaceState, '\t'), defaultState);

        hashMap.put(new Pair<>(spaceState, '{'), reservedState);
        hashMap.put(new Pair<>(spaceState, '}'), reservedState);
        hashMap.put(new Pair<>(spaceState, ';'), reservedState);
        hashMap.put(new Pair<>(spaceState, '\n'), reservedState);
        hashMap.put(new Pair<>(spaceState, '\t'), reservedState);


    }
    /**
     * Method to get next state by state and next char
     * @param state state,
     * @param c next char,
     * @return returns next state.
     */
    State nextState(final State state, final char c) {
        if (hashMap.containsKey(new Pair<>(state, c))) {
            return hashMap.get(new Pair<>(state, c));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

}
