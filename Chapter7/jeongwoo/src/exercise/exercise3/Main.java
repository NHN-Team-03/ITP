package exercise.exercise3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int ARRAY_SIZE = 10000;

    public static void main(String[] args) {
        double[] array = new double[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] =  (Math.random() * 1000000 + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        long startTime, endTime, myTime, systemTime;

        startTime = System.nanoTime();
        selectionSort(array);
        endTime = System.nanoTime();
        myTime = endTime - startTime;
        stringBuilder.append("내가 만든 선택정렬 시간 : " + myTime + "ns\n");

        startTime = System.nanoTime();
        Arrays.sort(array);
        endTime = System.nanoTime();
        systemTime = endTime - startTime;
        stringBuilder.append("Arrays.sort 시간 : " + systemTime + "ns\n");

        startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        systemTime = endTime - startTime;
        stringBuilder.append("merge sort 시간 : " + systemTime + "ns\n");


        // Collection Sort
        List<Double> arrayToList = new ArrayList<>();
        for(double value : arrayToList){
            arrayToList.add(value);
        }

        startTime = System.nanoTime();
        Collections.sort(arrayToList);
        endTime = System.nanoTime();
        systemTime = endTime - startTime;
        stringBuilder.append("Collection sort 시간 : " + systemTime + "ns\n");


        System.out.print(stringBuilder);
//        for(int num : array){
//            System.out.printf("%6d",num);
//        }
    }

    /**
     * 선택정렬
     */
    public static void selectionSort(double[] array) {
        double temp;
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 병합 정렬
     */
    // 5번 문제 시간 비교를 위해 추가
    private static double[] resultArray = new double[ARRAY_SIZE];

    public static void mergeSort(double[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(double[] arr, int start, int mid, int end) {
        int startIndex = start;
        int midIndex = mid + 1;
        int resultArrayIndex = 0;


        while (startIndex <= mid && midIndex <= end) {
            if (arr[startIndex] <= arr[midIndex]) {
                resultArray[resultArrayIndex++] = arr[startIndex++];
            } else {
                resultArray[resultArrayIndex++] = arr[midIndex++];
            }
        }

        while (startIndex <= mid) {
            resultArray[resultArrayIndex++] = arr[startIndex++];
        }

        while (midIndex <= end) {
            resultArray[resultArrayIndex++] = arr[midIndex++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = resultArray[i];
        }
    }
    
}
