package Chapter3.jaehun.exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber;
        double secondNumber;
        double result;
        String operator;

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            try {
                firstNumber = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("잘못된 값을 입력했습니다. 처음으로 돌아갑니다.");
                continue;
            }

            if (firstNumber == 0) {
                System.out.println("실행을 종료합니다.");
                break;
            }

            System.out.print("연산자를 입력하세요: ");
            operator = scanner.next();

            try {
                System.out.print("두 번째 숫자를 입력하세요: ");
                secondNumber = scanner.nextDouble();
            } catch (InputMismatchException exception) {
                System.out.println("잘못된 값을 입력했습니다. 처음으로 돌아갑니다.");
                continue;
            }

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                default:
                    System.out.println("정해진 연산자를 입력해주세요. 처음으로 돌아갑니다.");
                    continue;
            } // close swtich

            System.out.println("연산의 결과는 " + result);

            scanner.close();
            
        }// close while
    } // close main()
} //close Class
