package exercise.exercise1;

import java.math.BigInteger;

public final class FactorialTest {
    private FactorialTest() {}
    public static void factorialTest() {
        System.out.println(baseCase());
        try {
            preCondition();
        } catch (IllegalArgumentException exception) {
            System.out.println("Factorial 함수의 parameter는 0보다 작을 수 없습니다.");
        }
        System.out.println(postCondition(5));
    }

    private static boolean baseCase() {
        return Factorial.func(0).equals(BigInteger.ONE);
    }

    private static void preCondition() {
        Factorial.func(-1);
    }

    private static boolean postCondition(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * i;
        }

        return Factorial.func(n).equals(new BigInteger(String.valueOf(result)));
    }

}
