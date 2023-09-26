package Chapter8.damho.src.exercise.exercise4;

import java.util.Scanner;

public class exercise4 {
    public static void main(String[] args) {
        Expr expr = null;
        Scanner scanner = new Scanner(System.in);
        String line;
        double x;

        while (true) {
            System.out.print("표현식을 입력해 주세요(종료 : 숫자 0) : ");
            line = scanner.nextLine();
            if (line.equals("0")) {
                break;
            }
            try {
                expr = new Expr(line);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            while (true) {
                System.out.print("x의 값을 입력해주세요 : ");
                line = scanner.nextLine();
                try {
                    x = Double.valueOf(line);
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("double 형으로 입력해주세요");
                }
            }

            double result = expr.value(x);

            if (Double.isNaN(x)) {
                System.out.println("Double.NaN 값이 return 되었습니다.");
            } else {
                System.out.println("결과 값 : " + result);
            }
        }
    }
}
