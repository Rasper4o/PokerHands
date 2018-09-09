public class Card {
    private String cardString;
    private Value value;
    private Suit suit;

    public Card(String cardString) {
        this.cardString = cardString;
        this.value = Value.retrieveValue(cardString.charAt(0));
        this.suit = Suit.retrieveSuit(cardString.charAt(1));
    }

    public String getCardString() {
        return cardString;
    }

    public Value getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}
