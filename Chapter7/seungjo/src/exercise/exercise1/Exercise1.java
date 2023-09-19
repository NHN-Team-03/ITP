package exercise.exercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    private static Random random = new Random();

    public static void createArrayList(int size, int max) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max) + 1);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of ArrayList: ");
        int size = sc.nextInt();

        System.out.print("Enter the maximum value of ArrayList ");
        int max = sc.nextInt();
        createArrayList(size, max);
    }
}
