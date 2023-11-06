package exercise.exercise2;

import java.util.Set;

public class Plus implements SetOperator {

    @Override
    public void apply(Set<Integer> B, Set<Integer> result) {
        result.addAll(B);
    }
}
