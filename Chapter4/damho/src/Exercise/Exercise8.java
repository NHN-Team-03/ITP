package Chapter4.damho.src.Exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise8 {
    private static Scanner s;
    private static final int NUMBEROFQUIZ = 10;
    private static final int SCOREOFQUIZ = 10;
    private static Random random = new Random();
    private static int[] num1 = new int[NUMBEROFQUIZ];
    private static int[] num2 = new int[NUMBEROFQUIZ];
    private static int[] userAnswer = new int[NUMBEROFQUIZ];

    private static void initNumbers() {
        for (int i = 0; i < NUMBEROFQUIZ; i++) {
            num1[i] = random.nextInt(100) + 1;
            num2[i] = random.nextInt(100) + 1;
        }
    }

    private static void startQuiz() {
        for (int i = 0; i < NUMBEROFQUIZ; i++) {
            System.out.print((i + 1) + "번 째 문제 : " + num1[i] + " + " + num2[i] + " = ");
            userAnswer[i] = s.nextInt();
        }
    }

    private static void calcQuiz() {
        StringBuilder sb = new StringBuilder();
        int count;
        int result;

        count = 0;
        for (int i = 0; i < NUMBEROFQUIZ; i++) {
            result = num1[i] + num2[i];
            if (userAnswer[i] == result) {
                sb.append("문제 " + (i+1) + "번 정답입니다.");
                count++;
            } else {
                sb.append("문제 " + (i+1) + "번 틀렸습니다. 정답은 " + result + "입니다.");
            }
            sb.append("\n");
        }
        sb.append("점수는 " + count*SCOREOFQUIZ + "점 입니다.");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        s = new Scanner(System.in);
        initNumbers();
        startQuiz();
        calcQuiz();
        s.close();
    }
}
