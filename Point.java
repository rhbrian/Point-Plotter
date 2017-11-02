/*************************************************************************
 * Compilation:  javac Point.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point>{
    // compare points by slope
    public final Comparator<Point> BY_SLOPE_ORDER  = new Comparator<Point>() {
        @Override
        public int compare(Point a, Point b) {
            if (a.x == getX() && a.x == b.x) return 0;
            if (a.y == getY() && a.y == b.y) return 0;
            if (a.x == getX() && b.x > a.x) {
                return 1;
            }
            else if (b.x == getX() && a.x > b.x) {
                return -1;
            }
            double slope1 = ((double)a.y - (double)getY())/((double)a.x - (double)getX());
            double slope2 = ((double)b.y - (double)getY())/((double)b.x - (double)getX());
            if (slope1 > slope2) return 1;
            if (slope1 == slope2) return 0;
            //if (slope1 < slope2) return -1;
            return -1;
        }
    };
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // constructor
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
                                 
 	public int getX(){return this.x;}
 	public int getY(){return this.y;}

    // are the 3 points p, q, and r collinear?
    public static boolean areCollinear(Point p, Point q, Point r) {
        /* YOUR CODE HERE */
        if (p.BY_SLOPE_ORDER.compare(q,r) == 0)  return true;
        return false;
    }

    // are the 4 points p, q, r, and s collinear?
    public static boolean areCollinear(Point p, Point q, Point r, Point s) {
        /* YOUR CODE HERE */
        if (areCollinear(p,q,r) && q.BY_SLOPE_ORDER.compare(r,s) == 0 && r.BY_SLOPE_ORDER.compare(p,s) == 0) return true;
        return false;
    }

    // is this point lexicographically smaller than that one?
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        if (this.x < that.x) return 1;
        else if ((this.x == that.x) && (this.y < that.y)) return 1;
        else return 0;
    }

}
