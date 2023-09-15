package Chapter4.damho.src.Exercise;

import java.util.Random;

public class Exercise3 {
    private static Random random = new Random();

    public static int diceRoll(int diceSum) {
        if (diceSum > 12 || diceSum < 2) {
            throw new IllegalArgumentException("다이스의 총 합은 2부터 12까지만 가능합니다.");
        }
        int count = 0;
        int diceNum1;
        int diceNum2;
        while (true) {
            count++;
            diceNum1 = random.nextInt(6) + 1;
            diceNum2 = random.nextInt(6) + 1;
            if (diceNum1 + diceNum2 == diceSum) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("뱀눈을 얻기 위해 필요한 굴림 횟수 : " + diceRoll(2));
    }
}
