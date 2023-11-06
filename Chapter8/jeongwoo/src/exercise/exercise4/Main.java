package exercise.exercise4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Expr expr;
        String inputExpr = "";
        String inputValue = "";
        double result = 0.0;

        while (true) {
            System.out.print("표현식을 입력하세요 > ");
            inputExpr = scanner.nextLine().trim();
            if (inputExpr.equals("")) {
                System.out.println("프로그램 종료");
                break;
            }
            try {
                expr = new Expr(inputExpr);

                System.out.print("방적식에 대입할 값을 입력하세요 > ");
                inputValue = scanner.nextLine().trim();

                result = expr.value(Double.parseDouble(inputValue));

                if (Double.isNaN(result)) {
                    throw new IllegalArgumentException("지정된 값의 표현식이 잘못 되었습니다.");
                }

                System.out.println(expr.toString());
                System.out.println(result);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        scanner.close();
    }
}
