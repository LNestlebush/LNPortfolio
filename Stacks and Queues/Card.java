//This class represents a playing card with a face and a suit.
// It includes methods to get the face and suit of the card,
// and a toString method to display the card in a readable format.



public class Card {
    private String face;
    private String suit;

    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    public String getFace() {
        return face;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}

