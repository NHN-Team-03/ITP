package exercise.exercise1;

import java.util.Scanner;

public class Exercise1 {

    public static double root(double A, double B, double C) throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero!");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0) {
                throw new IllegalArgumentException("Discriminant < zero.");
            }
            return (-B + Math.sqrt(disc) / (2 * A));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;

        while (check) {
            System.out.print("Enter the first number: ");
            double first = sc.nextDouble();

            System.out.print("Enter the second number: ");
            double second = sc.nextDouble();

            System.out.print("Enter the third number: ");
            double third = sc.nextDouble();

            System.out.println(root(first, second, third));

            String input;
            do {
                System.out.print("Continue? (Y/N) ");
                input = sc.next();
                if (input.equals("N") || input.equals("n")) {
                    check = false;
                    break;
                } else if (input.equals("Y") || input.equals("y")) {
                    check = true;
                    break;
                } else {
                    System.out.println("잘못 입력하셨습니다 다시 입력하세요");
                }
            } while (!(input.equals("N") || input.equals("n") || input.equals("Y") || input.equals("y")));
        }
    }
}