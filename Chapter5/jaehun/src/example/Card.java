package example;

public class Card {
    public static final int SPADE = 0;
    public static final int HEART = 1;
    public static final int DIAMOND = 2;
    public static final int CLOVER = 3;
    public static final int JOKER = 4;

    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;

    private final int suit;
    private final int value;

    public Card() {
        suit = JOKER;
        value = 1;
    }

    public Card(int theValue, int theSuit) {
        if (theSuit != SPADE && theSuit != HEART && theSuit != DIAMOND && theSuit != CLOVER && theSuit != JOKER) {
            throw new IllegalArgumentException("허용되지 않은 카드 문양");
        }
        if (theSuit != JOKER && (theValue < 1 || theValue > 13)) {
            throw new IllegalArgumentException("허용되지 않은 카드 값");
        }

        value = theValue;
        suit = theSuit;
    }

    public int getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String getSuitAsString() {
        switch (suit) {
            case SPADE:
                return "SPADE";
            case HEART:
                return "HEART";
            case DIAMOND:
                return "DIAMOND";
            case CLOVER:
                return "CLOVER";
            default:
                return "JOKER";
        }
    }

    public String getValueAsSting() {
        if (suit == JOKER) {
            return "" + value;
        } else {
            switch (value) {
                case 1:
                    return "ACE";
                case 2:
                    return "2";
                case 3:
                    return "3";
                case 4:
                    return "4";
                case 5:
                    return "5";
                case 6:
                    return "6";
                case 7:
                    return "7";
                case 8:
                    return "8";
                case 9:
                    return "9";
                case 10:
                    return "10";
                case 11:
                    return "JACK";
                case 12:
                    return "QUEEN";
                default:
                    return "KING";

            }
        }
    }

    public String toString() {
        if(suit == JOKER) {
            if(value == 1) {
                return "JOKER";
            } else {
                return "JOKER #" + value;
            }
        } else {
            return getValueAsSting() + " " + getSuitAsString();
        }
    }

}
