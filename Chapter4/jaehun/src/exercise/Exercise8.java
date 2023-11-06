package Chapter4.jaehun.src.exercise;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        int score = 0;

        System.out.println("덧셈 문제를 생성합니다. 양의 정수 1~100 까지의 범위에서 제출됩니다.");
        for(int i = 0; i < 10; i++) {   
            System.out.print("문제" + (i+1) + ". ");
            score = quiz(score);
        }

        System.out.println("점수는 " + score);
    }

    private static int quiz(int score) {
        Scanner scanner = new Scanner(System.in);
        int num1 = (int)(Math.random() * 100) + 1;
        int num2 = (int)(Math.random() * 100) + 1;

        System.out.print(num1 + " + " + num2 + " = ");
        int input = scanner.nextInt();

        if(input == sum(num1, num2)) {
            score += 10;
        }

        return score;
    }

    private static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
