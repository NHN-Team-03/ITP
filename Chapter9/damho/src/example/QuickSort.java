package example;

public class QuickSort {
    static int quicksortStep(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (high > low) {
            while (high > low && arr[high] >= pivot) {
                high--;
            }

            if (high == low) {
                break;
            }

            arr[low] = arr[high];
            low++;

            while (high > low && arr[low] <= pivot) {
                low++;
            }

            if (high == low) {
                break;
            }

            arr[high] = arr[low];
            high--;
        }
        arr[low] = pivot;
        return low;
    }

    static void quicksort(int[] arr, int low, int high) {
        if (high <= low) {
            return;
        }
        int pivot = quicksortStep(arr, low, high);
        quicksort(arr, low, pivot - 1);
        quicksort(arr, pivot + 1, high);
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void randomArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100) + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        randomArray(arr);

        printArray(arr);
        quicksort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
