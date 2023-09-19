package exercise.exercise5;

public class Main {

    private static int ARR_SIZE = 100;

    public static void main(String[] args) {
        double[] array = new double[ARR_SIZE];

        for (int i = 0; i < ARR_SIZE; i++) {
            array[i] = Math.random() * 100;
        }

        long startTime, endTime;
        startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        endTime = System.nanoTime();
        System.out.println("걸린 시간 : " + (endTime - startTime) + "ns");

//        for (int i = 0; i < ARR_SIZE; i++) {
//            System.out.println(array[i]);
//        }
    }

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
        double[] resultArray = new double[end + 1];

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
            arr[i] = resultArray[i - start];
        }
    }
}
