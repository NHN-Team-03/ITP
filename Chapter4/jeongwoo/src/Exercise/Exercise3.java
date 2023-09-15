package Exercise;

public class Exercise3 {
    public static void main(String[] args) {
        int count = sumDoubleDice(2);
        System.out.println("걸린 횟수 : " + count);
    }

    private static int sumDoubleDice(int input) {

        int dice1, dice2;
        int sum = 0;
        int count = 0;
        if (!(2 <= input && input <= 12)) {
            throw new IllegalArgumentException("두개의 주사위 합은 2 ~ 12 입니다.");
        }

        while (sum != input) {
            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            sum = dice1 + dice2;
            count++;
        }

        return count;
    }
}
