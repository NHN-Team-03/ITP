package Chapter2.youngjun;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("달걀");
        int egg = scanner.nextInt();
        int gross = egg/144;
        int das = (egg%144) / 12;
        int eggs = egg%12;
    }
}
