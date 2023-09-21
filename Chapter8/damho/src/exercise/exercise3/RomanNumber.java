package Chapter8.damho.src.exercise.exercise3;

import java.util.ArrayList;
import java.util.List;

public class RomanNumber {
    private int intValue;
    private String stringValue;
    private static final List<Character> validRomanNumber = ValidRomanNumber.validRomanNumberList;
    private static final String[] stringArr = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] intArr = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public int getIntValue() {
        return this.intValue;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public void init() {
        if (validRomanNumber.isEmpty()) {
            ValidRomanNumber.init();
        }
    }

    public RomanNumber(String inputString) {
        init();
        if (!inputStringCheck(inputString)) {
            throw new NullPointerException(inputString + "는 유요한 로마숫자가 아닙니다.");
        }
        this.stringValue = inputString;
        // string -> int로 변환
        this.intValue = convertStringToInt(inputString);
    }

    public RomanNumber(int inputInt) {
        init();
        if (inputInt < 0 || inputInt > 3999) {
            throw new NumberFormatException("int형은 0보다 크고 4000보다 작아야 합니다.");
        }
        this.intValue = inputInt;
        // int -> string으로 변환
        this.stringValue = convertIntToString(inputInt);
    }

    private static int convertStringToInt(String inputString) {
        int sum = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (i + 1 < inputString.length()) {
                int smaller = Roman.valueOf(inputString.charAt(i) + "").getIntValue();
                int bigger = Roman.valueOf(inputString.charAt(i + 1) + "").getIntValue();
                if (smaller < bigger) {
                    sum = sum + bigger - smaller;
                    i++;
                    continue;
                }
            }
            sum += Roman.valueOf(inputString.charAt(i) + "").getIntValue();
        }
        return sum;
    }

    private static String convertIntToString(int inputInt) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intArr.length; i++) {
            while (inputInt >= intArr[i]) {
                builder.append(stringArr[i]);
                inputInt -= intArr[i];
            }
        }
        return builder.toString();
    }

    private static boolean isInRomanNumberList(String inputString) {
        char ch;
        for (int i = 0; i < validRomanNumber.size(); i++) {
            ch = inputString.charAt(i);
            if (!validRomanNumber.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean threeSameRomanNumber(String inputString) {
        for (int i = 0; i < inputString.length() - 4; i++) {
            if (inputString.charAt(i) == inputString.charAt(i + 1)
                    && inputString.charAt(i + 1) == inputString.charAt(i + 2)
                    && inputString.charAt(i + 2) == inputString.charAt(i + 3)) {
                return false;
            }
        }

        return true;
    }

    private boolean inputStringCheck(String inputString) {
        if (!isInRomanNumberList(inputString) || !threeSameRomanNumber(inputString)) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return this.getStringValue() + " : " + this.getIntValue();
    }

    static final class ValidRomanNumber {
        private ValidRomanNumber() {
        }

        private static List<Character> validRomanNumberList = new ArrayList<>();

        public static void init() {
            validRomanNumberList.add('M');
            validRomanNumberList.add('D');
            validRomanNumberList.add('C');
            validRomanNumberList.add('L');
            validRomanNumberList.add('X');
            validRomanNumberList.add('V');
            validRomanNumberList.add('I');
        }
    }

    public enum Roman {
        M('M', 1000),
        D('D', 500),
        C('C', 100),
        L('L', 50),
        X('X', 10),
        V('V', 5),
        I('I', 1);

        private final char charValue;
        private final int intValue;

        Roman(char charValue, int intValue) {
            this.charValue = charValue;
            this.intValue = intValue;
        }

        public char getCharValue() {
            return charValue;
        }

        public int getIntValue() {
            return intValue;
        }
    }
}
