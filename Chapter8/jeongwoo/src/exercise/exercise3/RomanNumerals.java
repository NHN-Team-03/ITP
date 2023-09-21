package exercise.exercise3;


public class RomanNumerals {

    private String romanNumerals;
    private int arabicNumerals;
    private final static String regExp = "^[A-Z]*$";

    public RomanNumerals(String romanNumerals) {
        if (!romanNumerals.matches(regExp)) {
            throw new NumberFormatException("문자가 아닌 값들이 포함되어 있습니다.");
        }
        convertRomalToArabic(romanNumerals);

        if (1 >= this.arabicNumerals || this.arabicNumerals >= 3999) {
            throw new NumberFormatException("1~3999의 값이 입력되어야 합니다.");
        }
    }

    public RomanNumerals(int arabicNumerals) {
        if (1 >= arabicNumerals || arabicNumerals >= 3999) {
            throw new NumberFormatException("1~3999을 넘는 로마 표기법입니다.");
        }
        convertArabicToRomal(arabicNumerals);
    }

    private void convertRomalToArabic(String romanNumerals) {
        this.arabicNumerals = 0;
        for (int i = 0; i < romanNumerals.length(); i++) {
            char one = romanNumerals.charAt(i);
            switch (one) {
                case 'M':
                    this.arabicNumerals += 1000;
                    break;
                case 'D':
                    this.arabicNumerals += 500;
                    break;
                case 'C':
                    if (i != romanNumerals.length() - 1) {
                        if (romanNumerals.charAt(i + 1) == 'M') {
                            this.arabicNumerals += 900;
                            i++;
                            break;
                        } else if (romanNumerals.charAt(i + 1) == 'D') {
                            this.arabicNumerals += 400;
                            i++;
                            break;
                        }
                    }
                    this.arabicNumerals += 100;
                    break;
                case 'L':
                    this.arabicNumerals += 50;
                    break;
                case 'X':
                    if (i != romanNumerals.length() - 1) {
                        if (romanNumerals.charAt(i + 1) == 'C') {
                            this.arabicNumerals += 90;
                            i++;
                            break;
                        } else if (romanNumerals.charAt(i + 1) == 'L') {
                            this.arabicNumerals += 40;
                            i++;
                            break;
                        }
                    }
                    this.arabicNumerals += 10;
                    break;
                case 'V':
                    this.arabicNumerals += 5;
                    break;
                case 'I':
                    if (i != romanNumerals.length() - 1) {
                        if (romanNumerals.charAt(i + 1) == 'X') {
                            this.arabicNumerals += 9;
                            i++;
                            break;
                        } else if (romanNumerals.charAt(i + 1) == 'V') {
                            this.arabicNumerals += 4;
                            i++;
                            break;
                        }
                    }
                    this.arabicNumerals += 1;
                    break;
                default:
                    throw new IllegalArgumentException("로마 표기법이 아닌 문자가 포함되어 있습니다.");
            }
        }
    }

    public String toString() {
        return this.romanNumerals;
    }

    public int toInt() {
        return this.arabicNumerals;
    }

    private void convertArabicToRomal(int arabicNumerals) {
        this.romanNumerals = "";
        while (arabicNumerals != 0) {
            if (arabicNumerals >= 1000) {
                arabicNumerals -= 1000;
                this.romanNumerals += "M";
            } else if (arabicNumerals >= 900) {
                arabicNumerals -= 900;
                this.romanNumerals += "CM";
            } else if (arabicNumerals >= 500) {
                arabicNumerals -= 500;
                this.romanNumerals += "D";
            } else if (arabicNumerals >= 400) {
                arabicNumerals -= 400;
                this.romanNumerals += "CD";
            } else if (arabicNumerals >= 100) {
                arabicNumerals -= 100;
                this.romanNumerals += "C";
            } else if (arabicNumerals >= 90) {
                arabicNumerals -= 90;
                this.romanNumerals += "XC";
            } else if (arabicNumerals >= 50) {
                arabicNumerals -= 50;
                this.romanNumerals += "L";
            } else if (arabicNumerals >= 40) {
                arabicNumerals -= 40;
                this.romanNumerals += "XL";
            } else if (arabicNumerals >= 10) {
                arabicNumerals -= 10;
                this.romanNumerals += "X";
            } else if (arabicNumerals >= 9) {
                arabicNumerals -= 9;
                this.romanNumerals += "IX";
            } else if (arabicNumerals >= 5) {
                arabicNumerals -= 5;
                this.romanNumerals += "V";
            } else if (arabicNumerals >= 4) {
                arabicNumerals -= 4;
                this.romanNumerals += "IV";
            } else if (arabicNumerals >= 1) {
                arabicNumerals -= 1;
                this.romanNumerals += "I";
            }
        }
    }
}
