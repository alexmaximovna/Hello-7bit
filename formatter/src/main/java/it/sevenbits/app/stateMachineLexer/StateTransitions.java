package it.sevenbits.app.stateMachineLexer;

import java.util.HashMap;

public class StateTransitions {
    private HashMap<StateKey, State> hashMap;
    /**
     *Function of next state
     * @param c char
     * @param state state
     * @return state.
     */
    State nextState(final char c, final State state) {
        if (hashMap.containsKey(new StateKey(state, c))) {
            return hashMap.get(new StateKey(state, c));
        }
        if (hashMap.containsKey(new StateKey(state))) {
            return hashMap.get(new StateKey(state));
        }
        return state;
    }
}
