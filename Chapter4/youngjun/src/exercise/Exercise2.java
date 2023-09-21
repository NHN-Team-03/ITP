package Chapter4.youngjun.src.exercise;

import java.util.Scanner;

public class Exercise2 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int value = 0;
        for (int i = 0; i < str.length(); i++)
            value = value * 16 + hexValue(str.charAt(i));
        if (count == 0) {
            System.out.println("16진수 입력 바람");
        } else {
            System.out.println(value);
        }
    }

    private static int hexValue(char charAt) {
        switch (charAt) {
            case 'A':
                count++;
                return 10;
            case 'B':
                count++;
                return 11;
            case 'C':
                count++;
                return 12;
            case 'D':
                count++;
                return 13;
            case 'E':
                count++;
                return 14;
            case 'F':
                count++;
                return 15;

            default:
                return charAt;
        }
    }
}
