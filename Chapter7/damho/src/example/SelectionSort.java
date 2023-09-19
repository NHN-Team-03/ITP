package example;

public class SelectionSort {
    public static void selectionSort(int[] A) {
        int maxIndex;
        for (int i = A.length - 1; i > 0; i--) {
            maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (A[maxIndex] < A[j]) {
                    maxIndex = j;
                }
            }
            int temp = A[i];
            A[i] = A[maxIndex];
            A[maxIndex] = temp;
        }

    }

    public static void main(String[] args) {
        int[] A = { 4, 11, 13, 17, 35, 15, 7, 45, 12, 19, 3, 12 };
        selectionSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

}
