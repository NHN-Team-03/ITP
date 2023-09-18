package exercise.exercise5;

import java.util.Scanner;

/**
 * 연습문제 5번 클래스.
 */
public class Exercise5 {

    private static Scanner sc = new Scanner(System.in);
    private static final Deck deck = new Deck();

    /**
     * 블랙잭 게임을 실행하는 메서드.
     * 사용자가 이겼을 때 : return true.
     * 딜러가 이겼을 때 : return false.
     */
    public static boolean playBlackjackGame() {

        BlackjackHand playerHand = new BlackjackHand();
        BlackjackHand dealerHand = new BlackjackHand();

        for (int i = 0; i < 2; i++) {
            dealCard(playerHand);
            dealCard(dealerHand);
        }

        if (playerHand.getBlackjackValue() == 21) {
            System.out.println("Winner is Player!");
            System.out.print("player: ");
            printCard(playerHand);
            System.out.print("dealer: ");
            printCard(dealerHand);
            return true;
        }

        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("Winner is Dealer..");
            System.out.print("player: ");
            printCard(playerHand);
            System.out.print("dealer: ");
            printCard(dealerHand);
            return false;
        }

        while (true) {
            System.out.println("[Your cards]");
            printCard(playerHand);
            System.out.println("Your total is " + playerHand.getBlackjackValue());
            System.out.println("\nDealer is showing the " + dealerHand.getCard(0));
            System.out.println();

            sc.nextLine();
            char isContinue;
            System.out.print("Hit (H) or Stand(S)? :");
            do {
                isContinue = sc.nextLine().charAt(0);
                if (isContinue != 'H' && isContinue != 'S') {
                    System.out.println("Please respond H or S: ");
                }
            } while (isContinue != 'H' && isContinue != 'S');

            if (isContinue == 'S') {
                break;
            } else {
                playerHand.addCard(deck.dealCard());
                System.out.println("Your total is " + playerHand.getBlackjackValue());
                if (playerHand.getBlackjackValue() > 21) {
                    System.out.println();
                    System.out.println("You busted by going over 21. You lose.");
                    System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                    System.out.println();
                    return false;
                }
            }
        }

        while (dealerHand.getBlackjackValue() <= 16) {
            dealerHand.addCard(deck.dealCard());
            System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

            if (dealerHand.getBlackjackValue() > 21) {
                System.out.println("Dealer busted by going over 21. You win.");
                return true;
            }
        }

        return (dealerHand.getBlackjackValue() >= playerHand.getBlackjackValue()) ? false : true;

    }


    /**
     * hand에 deck에 있는 카드를 뽑아서 추가한다.
     */
    public static void dealCard(BlackjackHand hand) {
        hand.addCard(deck.dealCard());
    }

    /**
     * BlackjackHand를 받아온다.
     * hand에 있는 모든 카드들을 출력하는 메서드.
     */
    public static void printCard(BlackjackHand hand) {
        for (int i = 0; i < hand.getCardCount(); i++) {
            System.out.println(hand.getCard(i) + " ");
        }
        System.out.println();
    }

    /**
     * 연습문제 5번의 Main Method.
     */
    public static void main(String[] args) {

        System.out.println("Play the Blackjack game!");

        int money = 100;
        int betMoney = 0;
        boolean userWin = false;

        System.out.println("Let's play the Blackjack game!");
        System.out.println();

        while (true) {
            System.out.println("You have " + money + " dollars.");

            do {
                System.out.println("How many dollars do you want to bet? (Enter 0 to " + money + ").");
                System.out.print("? ");
                betMoney = sc.nextInt();

                if (betMoney < 0 || betMoney > money) {
                    System.out.println("You can enter the number between 0 to " + money + "!!");
                }
            } while (betMoney < 0 || betMoney > money);

            if (betMoney == 0) {
                break;
            }

            userWin = playBlackjackGame();

            if (userWin) {
                money += betMoney;
            } else {
                money -= betMoney;
            }

            if (money == 0) {
                System.out.println("\nLooks like you've run out of money T_T..");
                break;
            }
        }
        System.out.println();
        System.out.println("You leave with $" + money + ".");
    }

}
