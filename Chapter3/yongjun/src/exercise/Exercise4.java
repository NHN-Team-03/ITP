package Chapter3.yongjun.src.exercise;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(string.charAt(i))) {
                System.out.print(string.charAt(i));
            } else {
                System.out.println();
            }
        }

    }
}
