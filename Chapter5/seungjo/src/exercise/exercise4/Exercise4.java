package exercise.exercise4;

import java.util.Scanner;

/**
 * 연습문제 4번 클래스.
 */
public class Exercise4 {

    /**
     * 연습문제 4번 클래스의 Main Method.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlackjackHand hand = new BlackjackHand();
        Deck deck = new Deck();

        System.out.print("Enter the number (2 ~ 6): ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            hand.addCard(deck.dealCard());
        }
        
        for (int i = 0; i < hand.getCardCount(); i++) {
            System.out.println(hand.getCard(i));
        }
        System.out.println(hand.getBlackjackValue());
    }
}
