package exercise;

public class PairOfDice {
    private int die1;
    private int die2;

    private int rollCount;  // 주사위 굴림 횟수를 저장하는 변수.

    private int sum;        // 두 주사위의 합을 저장하는 변수.

    public PairOfDice() {
        this.rollCount = 0;
        this.sum = 0;

        roll();
    }

    public void roll() {
        this.die1 = (int) (Math.random() * 6) + 1;
        this.die2 = (int) (Math.random() * 6) + 1;

        rollCount++;
        this.setSum(die1 + die2);
    }

    public void initCheck() {
        rollCount = 0;
    }

    public boolean pairCheck(int number) {
        if(getSum() == number) {
            return true;
        }

        return false;
    }

    private void setSum(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public int getDie1() {
        return this.die1;
    }

    public int getDie2() {
        return this.die2;
    }

    public int getCount() {
        return this.rollCount;
    }

    public String toString() {
        return "주사위를 굴린 횟수 : " + getCount();
    }
}
