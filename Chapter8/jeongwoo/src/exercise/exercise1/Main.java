package exercise.exercise1;

import java.util.Scanner;

public class Main {


    static public double root(double A, double B, double C) throws IllegalArgumentException {
        if (A == 0) {
            throw new IllegalArgumentException("A can't be zero");
        } else {
            double disc = B * B - 4 * A * C;
            if (disc < 0) {
                throw new IllegalArgumentException("Discriminant < Zero.");
            }
            return (-B + Math.sqrt(disc)) / (2 * A);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double A, B, C;
        boolean again = true;
        String input;

        while (again) {
            System.out.print("A의 값 = ");
            A = scanner.nextDouble();
            System.out.print("B의 값 = ");
            B = scanner.nextDouble();
            System.out.print("C의 값 = ");
            C = scanner.nextDouble();

            try {
                double answer = root(A, B, C);
                System.out.println("방정식 값 : " + answer);
            } catch (IllegalArgumentException e) {
                System.out.println("잘못된 값");
            }

            question:while(true){
                System.out.println("Are you again? (Y/N)");
                input = scanner.next();
                switch (input){
                    case "Y":
                        again = true;
                        break question;
                    case "N":
                        again = false;
                        break question;
                    default:
                        System.out.println("잘못된 값");
                        break;
                }
            }
        }

        scanner.close();
    }
}
