package exercise.exercise3;

enum Roman {
    M("M", 1000),
    CM("CM", 900),
    D("D", 500),
    CD("CD", 400),
    C("C", 100),
    XC("XC", 90),
    L("L", 50),
    XL("XL", 40),
    X("X", 10),
    IX("IX", 9),
    V("V", 5),
    IV("IV", 4),
    I("I", 1);

    private String roma;
    private int value;

    Roman(String roma, int value) {
        this.roma = roma;
        this.value = value;
    }

    public String getRoma() {
        return roma;
    }

    public int getValue() {
        return value;
    }
}

public class RomanNumeral {
    private String roman;
    private int arabic;

    public RomanNumeral(String roman) {
        stringCheck(roman);
        this.init(roman, romanToArabic(roman));
    }

    public RomanNumeral(int arabic) {
        if (arabic > 3999 || arabic < 1) {
            throw new NumberFormatException("아라비아 숫자의 범위가 벗어났습니다.");
        }
        this.init(arabicToRoman(arabic), arabic);
    }

    private void init(String roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    private void stringCheck(String roman) {
        boolean check;

        for (char c : roman.toCharArray()) {
            check = true;
            for (Roman r : Roman.values()) {
                if (c == r.getRoma().charAt(0)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                throw new NumberFormatException("잘못 된 로마 숫자입니다.");
            }
        }

    }

    public String getRoman() {
        return this.roman;
    }

    public int getArabic() {
        return this.arabic;
    }

    private int romanToArabic(String roman) {
        int result = 0;
        StringBuilder sb = new StringBuilder(roman);

        for (Roman roma : Roman.values()) {
            while (true) {
                if (sb.length() < roma.getRoma().length()
                        || !sb.substring(0, roma.getRoma().length()).equals(roma.getRoma())) {
                    break;
                }

                result += roma.getValue();
                sb.delete(0, roma.getRoma().length());
            }
        }

        return result;
    }

    private String arabicToRoman(int arabic) {
        StringBuilder result = new StringBuilder();

        for (Roman roma : Roman.values()) {
            while (arabic >= roma.getValue()) {
                result.append(roma.getRoma());
                arabic -= roma.getValue();
            }
        }

        return result.toString();
    }

    @Override
    public String toString() {
        return getRoman();
    }

    public int toInt() {
        return getArabic();
    }

}
