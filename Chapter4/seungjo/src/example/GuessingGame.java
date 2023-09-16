package example;

import java.util.Scanner;

public class GuessingGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("게임을 시작합니다. 1과 100 사이의 숫자를");
        System.out.println("내가 고르고, 당신은 이 숫자를 맞춰보세요.");

        boolean playAgain;
        do {
            playGame();
            System.out.print("다시 게임을 하시겠습니까? ");
            playAgain = sc.nextBoolean();
        } while(playAgain);
        System.out.println("게임을 종료합니다.");
        sc.close();
    }

    static void playGame() {
        int computerNumber;
        int usersGuess;
        int guessCount = 0;

        computerNumber = (int) (100 * Math.random() + 1);
        
        System.out.println();
        System.out.print("첫 번째 추측 값: ");

        while(true) {
            usersGuess = sc.nextInt();
            guessCount++;

            if (usersGuess == computerNumber) {
                System.out.println(guessCount + " 번의 추측으로 맞추었습니다! 숫자는 " + computerNumber);
                break;
            }

            if (guessCount == 6) {
                System.out.println("6번의 추측으로 숫자를 얻지 못하였습니다..");
                System.out.println("게임에서 졌습니다. 숫자는 " + computerNumber);
                break;
            }

            if (usersGuess < computerNumber) {
                System.out.print("더 높은 숫자를 입력하세요!");
            } else {
                System.out.print("더 낮은 숫자를 입력하세요!");
            }
            System.out.println();
        }
    }
}