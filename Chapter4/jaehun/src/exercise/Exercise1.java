package Chapter4.jaehun.src.exercise;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter: ");
        String statement = scanner.nextLine();

        System.out.println(printCapitalized(statement));

        scanner.close();
    }

    public static String printCapitalized(String statement) {
        StringBuilder sb = new StringBuilder();

        for(String words : statement.split(" ")) {
            sb.append(words.replace(words.charAt(0), Character.toUpperCase(words.charAt(0))));
            sb.append(" ");
        }

        return sb.toString();
    }
}
