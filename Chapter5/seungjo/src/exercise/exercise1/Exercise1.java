package exercise.exercise1;

/**
 * 예제 1번 클래스.
 */
public class Exercise1 {

    /**
     * Main Method.
     */
    public static void main(String[] args) {
        PairOfDice dice = new PairOfDice();
        int count = 1;

        while (dice.getDie1() != dice.getDie2()) {
            System.out.println(dice);
            dice.roll();
            count++;
        }

        System.out.println(dice);
        System.out.println("두 주사위가 같을 때 까지 돌린 굴린 횟수: " + count);
    }
}
