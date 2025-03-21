//This class creates a deck of cards
//and manages the game of 21.
//It includes methods to deal cards, discard them, and reshuffle the deck when needed.
//It also provides instructions for the game.



import java.util.*;

public class DeckManager {

    //Initialize the deck and discard pile
    //and a random number generator for shuffling.
    private Stack<Card> deck;
    private Queue<Card> discardPile;
    private Random rand;

    // Method to show instructions for the game
    public void showInstructions() {
        System.out.println("Welcome to the game of 21!");
        System.out.println("Try to get as close to 21 as possible without going over.");
        System.out.println("Face cards (J, Q, K) are worth 10 points, Aces are worth 11.");
    }

    //Constructor to initialize the deck with 52 cards
    //and shuffle them.
    public DeckManager() {
        String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new Stack<>();
        discardPile = new LinkedList<>();
        rand = new Random();

        List<Card> tempDeck = new ArrayList<>();
        for (String suit : suits) {
            for (String face : faces) {
                tempDeck.add(new Card(face, suit));
            }
        }
        Collections.shuffle(tempDeck, rand);
        deck.addAll(tempDeck);
    }


    //Methods to deal a card, discard a card,
    //and reshuffle the discard pile back into the deck.
    public Card dealCard() {
        if (deck.isEmpty()) {
            reshuffleDiscardPile();
        }
        return deck.isEmpty() ? null : deck.pop();
    }

    public void discardCard(Card card) {
        discardPile.add(card);
    }

    private void reshuffleDiscardPile() {
        if (!discardPile.isEmpty()) {
            List<Card> tempDeck = new ArrayList<>(discardPile);
            Collections.shuffle(tempDeck, rand);
            deck.addAll(tempDeck);
            discardPile.clear();
        }
    }

}
