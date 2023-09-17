package exercise;

public class Exercise3 {
    public static void main(String[] args) {
        for(int i = 2; i <= 12; i++) {
            StatCalc calc = new StatCalc();
            PairOfDice dice = new PairOfDice();
            for(int j = 0; j < 10000; j++) {
                while(true) {
                    if(dice.pairCheck(i)) {
                        break;
                    } else {
                        dice.roll();
                    }
                }
                calc.enter(dice.getCount());
                dice.initCheck();
            }

            System.out.println(i + "에 대한 calc\n" + calc);
        }
    }
}
