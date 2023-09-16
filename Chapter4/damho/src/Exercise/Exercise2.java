package Chapter4.damho.src.Exercise;

import java.util.Scanner;

public class Exercise2 {

    private static int hexToDecimal(String str) {
        String inputString = str.toLowerCase();
        int value = 0;
        int hexValue;
        for (int i = 0; i < inputString.length(); i++) {
            hexValue = hexValue(inputString.charAt(i));
            if (hexValue == -1) {
                throw new IllegalArgumentException("16진수 아닌 값 " + inputString.charAt(i) + "가 입력되었습니다.");
            }
            value = value * 16 + hexValue;
        }
        return value;
    }

    private static int hexValue(char ch) {
        switch (ch) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return Character.getNumericValue(ch);
            case 'a':
                return 10;
            case 'b':
                return 11;
            case 'c':
                return 12;
            case 'd':
                return 13;
            case 'e':
                return 14;
            case 'f':
                return 15;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("16진수 입력 : ");
        String inputString = s.nextLine();
        System.out.println(hexToDecimal(inputString));
        s.close();
    }
}
