package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Predicates {
    public static <T> void remove(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                iterator.remove();
            }
        }
    }
    // Remove every object, obj, from coll for which pred.test(obj)
    // is true. (This does the same thing as coll.removeIf(pred).)

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (!pred.test(item)) {
                iterator.remove();
            }
        }
    }
    // Remove every object, obj, from coll for which
    // pred.test(obj) is false. (That is, retain the
    // objects for which the predicate is true.)

    public static <T> ArrayList<T> collect(Collection<T> coll, Predicate<T> pred) {
        ArrayList<T> list = new ArrayList<>();
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            if (pred.test(item)) {
                list.add(item);
            }
        }
        return list;
    }
    // Return a List that contains all the objects, obj,
    // from the collection, coll, such that pred.test(obj)
    // is true.

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            if (pred.test(item)) {
                return i;
            }
        }
        return -1;
    }
    // Return the index of the first item in list
    // for which the predicate is true, if any.
    // If there is no such item, return -1.
}
