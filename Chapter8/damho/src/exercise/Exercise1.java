package Chapter8.damho.src.exercise;

import java.util.Scanner;

public class Exercise1 {
    /**
     * Returns the larger of the two roots of the quadratic equation
     * A*x*x + B*x + C = 0, provided it has any roots. If A == 0 or
     * if the discriminant, B*B - 4*A*C, is negative, then an exception
     * of type IllegalArgumentException is thrown.
     */
    public static double root(double a, double b, double c)
            throws IllegalArgumentException {
        if (a == 0) {
            throw new IllegalArgumentException("A can't be zero.");
        } else {
            double disc = b * b - 4 * a * c;
            if (disc < 0)
                throw new IllegalArgumentException("Discriminant < zero.");
            return (-b + Math.sqrt(disc)) / (2 * a);
        }
    }

    public static double inputDouble(Scanner scanner) {
        String inputString = scanner.nextLine();
        double result = 0;
        try {
            result = Double.valueOf(inputString);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException("실수 값을 입력해 주세요");
        }
        return result;
    }

    public static void main(String[] args) throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        double a;
        double b;
        double c;
        double result;

        while (true) {
            while (true) {
                System.out.print("A 입력 : ");
                try {
                    a = inputDouble(scanner);
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            while (true) {
                System.out.print("B 입력 : ");
                try {
                    b = inputDouble(scanner);
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            while (true) {
                System.out.print("C 입력 : ");
                try {
                    c = inputDouble(scanner);
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println(exception.getMessage());
                }
            }

            try {
                result = root(a, b, c);
                System.out.println("결과 : " + result);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            while (true) {
                System.out.println("계속하려면 O, 그만하려면 X를 입력하세요");
                inputString = scanner.nextLine().toLowerCase();
                if (inputString.equals("o")) {
                    break;
                }
                if (inputString.equals("x")) {
                    System.out.println("프로그램 종료");
                    scanner.close();
                    return;
                }
                System.out.println("O 또는 X로 대답해 주세요.");
            }
        }
    }

}
