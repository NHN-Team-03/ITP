package exercise;

import java.util.Scanner;

import exercise.blackjack.BlackjackHand;
import exercise.blackjack.Deck;

public class Exercise5 {
    public static void main(String[] args) {
        Blackjack blackjack = new Blackjack();
        blackjack.startBlackjack();
    }
}

class Blackjack {
    private Deck deck;
    private BlackjackHand dealerHand;
    private BlackjackHand playerHand;
    private int playerMoney;
    private int bettingMoney = 0;
    private Scanner scanner = new Scanner(System.in);

    public Blackjack() {
        this(1_000_000);
    }

    public Blackjack(int playerMoney) {
        deck = new Deck(false);
        dealerHand = new BlackjackHand();
        playerHand = new BlackjackHand();
        this.playerMoney = playerMoney;
        System.out.println("player의 돈은 " + this.playerMoney + "입니다");
    }

    private void dealCard(BlackjackHand blackjackHand) {
        blackjackHand.addCard(deck.dealCard());
    }

    private void shuffle() {
        deck.shuffle();
    }

    private void initField() {
        if (deck.cardsLeft() < 4) {
            System.out.println("카드가 부족하여 덱을 다시 섞습니다.");
            deck.shuffle();
        }
        dealCard(dealerHand);
        dealCard(dealerHand);
        dealCard(playerHand);
        dealCard(playerHand);
    }

    private String printHand(BlackjackHand blackjackHand, int index) {
        return " | " + blackjackHand.getCard(index).toString() + " | ";
    }

    private String printHandAll(BlackjackHand blackjackHand) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < blackjackHand.getCardCount(); i++) {
            builder.append(printHand(blackjackHand, i));
        }
        return builder.toString();
    }

    private int calcHand(BlackjackHand blackjackHand) {
        return blackjackHand.getBlackjackValue();
    }

    private void bet() {
        while (true) {
            System.out.print("배팅 금액을 입력해주세요 : ");
            int inputMoney = scanner.nextInt();

            if (inputMoney > 0 && inputMoney <= playerMoney) {
                this.playerMoney -= inputMoney;
                this.bettingMoney = inputMoney;
                break;
            }

            if (inputMoney > playerMoney) {
                System.out.println("플레이어의 돈보다 많은 돈을 배팅할 수 없습니다.\n플레의어의 남은 돈 : " + playerMoney);
            } else if (inputMoney < 0) {
                System.out.println("0원보다 적은 돈을 배팅할 수 없습니다.");
            }
        }
    }

    private boolean playBlackjack() {
        shuffle();

        initField();

        if (dealerHand.getBlackjackValue() == 21) {
            return false;
        } else if (playerHand.getBlackjackValue() == 21) {
            return true;
        }

        System.out.println("딜러 카드 1개 오픈 : " + printHand(dealerHand, 0));
        System.out.println("플레이어 카드 : " + printHandAll(playerHand));

        while (true) {
            System.out.print("hit : h, stand : s륵 입력해주세요(대문자, 소문자 아무거나 가능) : ");
            String playerChoice = scanner.next().toLowerCase();
            if (playerChoice.equals("s")) {
                break;
            }

            dealCard(playerHand);
            System.out.println("플레이어 카드 : ");
            System.out.println(printHandAll(playerHand));
            if (calcHand(playerHand) > 21) {
                return false;
            }
        }

        while (true) {
            if (calcHand(dealerHand) > 21) {
                return false;
            }
            if (calcHand(dealerHand) > 16) {
                break;
            }

            dealCard(dealerHand);
            System.out.println("딜러 카드 : ");
            System.out.println(printHandAll(dealerHand));
        }

        return calcHand(playerHand) > calcHand(dealerHand);
    }

    public void startBlackjack() {
        System.out.print("블랙잭 게임을 시작하려면 o 아니면 x를 입력해 주세요 : ");
        while (true) {
            if (playerMoney == 0) {
                System.out.println("플레이어의 돈이 없어서 게임을 종료합니다.");
                return;
            }

            while (true) {
                String inputString = scanner.next().toLowerCase();
                if (inputString.equals("o")) {
                    break;
                } else if (inputString.equals("x")) {
                    System.out.println("플레이어의 돈은 " + playerMoney + "입니다. \n게임을 종료합니다.");
                    return;
                }
                System.out.print("o 또는 x만 입력해 주세요 : ");
            }

            bet();

            if (playBlackjack()) {
                System.out.println("플레이어가 이겼습니다.\n배팅금액의 2배인 " + bettingMoney * 2 + "를 땄습니다.");
                this.playerMoney += bettingMoney * 2;
                bettingMoney = 0;
            } else {
                System.out.println("딜러가 이겼습니다.\n배팅금액은 사라집니다.");
            }
        }
    }

}