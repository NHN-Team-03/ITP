package exercise.exercise1;

import java.math.BigInteger;

public final class Fibonacci {
    private Fibonacci() {
    }

    public static BigInteger func(int inputInt) {
        if (inputInt < 0) {
            throw new IllegalArgumentException("피보나치 함수는 parameter로 0보다 작은 값을 가질 수 없습니다.");
        }

        if (inputInt == 0) {
            return BigInteger.ZERO;
        } else if (inputInt == 1) {
            return BigInteger.ONE;
        }
        
        return func(inputInt - 1).add(func(inputInt - 2));

    }
}
