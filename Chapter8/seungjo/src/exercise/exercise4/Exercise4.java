package exercise.exercise4;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
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
                double x = sc.nextDouble();
                System.out.println("결과 : " + expr.value(x));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}
