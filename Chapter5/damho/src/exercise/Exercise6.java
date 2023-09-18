package exercise;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
    }
}

class Quiz {
    private Scanner scanner = new Scanner(System.in);
    private AdditionQuestion[] quiz = new AdditionQuestion[10];
    private int[] answer = new int[10];

    public Quiz() {
        for (int i = 0; i < 10; i++) {
            quiz[i] = new AdditionQuestion();
        }
    }

    public void startQuiz() {
        StringBuilder builder = new StringBuilder();
        int score = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println(quiz[i].getQuestion());
            answer[i] = scanner.nextInt();
        }

        for (int i = 0; i < 10; i++) {
            if (answer[i] == quiz[i].getCorrectAnswer()) {
                builder.append("맞았습니다!!\n");
                score += 10;
            } else {
                System.out.println();
                builder.append("틀렸습니다. 정답은 " + quiz[i].getCorrectAnswer() + "입니다.\n");
            }
        }

        builder.append("점수는 " + score + "입니다.");
        System.out.println(builder.toString());
    }

    class AdditionQuestion {

        private int a, b; // The numbers in the problem.

        public AdditionQuestion() { // constructor
            a = (int) (Math.random() * 50 + 1);
            b = (int) (Math.random() * 50);
        }

        public String getQuestion() {
            return "What is " + a + " + " + b + " ?";
        }

        public int getCorrectAnswer() {
            return a + b;
        }

    }
}