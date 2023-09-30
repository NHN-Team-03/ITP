package exercise.exercise2;

import java.util.Set;
import java.util.TreeSet;

public class Minus implements SetOperator{
    @Override
    public void apply(Set<Integer> B, Set<Integer> result) {
        result.removeAll(B);
    }
}
