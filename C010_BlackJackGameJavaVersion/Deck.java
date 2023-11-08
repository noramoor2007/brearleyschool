import java.util.Random; // Since I imported the "random.randInt", when I use it, I won't need to say "random.randInt", and just the "randInt".
public class Deck { // This creates the class called "Deck". This is supposed to generate the deck of 52 cards.
  // Since the "Deck" class is public, I can access it from outside the class.
  private Card [] cards; // This is a field. An array of different cards in a deck. This is of type "Card".
  public Deck () { // This is a public constructor of the Deck class. You can have a class attribute outside the constructor and within the constructor you can change set its initial value to something.
    // Make space for 52 cards in an array.
    this.cards = new Card [52]; // The "this" keyword is to eliminate the confusion between class attributes and parameters with the same name (because a class attribute is shadowed by a method or constructor parameter).
    // Use an index to walk through the array
    int index = 0;
    // Use for loops or while loops to call:
    Random rand = new Random (); // Like Scanner input = new Scanner (system.in);
    // Math.random () only generates doubles.
    for (int i = 0; i < 52; i++) {
      cards [i] = new Card ((int)(Math.random () * 4), (int)(Math.random () * 13)); // The range for the former, is 0 inclusive to 3.99 inclusive. Then when you cast it as an int it cuts off the decimal and leaves you with just 3 (keep in mind the suit's maximum index is only 3).
      // This returns a new instance of that class.
      // How to cast a double to integer: double x = 2.4;
      // int y = Double.toInteger (x); // All primitive types have imported libraries that make them objects and function like objects too.
    }
  }  
  public void print () {
  // For each card object in the 52 object array, Cards, print the card object.
    for (Card card : this.cards) { // You are going through every element of this.cards, whatever is inside it, you set "card" equal to that. The "card" is of type "Card".
      System.out.println (card.toString (card.getSuit (), card.getRank ())); // This gives you the actual values instead of the memory addresses. That's why you implement toString.
    }
  }
}

