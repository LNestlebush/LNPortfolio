//This class represents a simple game of 21.
//It uses the DeckManager to manage the deck of cards
//and the Card class to represent individual cards.
//The game allows a player to draw cards, keep track of their score,
//and determine if they win or lose based on their score.



import java.util.*;

public class GameTest {
    public static void main(String[] args) {

        //Create a scanner for user input
        //Create a DeckManager to manage the game
        //Show instructions for the game
        Scanner scanner = new Scanner(System.in);
        DeckManager deck = new DeckManager();
        deck.showInstructions();

        //Initialize the player's score and game over flag
        int playerScore = 0;
        boolean gameOver = false;


        //Game loop: keep drawing cards until the game is over
        while (!gameOver) {
            Card drawnCard = deck.dealCard();
            if (drawnCard == null) {
                System.out.println("Deck is out of cards! Game over.");
                break;
            }
            //Display the drawn card and update the player's score
            System.out.println("You drew: " + drawnCard);
            playerScore += getCardValue(drawnCard);

            //Display the player's current score
            System.out.println("Your current score: " + playerScore);

            //Check if the player has busted or wants to stop
            if (playerScore > 21) {
                System.out.println("Bust! You lose.");
                gameOver = true;
            } else {
                System.out.print("Draw another card? (y/n): ");
                String choice = scanner.next();
                if (!choice.equalsIgnoreCase("y")) {
                    gameOver = true;
                } else {
                    deck.discardCard(drawnCard);
                }
            }
        }
        System.out.println("Final score: " + playerScore);
        scanner.close();
    }

    //Method to get the value of a card based on its face
    //Face cards are worth 10, Aces are worth 11, and numbered cards are worth their face value
    private static int getCardValue(Card card) {
        String face = card.getFace();
        if (face.equals("J") || face.equals("Q") || face.equals("K")) {
            return 10;
        } else if (face.equals("A")) {
            return 11;
        } else {
            return Integer.parseInt(face);
        }
    }
}
