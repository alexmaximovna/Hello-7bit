package it.sevenbits.app;

import java.util.Objects;

/**
 *
 * @param <F> type of first elem
 * @param <S> type of second elem
 */
public class Pair<F, S> {
    private F first;
    private S second;

    /**
     *
     * @param first first element of pair
     * @param second second element of pair
     */
    public Pair(final F first, final S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) {
            return false;
        }
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    @Override
    public int hashCode() {

        return Objects.hash(first, second);
    }
}
