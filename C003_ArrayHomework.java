// The following method takes an array and two integers. It returns the number of elements that fall in the range from low to high - 1:
import java.util.Random;
import java.util.Scanner;
class Main {
    // Exercise #1
    public static int search (double [] array, double target) { // What you are trying to search for in the array is the "target". Behavior are all the functions of a class.
        for (int i = 0; i < array.length; i++) {
            if (array [i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Exercise #2
    public static double sum (double [] a) {
        double total = 0; // Total has the scope of the entire method, thus you can change the value of it inside the for-loop.
        for (int i = 0; i < a.length; i++) { // Scope of "i" lies only within the for-loop.
            total += a [i];
        }
        return total;
    }
    // Exercise #3
    public static int [] randomArray (int n) {
        int [] randoms = new int [n]; // If you initialize an array like this, then it will create an array of 0's with a length of "n".
        Random random = new Random ();
        for (int i = 0; i <= n; i++) {
            randoms [i] = random.nextInt (99); // Generates a random integer in a range.
        }
        return randoms;
    }
    // Exercise #4
    public static int inRange (int [] a, int low, int high) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a [i] >= low && a [i] < high) {
                count++;
            }
        }
        return count;
    }
    // For any integer array, find the largest and smallest item and print the frequency of each integer in the range from smallest to largest.
    public static int [] intFreq (int [] a) {
        int largest = max (a); // 5.4
        int smallest = min (a); // 0.8
        int [] ab = new int [a.length];
        for (int i = 0; i < a.length; i++) {
            int count = 0; // You have to initialize count inside this for-loop because you have to refresh the number of instances each integer appears in the array and reset to 0.
            ab [i] = count;
            if (a [i] > smallest && a [i] < largest) {
                for (int j = 0; j < a.length; j++) {
                    if (a [i] == a [j]) {
                        count++;
                        ab [i] += count;
                    }
                }
            }
        }
        return ab;
    }
    // Methods that are nice to have around when working with arrays.
    public static void printArray (int [] a) {
        System.out.print ("{" + a [0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print (", " + a [i]);
        }
        System.out.println ("}");
    }
    public static int max (int [] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if (max < a [i]) {
                max = a [i];
            }
        }
        return max;
    }
    public static int min (int [] a) {
        int min = a [0];
        for (int i = 1; i < a.length; i++) {
            if (min > a [i]) {
                min = a [i];
            }
        }
        return min;
    }
    public static void main (String [] args) { // In a class the main method is always executed first.
        // double [] a = new double [5]; // Is initializing an array of doubles. The "new" creates a new object, and the double is the object/array with the length of 5. Used to store values of the array.
        // Scanner input = new Scanner ();
        // for (int i = 0; i < 5; i++) {
        //   System.out.println ("Enter one array double element: ");
        //   Double doublevalue = input.nextDouble();
        //   a [i] = doublevalue; // The doublevalue is the value from the user that gets stored into each index of the array, "a". You would have to do "i - 1" in the brackets if the value of i started off as 1.
        double [] array = {3.14, -55.0, 1.23, -0.8};
        int index = search (array, 1.23); // You are setting the index value equal to the return value of "search". It sets the index to the value of 2 in the method and comes back to the main function where it is printed.
        System.out.println (index); // This prints 2.
        double [] a = {1.0, 2.3, 2.3, 0.8, 5.4}; // The variable in the main method have a different scope than the variables in a different function. The scope of a variable is where it can be used. Anything outside the enclosing curly braces of the main method do not collide. I put 2.3 instead of 3.8 just as a test.
        System.out.println (search (a, 4.8)); // This prints 3.
        System.out.println (sum (array)); // Tests for the sum.
        System.out.println (sum (a));
        // This is using randomArray to print 8 random numbers.
        int [] b = randomArray (30);
        printArray (b);
        System.out.println ("A: " + inRange (b,90,100));
        System.out.println ("B: " + inRange (b,80,89));
        System.out.println ("C: " + inRange (b,70,79));
        System.out.println ("D: " + inRange (b,60,69));
        System.out.println ("F: " + inRange (b,0,59));
        System.out.println (max (b));
        System.out.println (min (b));
    }
}