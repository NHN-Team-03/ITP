package Chapter7.yongjun.src.exercise;

import java.util.Arrays;

public class Exercise2 {
    static int[][] m = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    public static void main(String[] args) {
        int[][] s = new int[3][3];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < s.length; j++) {
                s[i][j] = m[j][i];
                System.out.print(s[i][j]);
            }
            System.out.println();
        }

    }
}
