import java.util.Scanner;
public class Hand extends CardCollection { // The Hand is an extension of the "CardCollection".
    public String p1name;
    public String p2name;
    Scanner input = new Scanner (System.in);
    public Hand (String label) {
        super (label); // Extends the label. Inherited from "CardCollection".
    }
    public void welcome () {
        System.out.println ("\nWelcome to the Crazy Eights Game!");
    }
    public void display () {
        System.out.print (getLabel () + ": \n");
        for (int i = 0; i < size (); i++) {
            System.out.println (getCard (i));
        }
        System.out.println ();
    }
}