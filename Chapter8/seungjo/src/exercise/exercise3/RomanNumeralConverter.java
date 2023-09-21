package exercise.exercise3;

public class RomanNumeralConverter {

    public RomanNumeralConverter(String romanNumeral) {
        convertToArabic(romanNumeral);
    }


    public RomanNumeralConverter(int arabicNumber) {

        if (arabicNumber <= 1 || arabicNumber >= 3999) {
            throw new IllegalArgumentException("1 ~ 3999 값 사이를 넘을 수 없습니다!");
        }

        convertToRomanNumeral(arabicNumber);
    }

    private void convertToRomanNumeral(int arabicNumber) {
        StringBuilder sb = new StringBuilder();

        while (arabicNumber > 0) {
            if (arabicNumber >= 1000) {
                sb.append("M");
                arabicNumber -= 1000;
            } else if (arabicNumber >= 900) {
                sb.append("CM");
                arabicNumber -= 900;
            } else if (arabicNumber >= 500) {
                sb.append("D");
                arabicNumber -= 500;
            } else if (arabicNumber >= 400) {
                sb.append("CD");
                arabicNumber -= 400;
            } else if (arabicNumber >= 100) {
                sb.append("C");
                arabicNumber -= 100;
            } else if (arabicNumber >= 90) {
                sb.append("XC");
                arabicNumber -= 90;
            } else if (arabicNumber >= 50) {
                sb.append("L");
                arabicNumber -= 50;
            } else if (arabicNumber >= 40) {
                sb.append("XL");
                arabicNumber -= 40;
            } else if (arabicNumber >= 10) {
                sb.append("X");
                arabicNumber -= 10;
            } else if (arabicNumber >= 9) {
                sb.append("IX");
                arabicNumber -= 9;
            } else if (arabicNumber >= 5) {
                sb.append("V");
                arabicNumber -= 5;
            } else if (arabicNumber >= 4) {
                sb.append("IV");
                arabicNumber -= 4;
            } else if (arabicNumber >= 1) {
                sb.append("I");
                arabicNumber -= 1;
            }
        }
        System.out.println("result: " + sb.toString());
    }

    private void convertToArabic(String romanNumeral) {

        int number = 0;

        for (int i = 0; i < romanNumeral.length(); i++) {
            char letter = romanNumeral.charAt(i);
            char nextLetter = ' ';
            if (i < romanNumeral.length() - 1) {
                nextLetter = romanNumeral.charAt(i + 1);
            }

            switch (letter) {
                case 'M':
                    number += 1000;
                    break;

                case 'C':
                    if (nextLetter == 'M') {
                        number += 900;
                        i++;
                    } else if (nextLetter == 'D') {
                        number += 400;
                        i++;
                    } else {
                        number += 100;
                    }
                    break;

                case 'D':
                    number += 500;
                    break;

                case 'X':
                    if (nextLetter == 'C') {
                        number += 90;
                        i++;
                    } else if (nextLetter == 'L') {
                        number += 40;
                        i++;
                    } else {
                        number += 10;
                    }
                    break;

                case 'L':
                    number += 50;
                    break;

                case 'I':
                    if (nextLetter == 'X') {
                        number += 9;
                        i++;
                    } else if (nextLetter == 'V') {
                        number += 4;
                        i++;
                    } else {
                        number += 1;
                    }
                    break;

                case 'V':
                    number += 5;
                    break;

                default:
                    throw new IllegalArgumentException("잘못된 문자를 입력하였습니다!");

            }
        }

        System.out.println("result: " + number);
    }

}
