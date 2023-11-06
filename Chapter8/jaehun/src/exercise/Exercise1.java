package exercise;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("A, B, C를 입력하세요.");
            System.out.print("A : ");
            double numberA = scanner.nextDouble();
            System.out.print("B : ");
            double numberB = scanner.nextDouble();
            System.out.print("C : ");
            double numberC = scanner.nextDouble();

            try {
                System.out.println(root(numberA, numberB, numberC));
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            

            System.out.println("다시 하시겠습니까?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }

    private static double root(double numberA, double numberB, double numberC) {
        if (numberA == 0) {
            throw new IllegalArgumentException("숫자 A는 0이될 수 없습니다.");
        } else {
            double disc = numberB * numberB - 4 * numberA * numberC;
            if (disc < 0) {
                throw new IllegalArgumentException("Discriminant < zero.");
            }
            return (-numberB + Math.sqrt(disc)) / (2 * numberA);
        }
    }
}