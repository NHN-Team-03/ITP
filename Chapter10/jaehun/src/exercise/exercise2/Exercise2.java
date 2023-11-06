package exercise.exercise2;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc;

        System.out.println("input (Enter = 종료)");

        String answer;

        while(true) {
            answer = scanner.nextLine();

            if(answer.isEmpty()) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                calc = new Calculator(answer);
                System.out.println(calc);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }


        }
    }
}