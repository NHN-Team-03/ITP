package example;

public class Deck {
    private Card[] deck;
    private int cardUsed;

    public Deck() {
        this(false);
    }

    public Deck(boolean includeJokers) {
        if(includeJokers) {
            deck = new Card[54];
        } else {
            deck = new Card[52];
        }

        int cardCt = 0;
        for(int suit = 0; suit <= 3; suit++) {
            for(int value = 1; value <= 13; value++) {
                deck[cardCt] = new Card(value, suit);
                cardCt++;
            }
        }

        if(includeJokers) {
            deck[52] = new Card(1, Card.JOKER);
            deck[53] = new Card(2, Card.JOKER);
        }

        cardUsed = 0;
    }

    public void shuffle() {
        for(int i = deck.length - 1; i > 0; i--) {
            int rand = (int)(Math.random() * (i + 1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }

        cardUsed = 0;
    }

    public int cardsLeft() {
        return deck.length - cardUsed;
    }

    public Card dealCard() {
        if(cardUsed == deck.length) {
            throw new IllegalArgumentException("덱에 카드가 없습니다.");
        }

        cardUsed++;

        return deck[cardUsed - 1];
    }
}