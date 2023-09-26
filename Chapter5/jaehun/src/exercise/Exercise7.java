package exercise;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        IntQuestion[] intQuestion = new IntQuestion[10];
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int answer;

        for(int i = 0; i < 10; i++) {
            if(i % 2 == 0) {
                intQuestion[i] = new AddtionQuestion();
            } else {
                intQuestion[i] = new SubtractionQuestion();
            }
        }

        for(int i = 0; i < 10; i++) {
            System.out.print(intQuestion[i].getQuestion());
            answer = scanner.nextInt();

            if(intQuestion[i].getCordirectAnswer() == answer) {
                score += 10;
            }
        }
        
        System.out.println(score);
    }
}
