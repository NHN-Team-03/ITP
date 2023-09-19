package exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StatCalc calc = new StatCalc();

        double number;

        while (true) {
            System.out.print("수를 입력하세요 : ");
            number = scanner.nextDouble();

            if (number == 0) {
                break;
            }

            calc.enter(number);
        }

        System.out.println(calc);

        scanner.close();
    }
}
