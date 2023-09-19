package example;

/**
 * InsertionSorce
 */
public class InsertionSort {
    public static void insertionSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int loc = i - 1;
            while (loc >= 0 && A[loc] > temp) {
                A[loc + 1] = A[loc];
                loc = loc - 1;
            }
            A[loc + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] A = { 4, 11, 13, 17, 35, 15, 7, 45, 12, 19, 3, 12 };
        insertionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}