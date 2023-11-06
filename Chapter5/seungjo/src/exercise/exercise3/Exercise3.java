package exercise.exercise3;

/**
 * 예제 3번 클래스.
 */
public class Exercise3 {

    public static final int NUMBER_OF_EXPERIMENTS = 10_000;

    private static PairOfDice dice = new PairOfDice();

    /**
     * 예제 3번 클래스의 Main Method.
     */
    public static void main(String[] args) {

        System.out.println("Dice Total   Avg # of Rolls   Stand. Deviation   Max # of Rolls");
        System.out.println("----------   --------------   ----------------   --------------");

        // 주사위를 굴리고 두 합이 i의 값과 같을 때
        for (int total = 2; total <= 12; total++) {
            StatCalc calc = new StatCalc();

            for (int i = 0; i < NUMBER_OF_EXPERIMENTS; i++) {
                calc.enter(rollDice(total));
            }
            System.out.printf("%6d", total);
            System.out.printf("%18.3f", calc.getMean());
            System.out.printf("%19.3f", calc.getStandardDeviation());
            System.out.printf("%14.3f", calc.getMax());
            System.out.println();
        }
    }

    /**
     * 주사위를 굴려서 나온 값의 핪이 total일 때 까지 돌린다.
     * dice.getDie1() + dice.getDie2() == total일 때의 count 값을 리턴함.
     */
    public static double rollDice(int total) {
        int count = 0;
        do {
            dice.roll();
            count++;
        } while ((dice.getDie1() + dice.getDie2()) != total);

        return count;
    }

}
