package exercise;

import java.util.Scanner;

import exercise.blackjack.BlackjackHand;
import exercise.blackjack.Deck;
import exercise.blackjack.Hand;

public class Exercise4 {
    public static void main(String[] args) {
        Blackjack4 blackjack = new Blackjack4();
        blackjack.startBlackjack();
    }
}

class Blackjack4 {
    private Deck deck;
    private Hand blackjackHand;
    private int numberOfCards;

    public Blackjack4() {
        deck = new Deck(false);
        blackjackHand = new BlackjackHand();
        numberOfCards = (int) (Math.random() * 4) + 2;
    }

    public void printBlackjackHand() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < blackjackHand.getCardCount(); i++) {
            builder.append(blackjackHand.getCard(i) + " | ");
        }
        System.out.println(builder.toString());
    }

    public int blackjackValue() {
        return ((BlackjackHand) blackjackHand).getBlackjackValue();
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void dealCard() {
        try {
            for (int i = 0; i < numberOfCards; i++) {
                blackjackHand.addCard(deck.dealCard());
            }
        } catch (IllegalStateException illegalStateException) {
            System.out.println("덱을 다 소진하여 카드를 다시 섞어서 시작합니다.");
            clear();
            shuffleDeck();
            dealCard();
        }
    }

    public void clear() {
        blackjackHand.clear();
    }

    public void startBlackjack() {
        Scanner scanner = new Scanner(System.in);
        shuffleDeck();
        while (true) {
            System.out.println("그만 하려면 x, X를 입력해 주세요. 계속 하려면 아무 글자나 입력.");
            String inputString = scanner.next().toLowerCase();
            if (inputString.equals("x")) {
                break;
            }
            clear();
            dealCard();
            printBlackjackHand();
            System.out.println(blackjackValue());
        }
        scanner.close();
    }
}