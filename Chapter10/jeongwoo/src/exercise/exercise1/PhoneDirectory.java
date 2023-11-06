package exercise.exercise1;

import java.util.TreeMap;

public class PhoneDirectory {
    private TreeMap<String, String> data;

    public PhoneDirectory() {
        data = new TreeMap<>();
    }

    private boolean find(String name) {
        if (data.isEmpty()) {
            return false;
        } else {
            return data.get(name) != null;
        }
    }

    public void putNumber(String name, String number) {
        if (name == null || number == null) {
            throw new IllegalArgumentException("name && number cannot be null");
        }

        if (find(name)) {
            System.out.println("이미 있는 이름입니다. 전화번호를 갱신합니다.");
            data.replace(name, number);
        } else {
            data.put(name, number);
        }
    }

    public void printPhoneDirectory() {
        if (data.isEmpty()) {
            System.out.println("아무것도 존재 하지 않습니다.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String name : data.keySet()) {
            stringBuilder.append(name + " : " + data.get(name) + "\n");
        }
        System.out.println(stringBuilder);
    }
}
