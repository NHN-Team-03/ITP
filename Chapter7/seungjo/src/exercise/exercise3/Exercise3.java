package exercise.exercise3;

import java.util.Arrays;
import java.util.Random;

public class Exercise3 {

    private static final int SIZE = 100;

    public static void selectionSort(double[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            double temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        Random random = new Random();

        double[] arr = new double[SIZE];

        System.out.println("Array's size is 10.");
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = sc.nextDouble();
            arr[i] = random.nextDouble();
        }

        double[] copyArr = Arrays.copyOf(arr, arr.length);

        // TODO: Arrays.sort() 시간 계산
        long startTime = System.nanoTime();
        Arrays.sort(arr);
        long endTime = System.nanoTime();
        System.out.println("Arrays.sort() : " + (endTime - startTime) + " nano seconds");

        // TODO: selectionSort 시간 계산
        startTime = System.nanoTime();
        selectionSort(copyArr);
        endTime = System.nanoTime();
        System.out.println("Selection Sort : " + (endTime - startTime) + " nano seconds");

    }
}
