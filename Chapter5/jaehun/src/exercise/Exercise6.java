package exercise;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        int score = 0;
        int answer;
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            AddtionQuestion question = new AddtionQuestion();
            System.out.println(question.getQuestion());
            answer = scanner.nextInt();
            if(question.getCordirectAnswer() == answer) {
                score += 10;
            }
        }

        System.out.println(score);
    }
}
