package Chapter4.youngjun.src.exercise;

import java.util.Random;
import java.util.Scanner;

public class Exercise6 {

    public static int[] first = new int[10];
    private static int[] second = new int[10];
    private static int[] answer = new int[10];

    public static void main(String[] args) {

        makerQuiz();
        playQuiz();
        gradingQuiz();
        // System.out.print(n+"번 문제");
        // System.out.println( a + " + " + b);

    }

    private static void gradingQuiz() {
        int grad = 0;
        for (int i = 0; i < answer.length; i++) {
            int sum  = first[i] + second[i];
            if(sum == answer[i]){
                grad +=10;
            }
        }
        System.out.println("score = "+grad);
    }

    private static void playQuiz() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(first[i] + " + " + second[i]+ " = ");
            answer[i] = scanner.nextInt();
        }

    }

    private static void makerQuiz() {
        Random random = new Random();
        for (int i = 0; i < first.length; i++) {
            first[i] = random.nextInt(100);
            second[i] = random.nextInt(100);
        }
    }
}
