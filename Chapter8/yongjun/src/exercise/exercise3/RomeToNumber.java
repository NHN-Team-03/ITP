package Chapter8.yongjun.src.exercise.exercise3;

public class RomeToNumber {

    private String roman;
    private int number;

    RomeToNumber(String Rome) {
        this.number = 0;
        char B = ' ';
        String romenum = Rome;
        while (romenum.length() != 0) {
            char A = romenum.charAt(0);
            if (romenum.length() > 1) {
                B = romenum.charAt(1);
            }
            switch (A) {
                case 'M':
                    number += 1000;
                    romenum = romenum.substring(1);

                    break;
                case 'C':
                    if (B == 'M') {
                        number += 800;
                        romenum = romenum.substring(1);

                    } else if (B == 'D') {
                        number += 300;
                        romenum = romenum.substring(1);

                    }
                    number += 100;
                    romenum = romenum.substring(1);

                    break;
                case 'D':
                    number += 500;
                    romenum = romenum.substring(1);

                    break;
                case 'X':
                    if (B == 'C') {
                        number += 80;
                        romenum = romenum.substring(1);

                    } else if (B == 'L') {
                        number += 30;
                        romenum = romenum.substring(1);

                    }
                    number += 10;
                    romenum = romenum.substring(1);

                    break;
                case 'L':
                    number += 50;
                    romenum = romenum.substring(1);

                    break;
                case 'I':
                    if (B == 'X') {
                        number += 8;
                        romenum = romenum.substring(1);

                    } else if (B == 'V') {
                        number += 3;
                        romenum = romenum.substring(1);

                    }
                    number += 1;
                    romenum = romenum.substring(1);

                    break;
                case 'V':
                    number += 5;
                    romenum = romenum.substring(1);

                    break;

                default:
                    throw new IllegalArgumentException("This Wrong Number");
            }
     
        }

    }

    RomeToNumber(int number) {
        this.roman = "";
        int N = number;
        while (N >= 1000) {
            // 1000을 N에서 roman으로 이동.
            roman += "M";
            N -= 1000;
        }
        while (N >= 900) {
            // 900을 N에서 roman으로 이동.
            roman += "CM";
            N -= 900;
        }
        while (N >= 500) {
            // 900을 N에서 roman으로 이동.
            roman += "D";
            N -= 500;
        }
        while (N >= 400) {
            // 900을 N에서 roman으로 이동.
            roman += "CD";
            N -= 400;
        }
        while (N >= 100) {
            // 900을 N에서 roman으로 이동.
            roman += "C";
            N -= 100;
        }
        while (N >= 90) {
            // 900을 N에서 roman으로 이동.
            roman += "XC";
            N -= 90;
        }
        while (N >= 50) {
            // 900을 N에서 roman으로 이동.
            roman += "L";
            N -= 50;
        }
        while (N >= 40) {
            // 900을 N에서 roman으로 이동.
            roman += "XL";
            N -= 40;
        }
        while (N >= 10) {
            // 900을 N에서 roman으로 이동.
            roman += "X";
            N -= 10;
        }
        while (N >= 9) {
            // 900을 N에서 roman으로 이동.
            roman += "IX";
            N -= 9;
        }
        while (N >= 5) {
            // 900을 N에서 roman으로 이동.
            roman += "V";
            N -= 5;
        }
        while (N >= 4) {
            // 900을 N에서 roman으로 이동.
            roman += "IV";
            N -= 4;
        }
        while (N >= 1) {
            // 900을 N에서 roman으로 이동.
            roman += "I";
            N -= 1;
        }

    }

    public String toString() {
        return this.roman;
    }

    public int toInt() {
        return this.number;
    }

}
