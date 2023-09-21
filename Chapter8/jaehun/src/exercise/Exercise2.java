package exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("숫자를 입력하세요 : ");
            String str = scanner.nextLine();

            BigInteger number;

            if (str.equals("")) {
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

        if (number.equals(new BigInteger("1"))) {
            return;
        }

        if (number.intValue() % 2 == 0) {
            collatzConjecture(number.divide(new BigInteger("2")));
        } else {
            collatzConjecture(number.multiply(new BigInteger("3")).add(new BigInteger("1")));
        }
    }
}
