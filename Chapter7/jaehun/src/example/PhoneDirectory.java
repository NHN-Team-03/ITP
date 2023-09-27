package example;

import java.util.Arrays;

public class PhoneDirectory {
    private static class PhoneEntry{
        String name;
        String phoneNumber;

        public PhoneEntry(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }

    private PhoneEntry[] data;
    private int dataCount;

    public PhoneDirectory() {
        data = new PhoneEntry[1];
        dataCount = 0;
    }

    private int find(String name) {
        for(int index = 0; index < dataCount; index++) {
            if(data[index].name.equals(name)) {
                return index;
            }
        }

        return -1;
    }

    public String getNumber(String name) {
        int position = find(name);
        if(position >= 0) {
            return data[position].phoneNumber;
        }
        return null;
    }

    public void putNumber(String name, String phoneNumber) {
        if(name == null || phoneNumber == null) {
            throw new IllegalArgumentException("이름과 전화번호는 null값 일 수 없습니다.");
        }

        int index = find(name);
        if(index >= 0) {
            data[index].phoneNumber = phoneNumber;
        } else {
            if(dataCount == data.length) {
                data = Arrays.copyOf(data, 2 * data.length);
            }
            PhoneEntry newPhone = new PhoneEntry(name, phoneNumber);
            data[dataCount++] = newPhone; 
        }
    }
}