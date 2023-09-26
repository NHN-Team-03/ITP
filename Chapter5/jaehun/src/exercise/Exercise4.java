package exercise;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean playCheck; // 게임을 계속 반복할 건지 확인하는 변수
        int number;
        Hand hand = new BlackjackHand();
        Deck deck = new Deck();
        String checkString;

        deck.shuffle();

        do {
            while (hand.getCardCount() != 0) {
                hand.removeCard(0);
            }

            System.out.println(hand.getCardCount());

            System.out.print("2에서 6 사이의 받기를 원하는 카드 수를 입력하세요 : ");
            number = scanner.nextInt();

            if (number < 2 || number > 6) {
                throw new IllegalArgumentException("범위를 벗어난 숫자입니다. 게임을 종료합니다.");
            }

            for (int i = 0; i < number; i++) {
                hand.addCard(deck.dealCard());
            }

            System.out.println(((BlackjackHand) hand).getBlackjackValue());

            System.out.print("게임을 더 진행 하시겠습니까?");
            checkString = scanner.next();

            if (checkString.equals("Yes") || checkString.equals("Y")) {
                playCheck = true;
            } else if (checkString.equals("No") || checkString.equals("N")) {
                playCheck = false;
            } else {
                throw new IllegalArgumentException("허용되지 못한 문자를 입력했습니다. 게임을 종료합니다.");
            }

        } while (playCheck);
    }
}
