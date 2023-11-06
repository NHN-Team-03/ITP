package exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        findHexValue();
    }

    public static void findHexValue() {
        Scanner s = new Scanner(System.in);
        int hex = 1;
        int result = 0;

        String hexStringValue = s.nextLine();

        try {
            for (int i = hexStringValue.length() - 1; i >= 0; i--) {
                int temp = checkHexValue(hexStringValue.charAt(i));
                if (temp == -1) {
                    throw new IllegalArgumentException("잘못된 값이 포함되어있습니다.");
                }
                result += (temp * hex);
                hex *= 16;
            }
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        s.close();
    }

    public static int checkHexValue(char hexValue) {
        switch (hexValue) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return -1;
        }
    }
}
