/*
Write a method that calculates the factorial recursively. Next, write a method called "myexp" that takes "x" and "i" as parameters and estimates "e^x" by adding the first "i" terms of this famous and lovely series: ex=i=0xii!=1+x+x22!+x33!+x44!...
*/
import java.lang.*;
import java.util.Scanner;
class Main {
  public static void main (String [] args) {
    Scanner input = new Scanner (System.in);
    System.out.print ("Enter a value for the base of the exponent: ");
    Double valofx = input.nextDouble ();
    System.out.print ("Enter the number of terms you want: ");
    Double valofi = input.nextDouble ();
    valofi -= 1; // You must do this so that the first thing you add is when the base is raised to the 0 over the factorial of 0. 5 is supposed to be the number of things you add, the length, not the value of "i" since "i" include 0.
    System.out.println (myexp (valofx, valofi, 1, 0, 0, 0));
  }
  public static double factorial (double i) {
    if (i == 0) {
      return 1;
    }
    return i * factorial (i - 1);
  }
  public static double myexp (double x, double i, double result, double numerator, double denominator, double fraction) { // "x" is the base of the exponent and "i" is the exponent as well as the number you are taking the factorial of.
    if (i == 0) { // This is the base case, and "i" is the number of terms that are to be added to each other. This is when the numerator is 1. Should it be i < 0 or i == 0?
      return result;
    }
    // To find the factorial you take the value of "i" and you keep multiplying it by "i - 1" everytime it loops through the function.
    numerator = Math.pow (x, i);
    denominator = factorial (i);
    fraction = numerator/denominator;
    result += fraction;
    return myexp (x, i - 1, result, numerator, denominator, fraction);
  }
}