package it.sevenbits.app.stateMachineFormatter;

/**
 * class State
 */
public class State {

        private String string;

        /**
         * Constructor of State.
         * @param c string.
         *
         */
        State(final String c) {
            this.string = c;
        }
        /**
         *
         * @param o Object.
         * @return true/false.
         */
        @Override
        public final boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state1 = (State) o;
            return string.equals(state1.string);
        }
        /**
         * hashCode.
         * @return int.
         */
        @Override
        public final int hashCode() {
            return string.hashCode();
        }



}
