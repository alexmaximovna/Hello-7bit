package it.sevenbits.app.stateMachineLexer;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Class of CommandRepository
 */
public class CommandRepository {
    private Map<Pair<State, Character>, Command> hashMap;
    private char c;
    /**
     * Constructor CommandRepository
     */
    CommandRepository() {
        hashMap = new HashMap<>();
        State startState = new State("START");
        State defaultState = new State("DEFAULT");
        State spaceState = new State("SPACE");
        State reservedState = new State("RESERVED");

        Command append = new Command("Append");
        Command postpone = new Command("POSTPONE");
        Command finish = new Command("FINISH");
        Command pass = new Command("PASS");
        if (Character.isLetter(c)) {
            hashMap.put(new Pair<>(startState, c), postpone);
            hashMap.put(new Pair<>(defaultState, '/'), postpone);
        } else {
            hashMap.put(new Pair<>(startState, (Character) null), append);
            hashMap.put(new Pair<>(startState, (char) -1), pass);
            hashMap.put(new Pair<>(reservedState, (Character) null), finish);
            hashMap.put(new Pair<>(defaultState, ' '), finish);
            hashMap.put(new Pair<>(defaultState, '\n'), finish);
            hashMap.put(new Pair<>(defaultState, '\t'), finish);
            hashMap.put(new Pair<>(defaultState, '{'), finish);
            hashMap.put(new Pair<>(defaultState, '}'), finish);
            hashMap.put(new Pair<>(defaultState, ';'), finish);
            hashMap.put(new Pair<>(defaultState, '/'), finish);
            hashMap.put(new Pair<>(defaultState, (Character) null), append);
            hashMap.put(new Pair<>(spaceState, ' '), append);
            hashMap.put(new Pair<>(spaceState, (Character) null), finish);
        }


    }
    /**
     * Method to get  command
     * @param state state,
     * @param symbol char,
     * @return returns next command.
     */
    Command getCommand(final State state, final char symbol) {
        if (hashMap.containsKey(new Pair<>(state, symbol))) {
            return hashMap.get(new Pair<>(state, symbol));
        } else {
            return hashMap.get(new Pair<>(state, (Character) null));
        }
    }

}
