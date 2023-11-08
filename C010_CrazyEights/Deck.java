public class Deck extends CardCollection { // The deck is an extension of the "CardCollection".
    public Deck (String label) {
        super (label); // This is what we use when we are extending a class.
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                addCard (new Card (rank, suit));
            }
        }
    }
}
