package exercise.exercise4;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Expr expr;
        while (true) {

            double x = 0;
            System.out.println("표현식 입력");
            String input = scanner.nextLine();
            double number;

            if (input.length() == 0) {
                break;
            }

            try {
                expr = new Expr(input);
                // number = Double.parseDouble(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                continue;
            }

            while (true) {
                System.out.println("변수 입력");
                String num = scanner.nextLine();

                if (num.length() == 0) {
                    break;
                }
                x = Double.valueOf(num);
                number = expr.value(x);
                System.out.println(number);

            }

            System.out.println(expr.toString());
        }
    }
}
