package Chapter2.damho;

import java.util.Scanner;

public class Exam2_5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int eggNum;
        int gross;
        int dozen;

        System.out.print("Enter your number of eggs : ");
        eggNum = s.nextInt();
        gross = eggNum / 144;
        eggNum = eggNum % 144;
        dozen = eggNum / 12;
        eggNum = eggNum % 12;
        System.out.println("your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + eggNum);
        s.close();
    }
}
