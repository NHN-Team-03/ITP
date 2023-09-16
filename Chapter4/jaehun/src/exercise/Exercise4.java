package Chapter4.jaehun.src.exercise;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        for(int i = 2; i <= 12; i++) {
            System.out.println(avgDiceRoll(i));
        }
    }

    private static double avgDiceRoll(int number) {
        double sum = 0;
        for(int i = 0; i < 10000; i++) {
            sum += diceRoll(number);
        }

        return sum / 10000;
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
