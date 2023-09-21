package exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {

    private static int count;
    private static final BigInteger THREE = new BigInteger("3");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            count = 0;
            System.out.print("숫자를 입력하세요 : ");
            String str = scanner.nextLine();

            BigInteger number;

            if (str.isEmpty()) {
                break;
            }

            try {
                number = new BigInteger(str);
                collatzConjecture(number);
            } catch (NumberFormatException exception) {
                exception.printStackTrace();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            System.out.println(count);
        }

        scanner.close();
    }

    private static void collatzConjecture(BigInteger number) {
        if (number.signum() <= 0) {
            throw new IllegalArgumentException("number < 0");
        }

        count++;

        if (number.equals(BigInteger.ONE)) {
            return;
        }

        if (number.intValue() % 2 == 0) {
            collatzConjecture(number.divide(BigInteger.TWO));
        } else {
            collatzConjecture(number.multiply(THREE).add(BigInteger.ONE));
        }
    }
}
