package quiz;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Eggs: ");
        int num = sc.nextInt();

        int gross = num / 144;
        num %= 144;

        int dozen = num / 12;
        num %= 12;

        
        System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + num);
    }
}
