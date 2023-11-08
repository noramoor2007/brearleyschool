import java.awt.geom.Rectangle2D;
public class Main { // This class defines rectangles.
    public static void main (String [] args) {
        // Using an existing swing/awt class to make a rectangle object.
        Rectangle2D shape = new Rectangle2D.Float ();
        shape.setFrame (100, 300, 50, 300); // This is setFrame (x, y, width, height). The x and y are the upper left coordinates.
        System.out.println (shape.contains (800, 0));
        // StdDraw Examples
        StdDraw.setTitle ("Example Drawing"); // You can change the name of the window.
        StdDraw.setCanvasSize (500, 500);
        StdDraw.setXscale (0, 500);
        StdDraw.setYscale (0, 500);
        StdDraw.save ("blank.png");
        StdDraw.setPenRadius (.005);
        StdDraw.setPenColor (StdDraw.BLUE);
        StdDraw.rectangle (125, 92.6, 25, 107);
        // StdDraw.point(512, 100);
        // StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line (0, 0, 800, 100);
        StdDraw.save ("testDraw.png");
        // Suppose we want to modify StdDraw so that we can draw the rectangle object, something like, "StdDraw.rectangleObject (shape);"
        // We want the co-ordinates of the rectangle to match those used by StdDraw.
        // Modify "StdDraw" so that the rectangle object uses the same coordinates. 
        StdDraw.setPenColor (StdDraw.MAGENTA);
        StdDraw.rectangleObject (shape);
    }
}