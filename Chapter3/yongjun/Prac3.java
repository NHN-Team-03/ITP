package Chapter3.yongjun;

import java.util.Scanner;

public class Prac3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = 0;
        double y = 0;
        char cal;
        double result = 0;
        while (true) {
            String string = scanner.nextLine();
            String[] str = string.split(" ");
            x = Integer.valueOf(str[0]);
            y = Integer.valueOf(str[2]);
            cal = str[1].charAt(0);
            if (x == 0) {
                return;
            } else if ((cal != '+' && cal != '-') && (cal != '*' && cal != '/')) {
                System.out.println("질못된 연산자");
                continue;
            } else {
                switch (cal) {
                    case '+':
                        System.out.println(x + y);
                        break;
                    case '-':
                        System.out.println(x - y);
                        break;
                    case '*':
                        System.out.println(x * y);
                        break;
                    case '/':
                        System.out.println(x / y);
                        break;
                    default:
                        break;
                }
            }

        }
    }
}
