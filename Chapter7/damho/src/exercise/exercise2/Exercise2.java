package exercise.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        System.out.println("전치행렬 만들기 전 행렬 : ");
        TransposedMatrix.printMatrix(matrix);

        System.out.println("전치행렬로 바꾼 후 행렬 : ");
        matrix = TransposedMatrix.transpose(matrix);
        TransposedMatrix.printMatrix(matrix);
    }
}
