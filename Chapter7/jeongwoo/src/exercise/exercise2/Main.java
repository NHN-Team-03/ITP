package exercise.exercise2;

public class Main {

    public static void main(String[] args) {
        int arrayM[][] = new int[][] {
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        };
        printArray(transposeArray(arrayM));
    }

    public static int[][] transposeArray(int[][] arrayM) {

        int arrayT[][] = new int[arrayM[0].length][arrayM.length];

        for (int i = 0; i < arrayM.length; i++) {
            for (int j = 0; j < arrayM[0].length; j++) {
                arrayT[j][i] = arrayM[i][j];
            }
        }

        return arrayT;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
