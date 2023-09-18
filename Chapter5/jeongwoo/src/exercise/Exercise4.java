package exercise;

public class Exercise4 {
    public static void main(String[] args) {
        Deck deck;
        Card card;
        BlackjackHand hand;
        int cardsInHand;
        boolean again;

        deck = new Deck();

        do {
            deck.shuffle();
            hand = new BlackjackHand();
            cardsInHand = 2 + (int) (Math.random() * 5);
            System.out.println();
            System.out.println();
            System.out.println("Hand contains:");
            for (int i = 1; i <= cardsInHand; i++) {
                // Get a card from the deck, print it out,
                //   and add it to the hand.
                card = deck.dealCard();
                hand.addCard(card);
                System.out.println("    " + card);
            }
            System.out.println("Value of hand is " + hand.getBlackjackValue());
            System.out.println();
            System.out.print("Again? ");
            again = TextIO.getlnBoolean();
        } while (again == true);
    }
}

