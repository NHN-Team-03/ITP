package exercise.exercise1;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise1 {

    private final static BigInteger ZERO = BigInteger.ZERO;
    private final static BigInteger ONE = BigInteger.ONE;
    private final static BigInteger TWO = BigInteger.TWO;

    public static BigInteger factorial(BigInteger number) {
        // factorial(0) = 1
        if (number.equals(ZERO)) {
            return ONE;
        }
        // N * factorial(N-1)
        return number.multiply(factorial(number.subtract(ONE)));
    }

    public static BigInteger fibonacci(BigInteger number) {
        // fibonacci(0), fibonacci(1) = 1
        if (number.equals(ZERO) || number.equals(ONE)) {
            return ONE;
        }
        // fibonacci(N - 1) + fibonacci(N - 2)
        return fibonacci(number.subtract(ONE)).add(fibonacci(number.subtract(TWO)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("양의 정수를 입력하세요 (Enter: exit): ");
            String input = sc.nextLine();

            if (input.isEmpty()) {
                break;
            } else if (Integer.parseInt(input) < 0) {
                System.out.println("잘못된 값을 입력하였습니다.");
            } else {
                BigInteger number = new BigInteger(input);
                System.out.println("factorial 값: " + factorial(number));
                System.out.println("fibonacci 값: " + fibonacci(number));
            }
        }
    }
}
