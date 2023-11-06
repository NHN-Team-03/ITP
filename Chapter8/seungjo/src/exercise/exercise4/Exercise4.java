package exercise.exercise4;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
        String value;
        while (true) {
            System.out.print("표현식을 입력하세요 (종료: enter): ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("프로그램 종료.");
                break;
            }
            try {
                Expr expr = new Expr(input);
                System.out.print("x의 값 = ");
                value = sc.nextLine().trim();

                double result = expr.value(Double.parseDouble(value));
                if (Double.isNaN(result)) {
                    System.out.println("수식이 해당 값에서 정의되지 않았습니다.");
                } else {
                    System.out.println("결과 : " + result);
                }

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
