package exercise.exercise3;

import java.util.Arrays;

public class exercise3 {
    public static final int SIZE = 100000;
    public static void initArray(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = SIZE - i;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[SIZE];
        initArray(arr);

        // selectionsort 시간 체크
        long startTime = System.nanoTime();
        SelectionSort.selectionSort(arr);
        long endTime = System.nanoTime();
        System.out.println("SelectionSort : " + ((endTime - startTime) / 1000000000) + "초 걸림");

        initArray(arr);
        // Arrays.sort() 시간 체크
        startTime = System.nanoTime();
        Arrays.sort(arr);
        endTime = System.nanoTime();
        System.out.println("Arrays.sort() : " + ((endTime - startTime) / 1000000000) + "초 걸림");

    }
}
