package Chapter8.yongjun.src.exercise.exercise1;

import java.util.Scanner;

public class Exercise1 {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots. If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    static public double root(double A, double B, double C) throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input;
        System.out.println("계속 = Y 스탑 = N");
        input = scanner.next().charAt(0);
        input = Character.toUpperCase(input);
        double number = 0;
        while (input == 'Y') {
            try {
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                number = root(a, b, c);

            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
            System.out.println(number);
            System.out.println("계속 = Y 스탑 = N");
            input = scanner.next().charAt(0);
            input = Character.toUpperCase(input);
        }

    }

}
