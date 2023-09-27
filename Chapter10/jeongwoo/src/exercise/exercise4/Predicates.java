package exercise.exercise4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Predicates<T> {

    public static <T> void remove(Collection<T> collection, Predicate<T> predicate) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (predicate.test(data))
                iterator.remove();
        }
    }

    public static <T> void retain(Collection<T> collection, Predicate<T> predicate) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            T data = iterator.next();
            if (!predicate.test(data))
                iterator.remove();
        }
    }

    public static <T> List<T> collect(Collection<T> collection, Predicate<T> predicate) {
        List<T> list = new ArrayList<>();
        for(T data : collection){
            if(predicate.test(data))
                list.add(data);
        }
        return list;
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> predicate) {
        for(int i= 0;i<list.size();i++){
            T data = list.get(i);
            if(predicate.test(data)){
                return i;
            }
        }

        return -1;
    }

}
