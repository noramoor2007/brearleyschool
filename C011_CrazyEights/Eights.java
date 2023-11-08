import java.util.Scanner;
public class Eights { // All the other classes are the things we use in the game.
    private Player one;
    private Player two;
    private Hand discardPile; // This is the discard pile.
    private Hand drawPile; // This is the draw pile.
    // Let's create a constructor!
    private Scanner input;
    public Eights () {
        input = new Scanner (System.in);
        Deck deck = new Deck ("Deck");
        //Hand hand = new Hand ("Hand");
        // You need to shuffle the deck of cards. Call the shuffle method from the Deck class.
        deck.shuffle ();
        // You need to deal 5 cards to each player (player one and two).
        one = new Player ("Player 1");
        deck.deal (one.getHand (), 5);
        two = new Player ("Player 2");
        deck.deal (two.getHand (), 5);
        // Create a discard pile.
        discardPile = new Hand ("Discards");
        deck.deal (discardPile, 1);
        drawPile = new Hand ("Draw Pile");
        deck.dealAll (drawPile);
        // Check the player's age, and assign them names.
    }
    public boolean isDone () { // If either hand is empty the game finishes and the "isDone" method is run.
        return one.getHand ().empty () || two.getHand ().empty ();
    }
    public void reshuffle () { // When draw pile is empty, we have to shuffle the discard pile.
        Card prev = discardPile.popCard ();
        discardPile.dealAll (drawPile);
        discardPile.addCard (prev);
        drawPile.shuffle ();
    }
    public Card drawCard () {
        if (drawPile.empty ()) {
            reshuffle ();
        }
        return drawPile.popCard ();
    }
    public Player nextPlayer (Player current) {
        if (current == one) {
            return two;
        }
        else {
            return one;
        }
    }
    public void displayState () {
        one.display ();
        two.display ();
        discardPile.display ();
        System.out.println ("Draw Pile:");
        System.out.println (drawPile.size () + " Cards");
        input.nextLine ();
    }
    public void takeTurn (Player player) {
        Card prev = discardPile.last ();
        Card next = player.play (this, prev);
        discardPile.addCard (next);
        System.out.println (player.getName () + " Plays " + next);
        System.out.println ();
    }
    public void playGame () {
        Player player = one;
        // Keep playing until there's a winner.
        while (!isDone ()) {
            displayState ();
            takeTurn (player);
            player = nextPlayer (player);
        }
        // Display the final score.
        one.displayScore ();
        two.displayScore ();
    }
}
