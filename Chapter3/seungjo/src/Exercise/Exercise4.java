package Exercise;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String letters = sc.nextLine();
        // StringBuilder sb = new StringBuilder();

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                System.out.print(ch);
            } else if (ch == ' ' || ch == '\'') {
                System.out.println();
            }
        }

        sc.close();
    }
}
