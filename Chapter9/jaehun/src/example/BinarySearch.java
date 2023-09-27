package Chapter9.jaehun.src.example;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(binarySearch(A, 0, A.length -1 , 3));
    }

    public static int binarySearch(int[] A, int loIndex, int hiIndex, int value) {
        if(loIndex > hiIndex) {
            return -1;
        }

        int middle = (loIndex + hiIndex) / 2;

        if(value == A[middle]) {
            return middle;
        } else if(value < A[middle]) {
            return binarySearch(A, loIndex, middle - 1, value);
        } else {
            return binarySearch(A, middle + 1, hiIndex, value);
        }
    }
}
