import java.util.Scanner;
public class Player {
    private String name; // Attributes
    private Hand hand; // Players have hands which are hand objects.
    Scanner input = new Scanner (System.in);
    public Player (String name) { // When we create players we can give them a name.
        System.out.print ("Enter Name: ");
        String playername = input.nextLine ();
        this.name = playername;
        this.hand = new Hand (playername);
    }
    public String getName () {
        return name;
    }
    public Hand getHand () {
        return hand;
    }
    public Card play (Eights eights, Card prev) {
        Card card = searchForMatch (prev);
        if (card == null) {
            card = drawForMatch (eights, prev);
        }
        return card;
    }
    public Card searchForMatch (Card prev) {
        for (int i = 0; i < hand.size (); i++) {
            Card card = hand.getCard (i);
            if (cardMatches (card, prev)) {
                return hand.popCard (i); // Pops card from the hand and passes it to play.
            }
        }
        return null;
    }
    public Card drawForMatch (Eights eights, Card prev) {
        while (true) {
            Card card = eights.drawCard ();
            System.out.println (name + " draws " + card);
            if (cardMatches (card, prev)) {
                return card;
            }
            hand.addCard (card);
        }
    }
    public static boolean cardMatches (Card card1, Card card2) {
        if (card1.getSuit () == card2.getSuit ()) {
            return true;
        }
        if (card1.getRank () == card2.getRank ()) {
            return true;
        }
        if (card1.getRank () == 8) {
            return true;
        }
        return false;
    }
    public int score () {
        int sum = 0;
        for (int i = 0; i < hand.size (); i++) {
            Card card = hand.getCard (i);
            int rank = card.getRank ();
            if (rank == 8) {
                sum -= 20;
            }
            else if (rank > 10) {
                sum -= 10;
            }
            else {
                sum -= rank;
            }
        }
        return sum;
    }
    public void display () {
        hand.display ();
    }
    public void displayScore () {
        System.out.println (hand.p1name + " has " + score () + " points!");
        System.out.println (hand.p1name + " has " + score () + " points!");
    }
}