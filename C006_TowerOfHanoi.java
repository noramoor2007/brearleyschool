import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;
// You have to import java.util.Collections;
// It can be used to sort ArrayLists.
public class Main {
  public static void main (String [] args) {
    ArrayList <String> play_list = new ArrayList <String> ();
    Scanner input = new Scanner (System.in);
    System.out.print ("Enter number of discs: ");
    int discNumber = input.nextInt ();
    ArrayList <Character> arraylist = new ArrayList <Character> ();
    char letter1 = 'A';
    for (int i = 0; i < discNumber; i++) {
      arraylist.add (letter1);
      letter1++;
    }
    ArrayList <ArrayList <Character>> newarraylist = new ArrayList <ArrayList <Character>> ();
    newarraylist.add (arraylist);
    newarraylist.add (new ArrayList <Character> ()); // You are not assigning it to a new array list, you are just using it as a parameter for the move function.
    newarraylist.add (new ArrayList <Character> ());
    // Scanner class...
    // move (0, 2, discNumber, newarraylist);
    // Make an integer ArrayList called "scores" and add some scores to it.
    // Note that "<int>" won't work, and you have to do "<Integer>" instead.
    ArrayList <ArrayList <Character>> pegs = new ArrayList <ArrayList <Character>> (); // Array lists are arrays that can be added to. You can add things to an array list that changes its size, like lists.
    int n = discNumber;
    ArrayList <Character> A = new ArrayList <Character> ();
    pegs.add (A); // The ".add ()" method appends things at the end.
    // If you ran ".remove (A)" it would remove the thing at the index.
    ArrayList <Character> B = new ArrayList <Character> ();
    pegs.add (B);
    ArrayList <Character> C = new ArrayList <Character> ();
    pegs.add (C);
    char letter = 'A';
    int i = 0;
    while (i < n) {
      A.add (letter);
      letter++;
      i++;
    }
    System.out.println ("Starting Array: " + pegs);
    move (0, 2, discNumber, newarraylist);
    // move (int fromPeg, int toPeg, int m)
    // This move m top discs from the "fromPeg" to the "toPeg".
    // Each item in "pegs" is an integer array "ArrayList <Integer>"
    // Lets make a list for three pegs: 'A', 'B', 'C'.
    // return (pow (2, discs)) - 1;
  }
  public static void move (int fromPeg, int toPeg, int m, ArrayList <ArrayList <Character>> pegs) {
    // "m" is how many discs to move.
    // Base case is "m [0]". We will move it if "m" is greater than 0.
    int otherPeg = 0;
    switch (fromPeg + toPeg) { // Switch is like an if-statement, not a loop.
      case 1: // Because you are adding two integers the value after "case" has to be an integer.
        otherPeg = 2;
        break; // Used so that it does not go to case 2 and the next cases.
      case 2: // When the indicie values are added together you get 2, so it has to be 2 + 0.
        otherPeg = 1; // The one left out.
        break;
      default:
        otherPeg = 0;
    }
    if (m > 0) {
      // Move top m - 1 discs from "fromPeg" to the "otherPeg".
      move (fromPeg, otherPeg, m - 1, pegs);
      // Move the bottom disc from the "fromPeg" to the "toPeg".
      pegs.get (toPeg).add (0, pegs.get (fromPeg).get (0)); // This moves the big disk.
      pegs.get (fromPeg).remove (0);
      System.out.println (pegs);
      move (otherPeg, toPeg, m - 1, pegs); // The pegs passes the array list along the line.
    }
  }
}