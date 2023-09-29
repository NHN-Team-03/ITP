package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Exercise4 {

    /**
     * For convenience make a Collection containing some integers.  The Collection
     * is actually a TreeSet, but that is not relevant to the main program.
     */
    static Collection<Integer> makeSet() {
        Collection<Integer> set = new TreeSet<Integer>();
        set.add(Integer.valueOf(32));
        set.add(Integer.valueOf(17));
        set.add(Integer.valueOf(142));
        set.add(Integer.valueOf(56));
        set.add(Integer.valueOf(1899));
        set.add(Integer.valueOf(57));
        set.add(Integer.valueOf(999));
        set.add(Integer.valueOf(86));
        set.add(Integer.valueOf(83));
        set.add(Integer.valueOf(100));
        return set;
    } // end makeSet()

    /**
     * Main routine tests the Predicates class by making Collections of Integers
     * and applying the methods from the Predicates class to them.
     */
    public static void main(String[] args) {

        Collection<Integer> coll;

        Predicate<Integer> pred = i -> (i % 2 == 0);

        coll = makeSet();
        System.out.println("Collection: " + coll);

        System.out.println("\n[Collection - Predicate(Even)]");
        Predicates.remove(coll, pred);
        System.out.println("짝수 제거: " + coll);

        coll = makeSet();
        Predicates.retain(coll, pred);
        System.out.println("짝수 유지: " + coll);


        System.out.println("\n[Collection - Predicate(Odd)]");
        pred = i -> (i % 2 == 1);
        coll = makeSet();
        Predicates.remove(coll, pred);
        System.out.println("홀수 제거: " + coll);

        coll = makeSet();
        Predicates.retain(coll, pred);
        System.out.println("홀수 유지: " + coll);

        System.out.println("\n[Collection - Predicate(n > 100)]");
        pred = n -> (n > 100);
        coll = makeSet();
        Predicates.remove(coll, pred);
        System.out.println("100보다 큰 수 제거: " + coll);

        coll = makeSet();
        Predicates.retain(coll, pred);
        System.out.println("100보다 큰 수 유지: " + coll);

        coll = makeSet();
        List<Integer> result = Predicates.collect(coll, pred);
        System.out.println("100보다 큰 수 " + result);

        coll = makeSet();
        ArrayList<Integer> list = new ArrayList<>(coll);
        int index = Predicates.find(list, pred);
        System.out.println("100보다 큰 첫 번째 수의 인덱스 : " + index);


    }

}