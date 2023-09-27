package exercise.exercise2;

import java.util.Set;

public class Muilty implements SetOperator {

    @Override
    public void apply(Set<Integer> B, Set<Integer> result) {
        result.retainAll(B);
    }
}
