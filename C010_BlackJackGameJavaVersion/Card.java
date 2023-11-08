public class Card { // This creates a class called "Card".
  private int rank; // These are the fields.
  private int suit;
  // The cards are represented by the pairs of number assigned to the rank and suit of each card.
  // For example, rank = 11, suit = 2 could be "Jack of Hearts".
  // Obviously we also want to have easy to read displayed names for each card.
  // These "public static final" String arrays store the display names.
  public static final String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; // This is kind of like a constant.
  public static final String [] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"}; // You have a string array for the ranks associated with each card. This is a variable of the class Card.
  // The constructor goes here.
  // A constructor in Java is a special method that is used to initialize objects.
  // The constructor is called when an object of a class is created. It can be used to set initial values for object attributes.
  public Card (int suit, int rank) { // This creates a class constructor for the "Card" class.
    // This is how you call a constructor: Card myObj = new Card (5);
    // And then you print it like so: System.out.println (myObj.x), with "x" being the variable, whose value is set to something else when the constructor is called.
    // Behaviors are the methods that the class has.
    // Card A = new Card (suit, rank); // This creates a new instance of the Card class. The "Card ()" is calling the Card constructor. This allows you to construct an instance of a class.
    this.suit = suit; // This assigns the suit variable in the "Card" class to the suit variable in the "Card" constructor's parameter.
    this.rank = rank; // Same thing applies here, just for the rank.
  }
  public String toString (int suit, int rank) {
    String cardName = ranks [rank] + " of " + suits [suit];
    System.out.println (cardName);
    return cardName;
  }
  public boolean equals (Card that) {
    if (this.suit == that.suit && this.rank == that.rank) {
      return true;
    }
    else {
      return false;
    }
  }
  public int compareTo (Card that) { // Not static because it is not connected to multiple instances of the Card class. Also, you can't use a static variable inside of a non-static variable.
    if (this.suit > that.suit) {
      System.out.println (this.suit + " is greater than " + that.suit);
      return 1;
    }
    else if (this.suit < that.suit) {
      System.out.println (this.suit + " is less than " + that.suit); // When something is not static it is connected to only one instance of the class.
      return -1;
    }
    else {
      if (this.rank > that.rank) {
        return 1;
      }
      else if (this.rank < that.rank) {
        return -1;
      }
      else {
        System.out.println (this.suit + " is equal to " + that.suit);
        return 0;
      }
    }
  }
  // The constructor should take "suit" and "rank" as integer parameters.
  // Then they should be assigned to object attributes with the same name using the keywords "this" and "that".
  // The "toString ()" method should return strings like "Queen of Hearts" or "Ace of Diamonds".
  // The "equal ()" method takes the other as a parameter, the "other" being the Card object.
  // It should return a boolean that is true, if and only if both the suit and rank of the cards match.
  // The "compareTo" method checks if they are greater or less than the other. It should return an integer.
  // It will return -1 if this is greater than that.
  // It should return 0 if they are the same.
  // It should return 1 if that is greater than this.
  // It compares the cards first by suit, and then by their rank.
  // There are stuff called getters and setters.
  // In Java, there is something called _encapsulation_, which makes sure that "sensitive" data is hidden from users.
  // You need to declare class variables/attributes as private, and provide public get and set methods to access and update the value of a private variable.
  // It is possible to access private variables if we provide public get and set methods.
  // The "get" method returns the variable value, and the "set" method sets the value.
  // Syntax for both is that they start with either get or set, followed by the name of the variable, with the first letter in upper case, for example "getName" and "setName".
  public int getRank () {
    return this.rank;
  }
  public int getSuit () { // Getters only read, while setters only write.
    return this.suit; // The "this" is only for setters.
    // Why is there no "this" keyword in getter methods?
    // Because usually the given parameter name is the same as the class variable, so the "this" is used to identify which of them actually belong to the class and which one was passed to the method.
    // If no other value has the same name then it will identify the class variable, so there is no need for it.
  }
  // The set method takes a parameter (newName) and assigns it to the private variable.
  // The "this" keyword is used to refer to the current object.
  // However, as the name variable is declared as private, we cannot access it from outside this class.
}