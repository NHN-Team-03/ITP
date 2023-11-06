package exercise.exercise6;

import java.util.Scanner;

/**
 * 연습문제 6번의 클래스.
 */
public class Exercise6 {

    private static AdditionQuestion[] quiz;
    private static int[] answer;

    /**
     * 연습문제 6번의 Main Method.
     */
    public static void main(String[] args) {
        createQuiz();
        adminQuiz();
        checkQuiz();
    }

    private static void adminQuiz() {
        Scanner sc = new Scanner(System.in);
        answer = new int[10];

        for (int i = 0; i < answer.length; i++) {
            System.out.print("Quiz " + (i + 1) + " : " + quiz[i].getQuestion());
            answer[i] = sc.nextInt();
        }
    }

    private static void checkQuiz() {
        int score = 0;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == quiz[i].getCorrectAnswer()) {
                score += 10;
            }
        }
        System.out.println("Your score is " + score);
    }

    /**
     * quiz를 생성하는 메서드.
     */
    public static void createQuiz() {
        quiz = new AdditionQuestion[10];

        for (int i = 0; i < quiz.length; i++) {
            quiz[i] = new AdditionQuestion();
        }
    }

}
