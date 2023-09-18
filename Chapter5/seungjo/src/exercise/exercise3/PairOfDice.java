package exercise.exercise3;

import java.util.Random;

/**
 * 두 개의 주사위를 굴리는 클래스.
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

    public int getTotal() {
        return getDie1() + getDie2();
    }

}
