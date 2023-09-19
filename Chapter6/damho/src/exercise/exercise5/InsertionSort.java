package exercise.exercise5;

public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int loc = i - 1;
            int temp = arr[i];
            while (loc >= 0 && arr[loc] > temp) {
                arr[loc + 1] = arr[loc];
                loc = loc - 1;
            }
            arr[loc + 1] = temp;
        }
    }

    
}
