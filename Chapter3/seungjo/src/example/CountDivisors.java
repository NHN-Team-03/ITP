package example;

import java.util.Scanner;

public class CountDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        int testDivisor;
        int divisorCount;
        int numberTested;

        while (true) {
            System.out.print("Enter a positive integer: ");
            num = sc.nextInt();
            if (num > 0) {
                break;
            }

            System.out.println("That number is not positive. Please try again.");
        }

        divisorCount = 0;
        numberTested = 0;

        for (testDivisor = 1; testDivisor <= num; testDivisor++) {
            if (num % testDivisor == 0) {
                divisorCount++;
            }
            numberTested++;
            if (numberTested == 10000000) {
                System.out.print(".");
                numberTested = 0;
            }
        }

        System.out.println();
        System.out.println("The number of divisors of " + num + " is " + divisorCount);
    }
}
