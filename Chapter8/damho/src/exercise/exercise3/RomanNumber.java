package Chapter8.damho.src.exercise.exercise3;

public class RomanNumber {
    private int intValue;
    private String stringValue;
    private static final String[] stringArr = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    private static final int[] intArr = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

    public int getIntValue() {
        return this.intValue;
    }

    public String getStringValue() {
        return this.stringValue;
    }

    public RomanNumber(String inputString) {
        if (!inputStringCheck(inputString)) {
            throw new NumberFormatException(inputString + "는 유효한 로마숫자가 아닙니다.");
        }
        this.stringValue = inputString;
        // string -> int로 변환
        this.intValue = convertStringToInt(inputString);
    }

    public RomanNumber(int inputInt) {
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

    private boolean inputStringCheck(String inputString) {
        if (!isInRomanNumberList(inputString) || !isSameRomanNumber(inputString)) {
            return false;
        } 
        return true;
    }

    private static boolean isInRomanNumberList(String inputString) {
        char ch;
        for (int i = 0; i < inputString.length(); i++) {
            ch = inputString.charAt(i);
            if (!isRomanNumber(ch)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRomanNumber(char ch) {
        for (Roman r : Roman.values()) {
            if (ch == r.getCharValue()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSameRomanNumber(String inputString) {
        for (int i = 0; i < inputString.length() - 4; i++) {
            char first = inputString.charAt(i);
            char second = inputString.charAt(i + 1);
            char third = inputString.charAt(i + 2);
            char fourth = inputString.charAt(i + 3);
            if (first == second && second == third && third == fourth) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getStringValue() + " : " + this.getIntValue();
    }
}
