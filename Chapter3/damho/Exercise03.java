package Chapter3.damho;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x;
        double y;
        char operator;

        while (true) {
            System.out.print("수식 입력해주세요 : ");
            x = s.nextDouble();
            if (x == 0) {
                break;
            }
            operator = s.next().charAt(0);
            y = s.nextDouble();
            if (operator == '+') {
                System.out.println(x + y);
            } else if (operator == '-') {
                System.out.println(x - y);
            } else if (operator == '*') {
                System.out.println(x * y);
            } else if (operator == '/') {
                if (y == 0) {
                    System.out.println("0으로 나눌 수 없습니다");
                } else {
                    System.out.println(x / y);
                }
            }
        }

    }
}
