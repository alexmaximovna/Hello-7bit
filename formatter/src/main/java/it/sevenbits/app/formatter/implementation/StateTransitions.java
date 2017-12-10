package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.IStateTransitions;
import it.sevenbits.app.token.IToken;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class StateTransitions implements IStateTransitions {
    private Map<Pair<State, String>, State> transitions = new HashMap<>();

    public StateTransitions(){
        transitions.put(new Pair<>(new State("default"), null), new State("default"));
        transitions.put(new Pair<>(new State("default"),"char"),new State("default"));
        transitions.put(new Pair<>(new State("default"),"semicolon"),new State("linestart"));
        transitions.put(new Pair<>(new State("default"), "openBracket"), new State("linestart"));
        transitions.put(new Pair<>(new State("default"), "closeBracket"), new State("closeBracketState"));

        transitions.put(new Pair<>(new State("linestart"), null), new State("default"));
        transitions.put(new Pair<>(new State("linestart"),"newLine"),new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"),"space"),new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"),"char"),new State("default"));
        transitions.put(new Pair<>(new State("linestart"), "openBracket"),new State("linestart"));
        transitions.put(new Pair<>(new State("linestart"), "closeBracket"), new State("closeBracketState"));

        transitions.put(new Pair<>(new State("closeBracketState"), null), new State("default"));
        transitions.put(new Pair<>(new State("closeBracketState"), "space"), new State("closeBracketState"));
        transitions.put(new Pair<>(new State("closeBracketState"), "openBracket"), new State("linestart"));
        transitions.put(new Pair<>(new State("closeBracketState"), "newline"), new State("closeBracketState"));
        transitions.put(new Pair<>(new State("closeBracketState"), "closingBracket"), new State("closeBracketState"));
    }

    @Override
    public State getNextState(State state, IToken token) {
        State nextState =  transitions.get(new Pair<>(state, token.getName()));
        if(nextState == null){
            nextState =  transitions.get(new Pair<>(state,(String)null));
        }
        return nextState;
    }
}
