package exercise.exercise1;

import java.util.Random;

/**
 * 주사위 두 개를 생성하는 클래스.
 */
public class PairOfDice {
    private Random random = new Random();

    private int die1;
    private int die2;

    PairOfDice() {
        roll();
    }

    public void roll() {
        this.die1 = random.nextInt(6) + 1;
        this.die2 = random.nextInt(6) + 1;
    }

    public int getDie1() {
        return this.die1;
    }

    public int getDie2() {
        return this.die2;
    }

    @Override
    public String toString() {
        return "[" + this.die1 + " " + this.die2 + "]";
    }

}
