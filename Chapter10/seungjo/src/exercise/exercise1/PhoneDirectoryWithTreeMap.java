package exercise.exercise1;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectoryWithTreeMap {

    private TreeMap<String, String> data;

    public PhoneDirectoryWithTreeMap() {
        data = new TreeMap<>();
    }

    public String getNumber(String name) {
        return data.get(name);
    }

    public void putNumber(String name, String number) {
        if (number == null || name == null) {
            throw new IllegalArgumentException("null값은 들어올 수 없습니다.");
        }

        data.put(name, number);
    }

    public void print() {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
