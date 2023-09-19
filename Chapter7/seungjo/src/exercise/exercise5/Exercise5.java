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

    public static void quickSort(int[] arr) {
        int pivot = arr[0];
        
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


        for (int number : arr) {
            if (number == 0) {
                continue;
            }
            System.out.print(number + " ");
        }
        
    }
}
