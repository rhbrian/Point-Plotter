import java.io.IOException;
import java.io.*;
import java.util.ArrayList;

public class Fast {
    public static Point[] points;
    public Fast(int n) {
        points = new Point[n];
    }

    public static void sort(Point[] print) { // insertion sort for the vector to be outputted for lexographic order
        int k = 0;
        int j = 0;
        for (k = 1; k < print.length; k++) {
            Point temp = print[k];
            j = k;
            while (j > 0 && print[j-1].compareTo(temp) == 0) {
                print[j] = print[j-1];
                j--;
            }
            print[j] = temp;
        }
    }

    public static boolean recorded (ArrayList<ArrayList<Point>> v , ArrayList<Point> a) {
        for (int x = 0; x < v.size(); x++) {
            if (v.get(x).containsAll(a)) return true;
        }
        return false;
    }
	
 	public static void printArr(Point[] print) {
        System.out.printf("%d:",print.length);
        for (int x = 0; x < print.length; x++) {
            System.out.printf("("+print[x].getX()+", "+print[x].getY()+") ");
            if (x != print.length - 1) {
                System.out.printf("-> ");
            }
        }
    }

 
    public static void main (String args[]) throws IOException{
        int pnum = Integer.parseInt(StdIn.readLine());
        File file = new File("visualPoints.txt");
        FileOutputStream filestream = new FileOutputStream(file);
        PrintStream fps = new PrintStream(filestream);
     	PrintStream ps = new PrintStream(System.out);
        Fast f = new Fast(pnum);
        int counter = 0;
        while (!StdIn.isEmpty()) {
            f.points[counter++] = new Point(StdIn.readInt() , StdIn.readInt());
        }

        ArrayList<Point> v = new ArrayList<>(5); // ArrayList of collinear points
        ArrayList<ArrayList<Point>> map = new ArrayList<ArrayList<Point>>(5); // Arraylist of point arrays (all the lines recorded)
     	
        int whole = 0;
        //Stopwatch watch = new Stopwatch();
        while (whole < pnum) { // changing overall p value
            int howm; // how many points added to vector
            int i = whole + 1; // set i to whole + 1 so that we start with the next point
            while (i < pnum) { // changing the 1st point to compare
                v.clear(); // clear the vector for any previous set values
                int c = i + 1; // set c to i + 1 which is the next point after i
             	howm = 0;
                while (c < pnum) { // changing the 2nd point to compare
                    if (points[whole].BY_SLOPE_ORDER.compare(points[i], points[c]) == 0) {
                        v.add(points[c]);
                     	howm++;
                    }
                    c++;
                }
                if (v.isEmpty() || howm <= 1) {
                    i++;
                    continue;
                }
                v.trimToSize();
                v.add(points[i]); // add the second element
                v.add(points[whole]); // add the first element
                if (!recorded(map , v)) {
                    v.trimToSize(); // trim to avoid non-existing values
                    map.add((ArrayList<Point>)v.clone()); // add the new set to the map of all collinear points
                    Point[] print = (Point[])v.toArray(new Point[v.size()]); // cast vector to printing array
                    sort(print); // insert sort the ArrayList
                    System.setOut(fps); // file stream
                    printArr(print); // print the ArrayList data to file
                    System.out.printf("\n");
                 	System.setOut(ps);
                 	printArr(print); // print the ArrayList data to file
                    System.out.printf("\n");
                }
             	i++;
            }
            whole++;
        }
        //System.out.println(watch.elapsedTime());
    }
}
