package example;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWithArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter some non-zero integers. Enter 0 to end.");

        while (true) {
            System.out.print("? ");
            int number = sc.nextInt();
            if (number == 0) {
                break;
            }
            list.add(number);
        }

        System.out.println();
        System.out.println("Your numbers in reverse are: ");
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.printf("%10d%n", list.get(i));
        }

        sc.close();
    }
}
