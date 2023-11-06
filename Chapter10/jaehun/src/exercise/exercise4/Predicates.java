package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Predicates {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();

        while (iter.hasNext()) {
            if (pred.test(iter.next())) {
                iter.remove();
            }
        }
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iter = coll.iterator();

        while (iter.hasNext()) {
            if (!pred.test(iter.next())) {
                iter.remove();
            }
        }
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T item : coll) {
            if (pred.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); i++) {
            if (pred.test(list.get(i))) {
                return i;
            }
        }

        return -1;
    }
}

interface Predicate<T> {
    boolean test(T obj);
}
