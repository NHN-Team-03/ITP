package Chapter8.damho.src.exercise;

import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {
    private static final BigInteger THREE = new BigInteger("3");
    public static final Scanner scanner = new Scanner(System.in);

    public static String getInputString() {
        System.out.println("숫자를 입력해 주세요 : ");
        return scanner.nextLine();
    }

    public static BigInteger threeNPlusOne(BigInteger n) {
        if (n.mod(BigInteger.TWO).intValue() == 0) {
            n = n.divide(BigInteger.TWO);
        } else {
            n = n.multiply(THREE);
            n = n.add(BigInteger.ONE);
        }
        return n;
    }

    public static void main(String[] args) {
        String inputString;
        while (true) {
            BigInteger n = null;
            while (true) {
                inputString = getInputString();
                if (inputString.isEmpty()) {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                try {
                    n = new BigInteger(inputString);
                    if (n.signum() > 0) {
                        break;
                    }
                    System.out.println("양수의 값을 입력해 주세요");

                } catch (NumberFormatException exception) {
                    System.out.println("int 형식으로 입력해 주세요.");
                }
            }
            while (true) {
                n = threeNPlusOne(n);
                System.out.println(n);
                if (n.intValue() == 1) {
                    break;
                }
            }
        }
    }
}
