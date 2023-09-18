package exercise.exercise5;

/**
 * Hand 클래스를 Extends 받은 BlackjackHand
 * 즉, Hand의 하위 클래스인 BlackjackHand.
 */

public class BlackjackHand extends Hand {


    /**
     * 블랙잭 게임에서 해당 손패의 값을 계산하여 반환한다.
     */
    public int getBlackjackValue() {

        int val;
        boolean ace;

        int cards;

        val = 0;
        ace = false;
        cards = getCardCount();

        for (int i = 0; i < cards; i++) {

            Card card;
            int cardVal;
            card = getCard(i);
            cardVal = card.getValue();

            if (cardVal > 10) {
                cardVal = 10; // For a Jack, Queen or King.
            }

            if (cardVal == 1) {
                ace = true;
            }
            val = val + cardVal;
        }

        if (ace && val + 10 <= 21) {
            val = val + 10;
        }

        return val;
    }
}
