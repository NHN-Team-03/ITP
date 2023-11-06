package exercise.exercise4;

import java.util.ArrayList;
import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(9);

        Predicates.remove(list, x -> x % 2 == 0);
        Predicates.retain(list, x -> x % 2 == 0);
        List<Integer> list2 = Predicates.collect(list, x -> x == 9);

        for (int i : list2) {
            System.out.println(i);
        }

        Predicate<Integer> pred = (x) -> x == 1;
        System.out.println(Predicates.find((ArrayList) list, pred));

        for (int i : list) {
            System.out.println(i);
        }

    }
}
