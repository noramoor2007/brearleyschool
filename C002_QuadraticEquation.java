import java.util.Scanner;  // Import the Scanner class.
import java.io.*;
class Main {
// Does the scanner class only work in the main method?
  public static void main (String [] args) {
    System.out.println ("\n█▀█ █ █ ▄▀█ █▀▄ █▀█ ▄▀█ ▀█▀ █ █▀▀   █▀▀ █▀█ █▀█ █▀▄▀█ █ █ █   ▄▀█\n▀▀█ █▄█ █▀█ █▄▀ █▀▄ █▀█  █  █ █▄▄   █▀  █▄█ █▀▄ █ ▀ █ █▄█ █▄▄ █▀█\n");
    System.out.println ("Use this quadratic formula generator to generate the solutions of\nany quadratic formula.");
    System.out.println ("\n     -b ± √b² - 4(ac)\nx = ------------------\n            2a\n\nSome things to keep in mind is that when the discriminant is equal\nto 0, there is exactly one real root.\nWhen the discriminant is less than zero, there are no real roots,\nbut there are exactly two distinct imaginary roots.\nWhen the discriminant is greater than 0, there are two distinct real\nroots.\n");
    int a;
    Scanner input = new Scanner (System.in); // This creates the scanner object. Always put it at the very beginning.
    System.out.print ("Please input a value for a: ");
    a = input.nextInt (); // This reads the next integer from the screen.
    int b;
    System.out.print ("Please input a value for b: ");
    b = input.nextInt ();
    int c;
    System.out.print ("Please input a value for c: ");
    c = input.nextInt ();
    discriminant (a, b, c);
  }
  public static void discriminant (int a, int b, int c) {
    double discriminant = Math.sqrt(b*b - 4*(a*c));
    System.out.print ("\n√b² - 4(ac) = " + discriminant);
    System.out.println ("\nGreat! You've just calculated the discriminant!");
    if (discriminant >= 0 && a != 0) {
      System.out.println ("\nThere are two distinct real roots.");
      coordinates (a, b, discriminant);
    }
    else if (discriminant < 0 && a != 0) {
      System.out.println ("\nThere are no real roots.");
      coordinates (a, b, discriminant);
    }
  }
  public static void coordinates (int a, int b, double discriminant) {
    double positive = (-1*b + discriminant)/(2*a);
    double negative = (-1*b - discriminant)/(2*a);
    System.out.println ("Roots: (" + positive + ", " + negative + ")");
  }
}