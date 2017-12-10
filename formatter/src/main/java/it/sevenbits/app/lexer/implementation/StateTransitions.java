package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.lexer.IStateTransitions;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class StateTransitions implements IStateTransitions {
    private Map<Pair<State, Character>, State> states = new HashMap<>();

    public StateTransitions(){
        states.put(new Pair<>(new State("default"),' '),
                new State("spacing"));
        states.put(new Pair<>(new State("spacing"), ' '),
                new State("spacing"));
    }

    public State getNextState(State state, char c) {
        State nextState =  states.get(new Pair<>(state, c));
        if(nextState == null){
            nextState =  states.get(new Pair<>(state,(Character)null));
        }
        return nextState;
    }

}
