package exercise;

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        double[] array = new double[10000];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random() * 10000;
        }

        sortTimer(array);
    }

    private static void sortTimer(double[] array) {
        double[] testArray1 = Arrays.copyOf(array, array.length);
        arraysSortTime(testArray1);

        double[] testArray2 = Arrays.copyOf(array, array.length);
        selectionSortTime(testArray2);
    }

    private static void selectionSortTime(double[] array) {
        long startTime = System.nanoTime();

        selectionSort(array);

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }

    private static void selectionSort(double[] array) {
        int checkSize = array.length;

        while (checkSize > 0) {
            checkSize--;
            int maxValuePoint = checkSize;

            for (int i = 0; i < checkSize; i++) {
                if (array[i] > array[maxValuePoint]) {
                    maxValuePoint = i;
                }
            }

            double temp = array[maxValuePoint];
            array[maxValuePoint] = array[checkSize];
            array[checkSize] = temp;
        }
    }

    private static void arraysSortTime(double[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);

    }
}
