package example;

import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return -1;
        } else {
            int mid = (left + right) / 2;

            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                return binarySearch(arr, left, mid - 1, value);
            } else {
                return binarySearch(arr, mid + 1, right, value);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 9, 10, 7};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr, 0, arr.length - 1, 7));
    }
}
