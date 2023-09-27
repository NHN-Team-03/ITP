package Chapter2.jaehun.exercise;

import java.util.Scanner;

public class Exercise04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quarter;
        int dime;
        int nickel;
        int penny;
        double sum;
        double dollar;

        System.out.print("Enter a quarter : ");
        quarter = scanner.nextInt();
        System.out.print("Enter a dime : ");
        dime = scanner.nextInt();
        System.out.print("Enter a nickel : ");
        nickel = scanner.nextInt();
        System.out.print("Enter a penny : ");
        penny = scanner.nextInt();

        sum = 25 * quarter + 10 * dime + 5 * nickel + penny;
        dollar = sum / 100;

        System.out.println(dollar + "$");

        scanner.close();
    }
}
