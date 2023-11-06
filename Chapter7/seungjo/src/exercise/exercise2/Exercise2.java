package exercise.exercise2;

public class Exercise2 {

    private static int[][] transpose(int[][] originalMatrix) {

        int R = originalMatrix.length;
        int C = originalMatrix[0].length;

        int[][] result = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[j][i] = originalMatrix[i][j];
            }
        }
        return result;
    }

    private static void printMatrix(int[][] originalMatrix) {
        for (int[] row : originalMatrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] result = transpose(originalMatrix);

        System.out.println("Original Matrix");
        printMatrix(originalMatrix);


        System.out.println("\nTranspose Matrix");
        printMatrix(result);
    }


}
