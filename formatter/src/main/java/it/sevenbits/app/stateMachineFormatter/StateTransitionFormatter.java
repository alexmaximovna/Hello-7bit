package it.sevenbits.app.stateMachineFormatter;


import javafx.util.Pair;
import java.util.HashMap;

/**
 * Class of StateTransitionFormatter
 */
public class StateTransitionFormatter {
    private final HashMap<Pair<State, String>, State> transitions ;
    /**
     * Transitions for StateMachine
     */
    public StateTransitionFormatter() {
        transitions = new HashMap<>();
        State defaultState = new State("DEFAULT");
        State spaceState = new State("SpaceState");
        State semicolonState = new State("SemicolonState");
        State openBracketState = new State("OpenBracketState");
        State closeBracketState = new State("CloseBracketState");
        State lineStart = new State("LineStart");
        String space = "Space";
        String semicolon = "Semicolon";
        String newLine = "newLine";
        String openBracket = "OpenBracket";
        String closeBracket = "CloseBracket";
        String oneLineComment = "OneLineComment";
        String multipleLineComment = "MultipleLineComment";
        String charSymb = "Char";
        String string = "STRING";

        //DefaultState
        transitions.put(new Pair<>(defaultState, space), spaceState);
        transitions.put(new Pair<>(defaultState, semicolon), semicolonState);
        transitions.put(new Pair<>(defaultState, newLine), defaultState);
        transitions.put(new Pair<>(defaultState, openBracket), openBracketState);
        transitions.put(new Pair<>(defaultState, closeBracket), closeBracketState);
        transitions.put(new Pair<>(defaultState, oneLineComment), defaultState);
        transitions.put(new Pair<>(defaultState, multipleLineComment), defaultState);
        transitions.put(new Pair<>(defaultState, charSymb), defaultState);
        transitions.put(new Pair<>(defaultState, string), defaultState);
        //SpaceState
        transitions.put(new Pair<>(spaceState, space), spaceState);
        transitions.put(new Pair<>(spaceState, semicolon), semicolonState);
        transitions.put(new Pair<>(spaceState, newLine), defaultState);
        transitions.put(new Pair<>(spaceState, openBracket), openBracketState);
        transitions.put(new Pair<>(spaceState, closeBracket), closeBracketState);
        transitions.put(new Pair<>(spaceState, oneLineComment), defaultState);
        transitions.put(new Pair<>(spaceState, multipleLineComment), defaultState);
        transitions.put(new Pair<>(spaceState, charSymb), defaultState);
        transitions.put(new Pair<>(spaceState, string), defaultState);
        //SemicolonState
        transitions.put(new Pair<>(semicolonState, space), spaceState);
        transitions.put(new Pair<>(semicolonState, semicolon), semicolonState);
        transitions.put(new Pair<>(semicolonState, newLine), defaultState);
        transitions.put(new Pair<>(semicolonState, openBracket), openBracketState);
        transitions.put(new Pair<>(semicolonState, closeBracket), closeBracketState);
        transitions.put(new Pair<>(semicolonState, oneLineComment), defaultState);
        transitions.put(new Pair<>(semicolonState, multipleLineComment), defaultState);
        transitions.put(new Pair<>(semicolonState, charSymb), defaultState);
        transitions.put(new Pair<>(semicolonState, string), defaultState);
        //OpenBracketState
        transitions.put(new Pair<>(openBracketState, space), spaceState);
        transitions.put(new Pair<>(openBracketState, semicolon), semicolonState);
        transitions.put(new Pair<>(openBracketState, newLine), defaultState);
        transitions.put(new Pair<>(openBracketState, openBracket), openBracketState);
        transitions.put(new Pair<>(openBracketState, closeBracket), closeBracketState);
        transitions.put(new Pair<>(openBracketState, oneLineComment), defaultState);
        transitions.put(new Pair<>(openBracketState, multipleLineComment), defaultState);
        transitions.put(new Pair<>(openBracketState, charSymb), defaultState);
        transitions.put(new Pair<>(openBracketState, string), defaultState);
        //CloseBracketState
        transitions.put(new Pair<>(closeBracketState, space), spaceState);
        transitions.put(new Pair<>(closeBracketState, semicolon), semicolonState);
        transitions.put(new Pair<>(closeBracketState, newLine), defaultState);
        transitions.put(new Pair<>(closeBracketState, openBracket), openBracketState);
        transitions.put(new Pair<>(closeBracketState, closeBracket), closeBracketState);
        transitions.put(new Pair<>(closeBracketState, oneLineComment), defaultState);
        transitions.put(new Pair<>(closeBracketState, multipleLineComment), defaultState);
        transitions.put(new Pair<>(closeBracketState, charSymb), defaultState);
        transitions.put(new Pair<>(closeBracketState, string), defaultState);
        //LineStart
        transitions.put(new Pair<>(lineStart, space), spaceState);
        transitions.put(new Pair<>(lineStart, semicolon), semicolonState);
        transitions.put(new Pair<>(lineStart, newLine), defaultState);
        transitions.put(new Pair<>(lineStart, openBracket), openBracketState);
        transitions.put(new Pair<>(lineStart, closeBracket), closeBracketState);
        transitions.put(new Pair<>(lineStart, oneLineComment), defaultState);
        transitions.put(new Pair<>(lineStart, multipleLineComment), defaultState);
        transitions.put(new Pair<>(lineStart, charSymb), defaultState);
        transitions.put(new Pair<>(lineStart, string), defaultState);


    }
    State nextState(final State state, final char c) {


        if (transitions.containsKey(new Pair<>(state, c))) {
            return transitions.get(new Pair<>(state, c));
        } else {
            return transitions.get(new Pair<>(state, (Character) null));
        }
    }

}
