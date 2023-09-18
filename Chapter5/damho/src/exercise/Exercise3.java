package exercise;

public class Exercise3 {
    public static void main(String[] args) {
        PairOfDice pairOfDice = new PairOfDice();
        StatCalc[] calcs = new StatCalc[13];

        for (int i = 2; i < 13; i++) {
            calcs[i] = new StatCalc();
            for (int j = 0; j < 10000; j++) {
                calcs[i].enter(pairOfDice.rollDiceUntilSumEqualN(i));
            }
        }

        for (int i = 2; i < 13; i++) {
            calcs[i].printCalc();
        }
    }
}
