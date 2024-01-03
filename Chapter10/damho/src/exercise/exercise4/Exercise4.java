package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Exercise4 {
    public static Collection<Integer> makeCollection() {
        Collection<Integer> coll = new ArrayList();
        coll.add(1);
        coll.add(2);
        coll.add(3);
        coll.add(4);
        coll.add(5);
        coll.add(6);
        coll.add(7);
        coll.add(8);
        coll.add(9);
        coll.add(10);
        return coll;
    }

    public static void main(String[] args) {
        Collection<Integer> coll = makeCollection();

        System.out.println("짝수 값 remove :\n" + coll);
        Predicates.remove(coll, x -> (x % 2) == 0);
        System.out.println(coll);

        coll = makeCollection();
        System.out.println("\n\n홀수 값 remove :\n" + coll);
        Predicates.retain(coll, x -> (x % 2) == 0);
        System.out.println(coll);

        coll = makeCollection();
        ArrayList<Integer> list = new ArrayList<>();
        list = Predicates.collect(coll, x -> (x % 2) == 0);
        System.out.println("\n\n짝수 값 list에 옮기기 :");
        System.out.println(list);

        Predicate<Integer> pred = x -> (x % 2) == 0;
        list = new ArrayList<>(coll);
        int i = Predicates.find(list, pred);
        System.out.println("list의 첫 번째 짝수의 위치 : " + i);
    }
}
