package example;

public class BinarySearch {

    public static int binarySearch(int[] arr, int number) {

        int low = 0;
        int high = arr.length - 1;

        while (high >= low) {
            int middle = (low + high) / 2;

            if (arr[middle] == number) {
                return middle;
            }

            else if (arr[middle] > number) {
                high = middle - 1;
            }

            else {
                low = middle + 1;
            }
        }

        // 만약 끝까지 가서 찾지 못한다면 -1.
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] { 1, 2, 3, 4, 5, 6}, 5));
    }
}
