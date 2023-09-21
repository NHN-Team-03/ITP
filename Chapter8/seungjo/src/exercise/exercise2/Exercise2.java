package exercise.exercise2;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {

    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final BigInteger THREE = new BigInteger("3");


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input;
        BigInteger bigInteger;
        System.out.println("3N + 1 Program");

        while (true) {
            System.out.print("1보다 큰 숫자를 입력하세요: ");
            input = sc.nextLine();

            if (input.isEmpty()) {
                System.out.println("종료합니다.");
                break;
            }

            try {
                bigInteger = new BigInteger(input);
                collatzConjecture(bigInteger);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static BigInteger collatzConjecture(BigInteger input) {

        // input.equals(ZERO) || input.equals(ONE) -> signum()으로 처리
        if (input.signum() <= 0) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다!");
        }

        BigInteger bigInteger = input;
        int count = 0;
        StringBuilder sb = new StringBuilder();

        sb.append(bigInteger).append(" ");
        while (!(bigInteger.equals(ONE))) {
            // 짝수인지 판별
            if (!bigInteger.testBit(0)) {
                bigInteger = bigInteger.divide(TWO);
            } else {
                bigInteger = bigInteger.multiply(THREE).add(ONE);
            }
            sb.append(bigInteger).append(" ");
            count++;
        }

        sb.append("\n총 횟수: ").append(count + 1);
        System.out.println(sb);

        return bigInteger;
    }
}
