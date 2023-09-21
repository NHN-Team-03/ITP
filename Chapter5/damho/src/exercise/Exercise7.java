package exercise;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.startQuiz();
        quiz.calcScore();
    }

    static class Quiz {
        private IntQuestion[] quiz;
        private int[] answer;

        public Quiz() {
            quiz = new IntQuestion[10];
            answer = new int[10];

            for (int i = 0; i < 10; i++) {
                answer[i] = 10;
            }

            for (int i = 0; i < 5; i++) {
                quiz[i] = new AdditionQuestion();
            }

            for (int i = 5; i < 9; i++) {
                quiz[i] = new SubtractionQuest();
            }

            quiz[9] = new IntQuestion() {

                @Override
                public String getQuestion() {
                    return "임진왜란 발생 년도는? ";
                }

                @Override
                public int getCorrectAnswer() {
                    return 1592;
                }

            };
        }

        public void startQuiz() {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < quiz.length; i++) {
                while (true) {
                    System.out.println(quiz[i].getQuestion());
                    try {
                        answer[i] = scanner.nextInt();
                        break;
                    } catch (InputMismatchException inputMismatchException) {
                        System.out.println("정수를 입력해주세요. ");
                        scanner.nextLine();
                    }
                }
            }
            scanner.close();
        }

        public void calcScore() {
            int score = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < quiz.length; i++) {
                if (answer[i] == quiz[i].getCorrectAnswer()) {
                    builder.append("정답입니다!!\n");
                    score += 10;
                } else {
                    builder.append("틀렸습니다. 정답은 : " + quiz[i].getCorrectAnswer() + "입니다.\n");
                }
            }
            builder.append("점수는 : " + score + "입니다.");
            System.out.println(builder.toString());
        }
    }

    interface IntQuestion {
        public String getQuestion();

        public int getCorrectAnswer();
    }

    static class AdditionQuestion implements IntQuestion {

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

    static class SubtractionQuest implements IntQuestion {
        private int a;
        private int b;

        public SubtractionQuest() {
            this.a = (int) (Math.random() * 50 + 1);
            this.b = (int) (Math.random() * 50);
        }

        @Override
        public String getQuestion() {
            return "What is " + a + " - " + b + " ?";
        }

        @Override
        public int getCorrectAnswer() {
            return a - b;
        }

    }
}
