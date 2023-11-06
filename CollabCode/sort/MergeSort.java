public class MergeSort {
    public static double[] arr = new double[] { 37, 27, 43, 3, 9, 82, 10 };
    public static double[] sortedArr = new double[arr.length];

    public static void main(String[] args) {
        mergeSort(arr, 0, arr.length - 1);
        for (double array : arr) {
            System.out.println(array);
        }
    }

    public static void mergeSort(double[] arr, int start, int end) {
        // 나누는 부분
        if (start == end) {
            return;
        }
        mergeSort(arr, start, (start + end) / 2);
        mergeSort(arr, (start + end) / 2 + 1, end);

        merge(arr, start, end);

        // 합치면서 sort 부분

    }

    public static void merge(double[] arr, int start, int end) {
        int start1 = start;
        int mid = (start1 + end) / 2;
        int index = start1;
        int start2 = mid + 1;
        while (start1 < mid && start2 <= end) {
            if (arr[start1] < arr[start2]) {
                sortedArr[index++] = arr[start1++];
            } else {
                sortedArr[index++] = arr[start2++];
            }

        }

        while (start1 <= mid) {
            sortedArr[index++] = arr[start1++];
        }
        while (start2 <= end) {
            sortedArr[index++] = arr[start2++];
        }
        for (int i = start; i <= end; i++) {
            arr[i] = sortedArr[i];
        }
    }
}