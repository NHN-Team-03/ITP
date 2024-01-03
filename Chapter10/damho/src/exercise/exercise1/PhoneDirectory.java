package exercise.exercise1;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class PhoneDirectory { // 이름을 기준으로 오름차순 정렬이 되지만 동명이인인 case를 처리하지 못함.
    private TreeMap<String, String> phoneEntry;
    private static String phoneNumPattern1 = "^010(?:[0-9]{8})$";
    private static String phoneNumPattern2 = "^010-(?:[0-9]{4})-(?:[0-9]{4})$";

    public PhoneDirectory() {
        this.phoneEntry = new TreeMap<>();
    }

    public void putPhoneEntry(String name, String phoneNum) {
        if (name == null || phoneNum == null) {
            throw new IllegalArgumentException("name or phoneNum은 null일 수 없습니다.");
        }
        // phoneNum은 010xxxxxxxx 형식으로 입력
        if (Pattern.matches(phoneNumPattern1, phoneNum)) {
            phoneEntry.put(name, phoneNum);
            return;
        }

        if (Pattern.matches(phoneNumPattern2, phoneNum)) {
            String newPhoneNum = changePhoneNum(phoneNum);
            phoneEntry.put(name, newPhoneNum);
            return;
        }

        System.out.println(phoneNum + "는 유효하지 않은 전화번호");
    }

    private String changePhoneNum(String phoneNum) {
        return phoneNum.replace("-", "");
    }

    public void printPhoneEntry() {
        Set<Map.Entry<String, String>> entries = phoneEntry.entrySet();
        for (Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
