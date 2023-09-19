package exercise.exercise5;

import java.util.Arrays;
import java.util.Scanner;

public class exercise5 {
    public static int[] copyArray(int[] arr, int count) {
        return Arrays.copyOf(arr, count);
    }

    public static void printArray(int[] arr) {
        InsertionSort.insertionSort(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i] + " ");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = new int[100];
        int count = 0;
        int inputInt;
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                inputInt = s.nextInt();
                if (inputInt == 0) {
                    arr = copyArray(arr, count);
                    printArray(arr);
                    return;
                }
                if (inputInt > 0) {
                    arr[i] = inputInt;
                    count++;
                    break;
                }
                System.out.println("0 이상의 정수만 입력.");
            }
        }
    }
}
