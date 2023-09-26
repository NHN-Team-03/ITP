package Chapter9.yongjun.src.exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise1 {

    public static final BigInteger ONE = BigInteger.valueOf(1L);
    public static final BigInteger TWO = BigInteger.valueOf(2L);
    public static final BigInteger ZERO = BigInteger.valueOf(0L);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger fibonacciNumber;
        BigInteger factorialNumber;

        while (true) {
            System.out.println("피보나치 수 입력(양수만)");
            fibonacciNumber = scanner.nextBigInteger();
            if (fibonacciNumber.signum() != 1) {
                System.out.println("잘못된 수 입력");
                continue;
            }
            scanner.nextLine();
            System.out.println("팩토리얼 수 입력(0 이상 수 입력)");
            factorialNumber = scanner.nextBigInteger();
            if (factorialNumber.signum() < 0) {
                System.out.println("잘못된 수 입력");
                continue;
            }
            break;
        }
        System.out.println("피보나치 = " + Fibonacci(fibonacciNumber));
        System.out.println("팩토리얼 = " + Factorial(factorialNumber));


    }

    private static BigInteger Factorial(BigInteger factorialNumber) {
        if (factorialNumber.signum() == 0) {
            return ONE;
        } else if (factorialNumber.equals(ONE)) {
            return ONE;
        }

        return factorialNumber.multiply(Factorial(factorialNumber.subtract(ONE)));
    }

    private static BigInteger Fibonacci(BigInteger fibonacciNumber) {
        if (fibonacciNumber.equals(ONE)) {
            return ONE;
        } else if (fibonacciNumber.equals(TWO)) {
            return TWO;
        }

        return Fibonacci(fibonacciNumber.subtract(ONE)).add(Fibonacci(fibonacciNumber.subtract(TWO)));
    }
}
