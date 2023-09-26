package Chapter2.damho;

import java.util.Random;

public class Exam2_2 {
    public static void main(String[] args) {
        int diceNum1 = Dice.roll();
        int diceNum2 = Dice.roll();
        System.out.println("The first die comes up " + diceNum1);
        System.out.println("The second die comes up " + diceNum2);
        System.out.println("Your total roll is " + (diceNum1 + diceNum2));

    }
}

class Dice {
    private Dice() {
    }

    public static int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}