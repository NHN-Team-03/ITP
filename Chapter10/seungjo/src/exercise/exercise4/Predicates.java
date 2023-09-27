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
            T element = iterator.next();
            if (pred.test(element)) {
                iterator.remove();
            }
        }

        // pred.test(obj)가 true인 경우 coll에서 모든 객체 obj를 제거합니다.
        // (이는 coll.removeIf(pred)와 동일한 작업을 수행합니다.)
    }

    public static <T> void retain(Collection<T> coll, Predicate<T> pred) {

        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (!(pred.test(element))) {
                iterator.remove();
            }
        }
        // pred.test(obj)가 false인 경우 coll에서 모든 객체 obj를 제거합니다.
        // (즉, 예측값이 true인 경우 객체를 유지합니다.)
    }

    public static <T> List<T> collect(Collection<T> coll, Predicate<T> pred) {

        List<T> list = new ArrayList<>();

        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (pred.test(element)) {
                list.add(element);
            }
        }
        return list;

        // pred.test(obj)가 true인 경우 컬렉션 coll에서 obj를 포함하는 List를 반환합니다.
    }

    public static <T> int find(ArrayList<T> list, Predicate<T> pred) {

        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            if (pred.test(item)) {
                return i;
            }
        }

        return -1;

        // 예측값이 true인 경우 list에서 첫 번째 항목의 인덱스를 반환합니다.
        // 그런 항목이 없는 경우 -1을 반환합니다.
    }
}
