package exercise.exercise1;

import java.math.BigInteger;

public final class FibonacciTest {
    private FibonacciTest() {
    }

    public static void fibonacciTest() {
        baseCase();
        preCondition();
        postCondition();
    }

    private static void baseCase() {
        System.out.println(Fibonacci.func(0).equals(BigInteger.ZERO));
        System.out.println(Fibonacci.func(1).equals(BigInteger.ONE));
    }

    private static void preCondition() {
        try {
            Fibonacci.func(-1);
        } catch (IllegalArgumentException exception) {
            System.out.println("피보나치 함수는 parameter로 0보다 작은 값을 가질 수 없습니다.");
        }
    }

    private static void postCondition() {
        System.out.println(Fibonacci.func(10).equals(new BigInteger("55")));
    }
}
