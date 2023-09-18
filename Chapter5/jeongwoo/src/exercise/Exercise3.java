package exercise;

public class Exercise3 {
    private static final int NUMBER_OF_EXPERIMENTS = 10000;
    private static PairOfDice dice = new PairOfDice();

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls\n");
        stringBuilder.append("----------   --------------   ----------------   --------------\n");
        System.out.println(stringBuilder);

        for (int i = 2; i <= 12; i++) {
            StatCalc calc = new StatCalc();

            for (int j = 0; j < NUMBER_OF_EXPERIMENTS; j++) {
                calc.enter(rollFor(i));
            }

            System.out.printf("%6d", i);
            System.out.printf("%18.3f",calc.getMean());
            System.out.printf("%19.3f", calc.getStandarDeviation());
            System.out.printf("%14.3f", calc.getMax());
            System.out.println();
        }

    }

    static int rollFor(int num) {
        int rollCount = 0;
        do {
            dice.roll();
            rollCount++;
        } while (dice.getTotal() != num);

        return rollCount;
    }
}
