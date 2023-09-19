package example;

/**
 * ForEachLoops
 */
public class ForEachLoops {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int x : arr) {
            x = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}