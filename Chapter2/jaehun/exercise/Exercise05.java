package Chapter2.jaehun.exercise;

import java.util.Scanner;

public class Exercise05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int egg;
        int dozen;
        int gross;

        System.out.print("Enter number of egg: ");
        egg = scanner.nextInt();
        gross = egg / 144;
        egg = egg % 144;
        dozen = egg / 12;
        egg = egg % 12;

        System.out.println("Your number of egg is " + gross + " gross, " + dozen + " dozen, and " + egg);

        scanner.close();
    }
}
