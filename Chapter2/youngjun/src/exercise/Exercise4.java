package Chapter2.youngjun;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("quarter = ");
        int quarter = scanner.nextInt();
        System.out.println("dime = ");
        int dime = scanner.nextInt();
        System.out.println("nicklel = ");
        int nickel = scanner.nextInt();
        System.out.println("penny = ");
        int penny = scanner.nextInt();

        double dollor = quarter*0.25 + dime*0.1 + nickel*0.05 + penny*0.01;
        System.out.println("dollor = "+dollor);
    }
}
