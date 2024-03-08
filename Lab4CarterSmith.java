import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;

public class Lab4CarterSmith {

    public static void main(String[] args) {
        try {
            // Initialize an array
            Rectangle2D.Double[] rectangles = {
                new Rectangle2D.Double(3, 4, 2, 2),
                new Rectangle2D.Double(1, 2, 3, 4),
                new Rectangle2D.Double(3, 4, 1, 1),
                new Rectangle2D.Double(1, 2, 2, 2)
            };

            // Create an instance of the RectangleComparator
            RectangleComparator comparator = new RectangleComparator();

            // Sort the array of rectangles using the custom comparator
            Arrays.sort(rectangles, comparator);

            // Iterate and print out the sorted rectangles
            for (Rectangle2D.Double rect : rectangles) {
                System.out.println("Rectangle(x=" + rect.getX() + ", y=" + rect.getY() + 
                                   ", width=" + rect.getWidth() + ", height=" + rect.getHeight() + ")");
            }
        } catch (NullPointerException e) {
            // Handle the case where one of the rectangles is null
            System.out.println("Caught NullPointerException: One of the rectangles is null.");
        } catch (Exception e) {
            // Handle any other exceptions that might occur
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    // Inner class to compare Rectangle2D.Double objects
    static class RectangleComparator implements Comparator<Rectangle2D.Double> {
        @Override
        public int compare(Rectangle2D.Double r1, Rectangle2D.Double r2) {
            // Implement the comparison logic here
            // Compare by x-coordinate, then y-coordinate, then width, and finally height
            if (r1.getX() != r2.getX()) {
                return Double.compare(r1.getX(), r2.getX());
            }
            if (r1.getY() != r2.getY()) {
                return Double.compare(r1.getY(), r2.getY());
            }
            if (r1.getWidth() != r2.getWidth()) {
                return Double.compare(r1.getWidth(), r2.getWidth());
            }
            return Double.compare(r1.getHeight(), r2.getHeight());
        }
    }
}
