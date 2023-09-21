package exercise.exercise2;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = BigInteger.TWO;
    private static final BigInteger THREE = BigInteger.valueOf(3L);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("3N + 1 콜라츠 추측입니다. 값을 입력해주세요. \n > ");
        String input = scanner.nextLine();
        collatzConjecture(input);
        scanner.close();
    }

    public static void collatzConjecture(String input) {
        if (input.length() <= 0) {
            throw new IllegalArgumentException("아무것도 입력되지 않았습니다.");
        }
        BigInteger bigInteger;
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bigInteger = new BigInteger(input);
            if (bigInteger.signum() <= 0) {
                throw new IllegalArgumentException();
            }
            stringBuilder.append("시작 숫자 : " + bigInteger.toString() + "\n");

            while (!bigInteger.equals(ONE)) {
                if (!bigInteger.testBit(0)) { // 짝수 일때
                    bigInteger = bigInteger.divide(TWO);
                } else {
                    bigInteger = bigInteger.multiply(THREE);
                    bigInteger = bigInteger.add(ONE);
                }
                stringBuilder.append(bigInteger.toString() + "\t");
                count++;

            }
            stringBuilder.append("\n1까지 도달하는 데 시행횟수 : " + count);
            System.out.println(stringBuilder);

        } catch (NumberFormatException exception) {
            System.out.println("형식에 맞지 않는 문자열입니다. 정수 값을 입력해주세요!");
        } catch (IllegalArgumentException exception) {
            System.out.println("1보다 작은 값은 입력될 수 없습니다.");
        }

    }
}
