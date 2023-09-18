package exercise;

public class PairOfDice {
    private int die1;
    private int die2;

    public PairOfDice() {
        roll();
    }

    public void roll() {
        die1 = (int) (Math.random() * 6) + 1;
        die2 = (int) (Math.random() * 6) + 1;
    }

    @Override
    public String toString() {
        return die1 == die2 ? "Double" + die1 : die1 + " & " + die2;
    }

    public int getTotal() {
        return die1 + die2;
    }


    public void findValue() {
        int count = 0;

        while (getTotal() != 2) {
            roll();
            count++;
        }

        System.out.println("찾는데 걸린 횟수는 : " + count);
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public void setDie1(int die1) {
        if (6 < die1 || die1 < 0) {
            throw new IllegalArgumentException("잘못된 값");
        }
        this.die1 = die1;
    }

    public void setDie2(int die2) {
        if (6 < die2 || die2 < 0) {
            throw new IllegalArgumentException("잘못된 값");
        }
        this.die2 = die2;
    }
}

