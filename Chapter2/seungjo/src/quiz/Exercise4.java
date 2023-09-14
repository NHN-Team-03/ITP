package quiz;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("quarter: ");
        int quarter = sc.nextInt() * 25;
        System.out.print("dime: ");
        int dime = sc.nextInt() * 10;
        System.out.print("nickel: ");
        int nickel = sc.nextInt() * 5;
        System.out.print("penny:");
        int penny = sc.nextInt();

        int dollar = (quarter + dime + nickel + penny) / 100;

        System.out.println(dollar + " dollar");
    }
}
