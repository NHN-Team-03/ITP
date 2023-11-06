package exercise;

import java.util.Scanner;

public class Exercise8 {

    private static int[] firstNumber;
    private static int[] secondNumber;

    public static void main(String[] args) {
        makeQuiz();
        manageQuiz();
    }

    private static void makeQuiz() {
        firstNumber = new int[10];
        secondNumber = new int[10];
        for (int i = 0; i < 10; i++) {
            firstNumber[i] = (int) (Math.random() * 100);
            secondNumber[i] = (int) (Math.random() * 100);
        }
    }

    private static void manageQuiz() {
        Scanner s = new Scanner(System.in);
        int input = 0;
        int count = 0;
        for (int i = 0; i < firstNumber.length; i++) {
            System.out.print(firstNumber[i] + " + " + secondNumber[i] + " = ");
            input = s.nextInt();
            if (checkQuiz(input, i)) {
                count += 10;
            }
        }
        System.out.println("최종 점수 : " + count);

        s.close();
    }

    private static boolean checkQuiz(int input, int index) {
        if (firstNumber[index] + secondNumber[index] == input) {
            return true;
        } else {
            return false;
        }
    }
}