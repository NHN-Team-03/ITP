public class QuickSort {

    public static void main(String[] args) {
        double[] arr = new double[] { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
        quickSort(arr, 0, arr.length - 1);
        for (double value : arr) {
            System.out.println(value);
        }
    }

    public static void quickSort(double[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = right;
        int index = left;
        double temp;

        while (index < pivot) {
            if (arr[index] > arr[pivot]) {
                temp = arr[index];
                arr[index] = arr[pivot - 1];
                arr[pivot - 1] = temp;

                temp = arr[pivot];
                arr[pivot] = arr[pivot - 1];
                arr[pivot - 1] = temp;
                pivot--;
            } else {
                index++;
            }
        }

        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }
}