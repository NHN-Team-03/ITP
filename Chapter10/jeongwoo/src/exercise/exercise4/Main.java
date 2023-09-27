package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Main {
    private static Collection<Integer> data;

    public static void main(String[] args) {
        predicateTest();
    }

    private static void makeData() {
        data = new TreeSet<>();
        data.add(1);
        data.add(4);
        data.add(5);
        data.add(8);
        data.add(3);
        data.add(9);
        data.add(13);
        data.add(236);
        data.add(63);
        data.add(52);
        data.add(732);
        data.add(36);
        data.add(1326);

    }

    private static void predicateTest() {
        makeData();

        removeTest();
        retainTest();
        collectTest();
        findTest();
    }

    private static void removeTest() {
        Collection<Integer> testColl = new TreeSet<>(data);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("remove Test\n");
        stringBuilder.append(testColl + "\n");
        Predicate<Integer> pred = x -> (x % 2 == 0);
        Predicates.remove(testColl, pred);
        stringBuilder.append(testColl + "\n");
        System.out.println(stringBuilder);
    }

    private static void retainTest() {
        Collection<Integer> testColl = new TreeSet<>(data);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("retain Test\n");
        stringBuilder.append(testColl + "\n");
        Predicate<Integer> pred = x -> (x % 2 == 0);
        Predicates.retain(testColl, pred);
        stringBuilder.append(testColl + "\n");
        System.out.println(stringBuilder);
    }

    private static void collectTest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("collect Test\n");
        Collection<Integer> testColl;
        Predicate<Integer> pred = x -> (x % 2 != 0);
        testColl = Predicates.collect(data, pred);
        stringBuilder.append(testColl + "\n");
        System.out.println(stringBuilder);
    }

    private static void findTest() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("find Test\n");
        ArrayList<Integer> testColl = new ArrayList<>(data);
        Predicate<Integer> pred = x -> (x % 2 == 0);

        int index = Predicates.find(testColl, pred);
        stringBuilder.append(testColl.get(index) + "\n");
        System.out.println(stringBuilder);
    }

}
