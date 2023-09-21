package exercise.exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Expr expr;
        double number;

        while (true) {
            System.out.print("식을 입력하세요: ");
            String expression = scanner.nextLine();

            if (expression.equals("")) {
                break;
            }

            try {
                expr = new Expr(expression);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            while (true) {
                System.out.print("X를 입력하세요: ");

                String line = scanner.nextLine();

                if (line.equals("")) {
                    break;
                }

                try {
                    number = Double.valueOf(line);
                } catch (NumberFormatException exception) {
                    System.out.println("숫자를 입력해주세요.");
                    continue;
                }

                System.out.println(expr.value(number));
            }

        }

        scanner.close();
    }
}
