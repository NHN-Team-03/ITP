package exercise;


public class Exercise2 {

    public static void main(String[] args) {
        int[][] M = {
            {1, 2, 3, 4, 5},
            {6, 7, 8},
            {9, 10}
        };

        int[][] T = transpose(M);

        for(int i = 0; i < T.length; i++) {
            for(int j = 0; j < T[i].length; j++) {
                if(T[i][j] != 0) {
                    System.out.print(T[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] transpose(int[][] m) {
        int[][] T = new int[m[0].length][m.length];
        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[i].length; j++) {
                T[j][i] = m[i][j];
            }
        }
    
        return T;
    }
    
}
