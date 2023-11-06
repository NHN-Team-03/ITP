package exercise;

public class Exercise1 {
    public static void main(String[] args) {
        PairOfDice dice = new PairOfDice();

        while (true) {
            if(dice.pairCheck(2)) {
                break;
            } else {
                dice.roll();
            }
        }

        System.out.println(dice);
    }
}