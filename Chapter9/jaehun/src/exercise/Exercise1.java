package Chapter9.jaehun.src.exercise;

import java.math.BigInteger;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(factorial(new BigInteger("10")));
        System.out.println(fibonacci(new BigInteger("10")));
    }

    public static BigInteger factorial(BigInteger number) {
        if (number.signum() < 0) {
            throw new IllegalArgumentException("number의 값이 음수입니다.");
        }

        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }

    public static BigInteger fibonacci(BigInteger number) {
        if (number.signum() < 0) {
            throw new IllegalArgumentException("number의 값이 음수입니다.");
        }
        if (number.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        }
        if (number.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return fibonacci(number.subtract(BigInteger.ONE)).add(fibonacci(number.subtract(BigInteger.TWO)));
    }
}
