package exercise.exercise3;

public class RomanConvert {

    private static int[] intToArabic = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] arabicToInt = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "X", "V", "IV", "I"};

    public RomanConvert(String arabic) {
        calcArabic(arabic);
    }


    public RomanConvert(int integer) {

        if (integer <= 1 || integer >= 3999) {
            throw new IllegalArgumentException("1 ~ 3999 값 사이를 넘을 수 없습니다!");
        }

        calcNumber(integer);
    }

    private void calcNumber(int integer) {
        StringBuilder sb = new StringBuilder();

        while (integer > 0) {
            if (integer >= 1000) {
                sb.append("M");
                integer -= 1000;
            } else if (integer >= 900) {
                sb.append("CM");
                integer -= 900;
            } else if (integer >= 500) {
                sb.append("D");
                integer -= 500;
            } else if (integer >= 400) {
                sb.append("CD");
                integer -= 400;
            } else if (integer >= 100) {
                sb.append("C");
                integer -= 100;
            } else if (integer >= 90) {
                sb.append("XC");
                integer -= 90;
            } else if (integer >= 50) {
                sb.append("L");
                integer -= 50;
            } else if (integer >= 40) {
                sb.append("XL");
                integer -= 40;
            } else if (integer >= 10) {
                sb.append("X");
                integer -= 10;
            } else if (integer >= 9) {
                sb.append("IX");
                integer -= 9;
            } else if (integer >= 5) {
                sb.append("V");
                integer -= 5;
            } else if (integer >= 4) {
                sb.append("IV");
                integer -= 4;
            } else if (integer >= 1) {
                sb.append("I");
                integer -= 1;
            }
        }
        System.out.println("result: " + sb.toString());
    }

    private void calcArabic(String arabic) {

        int number = 0;

        for (int i = 0; i < arabic.length(); i++) {
            char letter = arabic.charAt(i);
            char nextLetter = ' ';
            if (i < arabic.length() - 1) {
                nextLetter = arabic.charAt(i + 1);
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
