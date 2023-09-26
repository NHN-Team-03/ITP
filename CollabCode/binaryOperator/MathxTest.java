package CollabCode.binaryOperator;

import java.util.Scanner;

public class MathxTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Mathx.sum(1, 2) == 3);
        System.out.println(Mathx.sub(3,1) == 2);
        System.out.println(Mathx.mul(2,4) == 8);
        System.out.println(Mathx.div(3,3) == 1);
        scanner.close();
    }
}
