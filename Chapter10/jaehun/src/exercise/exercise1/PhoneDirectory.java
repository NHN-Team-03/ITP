package exercise.exercise1;

import java.util.Map;
import java.util.TreeMap;

public class PhoneDirectory {
    private Map<String, String> pDirectory;

    public PhoneDirectory() {
        pDirectory = new TreeMap<>();
    }

    private Map<String, String> getPDirectory() {
        return pDirectory;
    }

    public void add(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("null값이 입력되었습니다.");
        }
        this.getPDirectory().put(name, number);
    }

    public String get(String name) {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("전화번호부가 비어있습니다.");
        }
        if (pDirectory.get(name) == null) {
            System.out.println("검색 결과가 없습니다.");
            return null;
        }

        return pDirectory.get(name);
    }

    private boolean isEmpty() {
        return this.getPDirectory().size() == 0;
    }

    public void printDirectory() {
        if (this.isEmpty()) {
            System.out.println("전화번호부가 비어 있습니다.");
        } else {
            System.out.println("====================");
            for (Map.Entry<String, String> entry : this.getPDirectory().entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }
            System.out.println("====================");
        }

    }
}
