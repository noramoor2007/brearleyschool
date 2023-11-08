public class Main {
    public static void main (String [] args) {
        Deck deck = new Deck ("Deck"); // This creates a new instance of the Deck class.
        deck.shuffle (); // This goes to the Deck class, but in reality the CardCollection class, and calls the function, "shuffle".
        Hand hand = new Hand ("Hand");
        deck.deal (hand, 5);
        hand.welcome ();
        Eights eights = new Eights ();
        eights.playGame ();
        Hand drawPile = new Hand ("Draw Pile");
        deck.dealAll (drawPile);
        System.out.printf ("Draw Pile has %d cards.\n", drawPile.size ());
    }
}