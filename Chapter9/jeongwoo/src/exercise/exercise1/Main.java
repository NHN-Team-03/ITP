package exercise.exercise1;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static BigInteger ONE = BigInteger.ONE;
    private static BigInteger TWO = BigInteger.TWO;
    private static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("0보다 작은 값은 허용하지 않습니다.");
        }
        if (n > 16) {
            throw new IllegalArgumentException("16보다 큰 값은 자료형 int가 감당하지 못합니다.");
        }

        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    private static BigInteger factorialBigInteger(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("0보다 작은 값은 허용하지 않습니다.");
        }

        if (n == 0 || n == 1) {
            return ONE;
        }


        BigInteger bigInteger = BigInteger.valueOf(n);

        for (long i = n - 1; i >= 1; i--) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        return bigInteger;
    }

    private static BigInteger fibonacci(BigInteger n) {
        if (n.signum() < 0) {
            throw new IllegalArgumentException("0보다 작은 값은 허용하지 않습니다.");
        }

        if (n.signum() == 0) {
            return BigInteger.ZERO;
        }

        if (n.equals(ONE)) {
            return ONE;
        }
        BigInteger bigInteger1 = n.subtract(ONE);
        BigInteger bigInteger2 = n.subtract(TWO);

        return fibonacci(bigInteger1).add(fibonacci(bigInteger2));
    }

    private static void factorialTest(Scanner scanner) {

        System.out.print("factorial(0~16) 입력 > ");
        int input = scanner.nextInt();
        int result = factorial(input);
        System.out.println(input + " factorial 값 : " + result);
    }

    private static void factorialBigIntegerTest(Scanner scanner) {
        System.out.print("factorial(BigInteger) 입력 > ");
        long input = scanner.nextLong();
        System.out.println(input + " factorial(BigInteger) 값 : " + factorialBigInteger(input));

    }

    private static void fibonacciTest(Scanner scanner) {
        System.out.print("fibonacci 입력 > ");
        BigInteger input = scanner.nextBigInteger();
        System.out.println(input + " fibonacci 값 : " + fibonacci(input));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        factorialTest(scanner);
        factorialBigIntegerTest(scanner);
        fibonacciTest(scanner);

        scanner.close();
    }
}
