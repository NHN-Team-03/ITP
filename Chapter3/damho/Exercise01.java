package Chapter3.damho;

import java.util.Random;

public class Exercise01 {
    public static void main(String[] args) {
        int count;
        int diceNum1;
        int diceNum2;

        count = 0;
        while (true) {
            diceNum1 = Dice.roll();
            diceNum2 = Dice.roll();

            if (diceNum1 == 1 && diceNum2 == 1) {
                break;
            }
            count++;
        }
        System.out.println("시행 횟수 : " + count);
    }
}

class Dice {
    private Dice() {
    }

    private static Random random = new Random();

    public static int roll() {
        return random.nextInt(6) + 1;
    }
}