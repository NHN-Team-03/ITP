package Chapter4.jaehun.src.exercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;

        System.out.print("주사위의 합을 입력하세요: ");
        int diceSum = scanner.nextInt();

        count = diceRoll(diceSum);

        System.out.println("주사위를 굴린 횟수는 " + count);

        scanner.close();
    }

    public static int diceRoll(int number) {
        int count = 0;
        while (true) {
            int dice1 = (int) (Math.random() * 6) + 1;
            int dice2 = (int) (Math.random() * 6) + 1;

            count++;

            if(number == sum(dice1, dice2)) {
                break;
            }
        }

        return count;
    }

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }
}
