package exercise;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        printCapitalized(input);
    }

    public static void printCapitalized(String input) {

        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for (int i = 0; i < input.length() - 1; i++) {
            char ch = input.charAt(i);
            if (ch == ' ') {
                sb.append(Character.toUpperCase(input.charAt(i + 1)));
            } else {
                sb.append(input.charAt(i + 1));
            }
        }

        System.out.println(sb.toString());

    }
}
