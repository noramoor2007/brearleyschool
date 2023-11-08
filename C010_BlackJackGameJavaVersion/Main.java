class Main {
  // int x = 0;
  // Counter a = new Counter;
  // Counter b = new Counter;
  // a.x++;
  // b.x++;
  public static void main(String[] args) {
    // Once you have compleated the classes this will create a new deck of 52 cards then, print a list of the cards in order like:
    /*
    Ace of Clubs
    2 of Clubs
    3 of Clubs
    */
    Deck deck = new Deck(); // Stuff inside "Deck" are not static.
    // Ranks and suits in "Card" is static.
    // deck.print(); // Because the print () function is not static you must create an instance of the Deck class.
    // for (String arrayvalues : Card.ranks) {// Both card.ranks and card.suits are static arrays.
    tester ();
  }
  public static void tester () {
    Card cards = new Card (1, 4);
    Card cards1 = new Card (3, 11);
    cards.toString (1, 4);
    cards1.toString (2, 11);
  }
}
// When you convert from double to an int it is lossy.
// You lose info by doing that conversion.
// You need to cast the double generated from Math.random as a integer.