package exercise;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println(playGame() ? "승리" : "패배");
    }

    public static boolean playGame() {
        Scanner scanner = new Scanner(System.in);

        String answer;

        Deck deck = new Deck();
        BlackjackHand playerHand = new BlackjackHand();
        BlackjackHand dealerHand = new BlackjackHand();

        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            playerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());
        }

        if (dealerHand.getBlackjackValue() == BlackjackHand.BLACKJACK) { // 딜러의 패 값이 블랙잭이라면 딜러 우승
            return false;
        } else if (dealerHand.getBlackjackValue() == BlackjackHand.BLACKJACK) {
            return true;
        }

        System.out.println("딜러의 카드중 하나를 공개합니다.");
        System.out.println(dealerHand.getCard(0));

        while (true) {
            System.out.println("User Hand");
            for (int i = 0; i < playerHand.getCardCount(); i++) {
                System.out.println(playerHand.getCard(i));
            }

            System.out.print("Hit or Stand : ");

            answer = scanner.nextLine();

            try {
                if (answer.equals("Stand")) {
                    break;
                } else if (!answer.equals("Hit")) {
                    throw new IllegalArgumentException("규칙에 어긋나는 답입니다.");
                }
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                continue;
            }

            playerHand.addCard(deck.dealCard());

            System.out.println(playerHand.getBlackjackValue());

            if (playerHand.getBlackjackValue() > BlackjackHand.BLACKJACK) {
                return false;
            }
        }

        while (true) {
            System.out.println("Dealer Hand");
            for (int i = 0; i < dealerHand.getCardCount(); i++) {
                System.out.println(dealerHand.getCard(i));
            }

            if (dealerHand.getBlackjackValue() > 16) {
                break;
            }

            dealerHand.addCard(deck.dealCard());

            if (dealerHand.getBlackjackValue() > 21) {
                return true;
            }
        }

        if (playerHand.getBlackjackValue() > dealerHand.getBlackjackValue()) {
            return true;
        }

        return false;
    }
}
