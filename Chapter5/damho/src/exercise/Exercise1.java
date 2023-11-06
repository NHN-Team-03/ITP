package exercise;

import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice();
        int count = pairOfDice.rollDiceUntilSumEqualN(2);
        System.out.println("총 걸린 횟수는 : " + count + " 입니다");

    }
}

class PairOfDice {
    Random random = new Random();

    private int die1;
    private int die2;

    public PairOfDice() {
        this.roll();
    }

    public void roll() {
        die1 = random.nextInt(6) + 1;
        die2 = random.nextInt(6) + 1;
    }

    public int getDie1() {
        return this.die1;
    }

    public int getDie2() {
        return this.die2;
    }

    @Override
    public String toString() {
        if (this.getDie1() == this.getDie2()) {
            return "두 주사위의 눈은 : " + this.getDie1() + "으로 같습니다.\n";
        }
        return "두 주사위의 눈은 : " + this.getDie1() + ", " + this.getDie2() + " 입니다\n";
    }

    public int rollDiceUntilSumEqualN(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("두 주사위의 총 합이 2보다 작을 수 없습니다.");
        }
        if (n > 12) {
            throw new IllegalArgumentException("두 주사위의 총 합이 12보다 클 수 없습니다.");
        }
        int count = 0;

        while (true) {
            count++;
            this.roll();
            System.out.println(this.toString());

            if (this.getDie1() + this.getDie2() == n) {
                break;
            }
        }
        return count;
    }
}