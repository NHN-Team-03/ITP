package Chapter4.youngjun.src.exercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println(dice(10));
        int y;
        int x = y = 7;

    }

    public static int dice(int x) {
        int count = 0;
        int point = x;
        int check = 0;
        while (check != 1) {
            count++;
            if (((int) (Math.random() * 6 + 1) +(int) (Math.random() * 6 + 1)) == point) {
                check++;
            }
        }
        return count;
    }
}
