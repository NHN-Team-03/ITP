package exercise.exercise1;

import java.math.BigInteger;

public class Factorial {
    private Factorial() {
    }

    public static BigInteger func(int inputInt) {
        // BigInteger n = null;
        // try {
        // n = new BigInteger(String.valueOf(inputInt));
        // } catch (NumberFormatException exception) {
        // throw new NumberFormatException("")
        // }
        if (inputInt < 0) {
            throw new IllegalArgumentException("0보다 작은 숫자로 factorial 함수를 실행할 수 없습니다.");
        }

        if (inputInt == 0) {
            return BigInteger.ONE;
        }

        BigInteger n = new BigInteger(String.valueOf(inputInt));
        return n.multiply(func(inputInt - 1));
    }
}
