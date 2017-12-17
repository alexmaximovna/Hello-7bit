package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.lexer.IStateTransitions;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * StateTransitions
 */
public class StateTransitions implements IStateTransitions {
    private Map<Pair<State, Character>, State> states = new HashMap<>();

    /**
     * Constructor of StateTransitions
     */
    public StateTransitions() {
        states.put(new Pair<>(new State("default"), ' '), new State("spacing"));
        states.put(new Pair<>(new State("default"), '/'), new State("comment"));
        states.put(new Pair<>(new State("default"), ' '),
                new State("spacing"));

        states.put(new Pair<>(new State("commentOneLine"), '\n'), null);
        states.put(new Pair<>(new State("commentOneLine"), null), new State("commentOneLine"));
        states.put(new Pair<>(new State("commentEndMulti"), null), new State("commentMulti"));
        states.put(new Pair<>(new State("commentMulti"), '*'), new State("commentEndMulti"));
        states.put(new Pair<>(new State("commentMulti"), null), new State("commentMulti"));
        states.put(new Pair<>(new State("commentEndMulti"), '/'), null);


        states.put(new Pair<>(new State("comment"), '*'), new State("commentMulti"));
        states.put(new Pair<>(new State("comment"), '/'), new State("commentOneLine"));
        states.put(new Pair<>(new State("comment"), null), null);

       states.put(new Pair<>(new State("spacing"), ' '),
                new State("spacing"));


    }

    /**
     * getNextState
     * @param state state
     * @param c char
     * @return state
     */
    public State getNextState(final State state, final  char c) {
        State nextState =  states.get(new Pair<>(state, c));
        if (nextState == null) {
            nextState =  states.get(new Pair<>(state, (Character) null));
        }
        return nextState;
    }

}
