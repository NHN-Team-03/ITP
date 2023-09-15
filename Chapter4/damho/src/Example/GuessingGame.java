package Chapter4.damho.src.Example;

import java.util.Random;
import java.util.Scanner;

/**
 * GuessingGame
 */
public class GuessingGame {
    private static Random random = new Random();
    private static Scanner s = new Scanner(System.in);

    public static void startGuessingGame() {
        int computerValue;
        int count;
        int inputValue;

        computerValue = random.nextInt(100) + 1;

        count = 0;
        while (true) {
            System.out.print("값을 입력해 주세요 : ");
            inputValue = Integer.valueOf(s.nextLine());
            if (count == 6) {
                System.out.println("컴퓨터가 이겼습니다. 컴퓨터 값은 : " + computerValue);
                break;
            }
            if (inputValue == computerValue) {
                System.out.println("플레이어가 이겼습니다!!!!!");
                break;
            }
            if (inputValue < computerValue) {
                System.out.println("입력 값이 더 작습니다. 더 큰 값을 입력하세요");
            } else {
                System.out.println("입력 값이 더 큽니다. 더 작은 값을 입력하세요");
            }
            count++;
        }
    }

    public static void main(String[] args) {
        System.out.println("welcome to Guessing Game");
        String inputString;
        while (true) {
            System.out.println("게임을 그만 하시려면 X를 입력해주세요. : ");
            inputString = s.nextLine();
            if (inputString.equals("X")) {
                break;
            }
            startGuessingGame();
        }
        s.close();
    }
}