package exercise.exercise1;

public class Array {
    public static int[] makeRandomIntArray(int number, int max) {
        int[] arr = new int[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) + 1;
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i] + " ");
        }
        System.out.println(builder.toString());
    }
}
