package exercise.exercise5;

import java.util.Scanner;

public class Exercise5 {

    public static void insertionSort(int[] arr, int count, int num) {

        int loc = count - 1;
        while (loc >= 0 && arr[loc] > num) {
            arr[loc + 1] = arr[loc];
            loc = loc - 1;
        }

        arr[loc + 1] = num;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;

                // swap: arr[i] <-> arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int count = 0;

        for (int i = 0; i < 100; i++) {
            System.out.print("? ");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            insertionSort(arr, count, num);
            count++;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
