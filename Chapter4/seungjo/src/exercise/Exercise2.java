package exercise;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int value = 0;
        try {
            for (int i = 0; i < str.length(); i++) {
                value = value * 16 + hexValue(str.charAt(i));
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        System.out.println(value);
    }

    public static int hexValue(char ch) {
        int result = 0;

        if (ch >= 48 && ch <= 57) {
            result = ch - 48;
        } else if (ch >= 65 && ch <= 70) {
            result = ch - 65 + 10;
        } else {
            throw new NumberFormatException("16비트의 값을 넘어갔습니다.");
        }
        return result;
    }
}
