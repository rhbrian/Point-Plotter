import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

// Brian Rhee 2/9/17 Project 2 Brute.java
public class Brute {
    public static Point[] points;
    public Brute(int n){
        points = new Point[n];
    }
    public static void main (String args[]) throws IOException{
        int pnum = Integer.parseInt(StdIn.readLine());
        File file = new File("visualPoints.txt");
        FileOutputStream filestream = new FileOutputStream(file);
        PrintStream fps = new PrintStream(filestream);
        PrintStream ps = new PrintStream(System.out);
        Brute b = new Brute(pnum);
        int counter = 0;
        while (!StdIn.isEmpty()) {
            b.points[counter++] = new Point(StdIn.readInt() , StdIn.readInt());
        }
        for (int x = 0; x < pnum; x++) {
            int min = x;
            for (int y = x ; y < pnum; y++) {
                if (points[min].compareTo(points[y]) == 0) min = y;
            }
            Point temp = points[x];
            points[x] = points[min];
            points[min] = temp;
        }

        int move1 = 0;
        int move2 = 0;
        int move3 = 0;
        int move4 = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        //Stopwatch watch = new Stopwatch();
        while (move1 < pnum) {
            move2 = move1 + 1;
            while (move2 < pnum){
                move3 = move2 + 1;
                while (move3 < pnum) {
                    move4 = move3 + 1;
                    while (move4 < pnum) {
                        if (points[move1].areCollinear(points[move1],points[move2],points[move3],points[move4])) {
                            System.setOut(fps);
                            System.out.printf("4:(%d, %d) -> (%d, %d) -> (%d, %d) -> (%d, %d)\n", points[move1].getX(), points[move1].getY(), points[move2].getX(), points[move2].getY(), points[move3].getX(), points[move3].getY(), points[move4].getX(), points[move4].getY());
                        }
                        move4++;
                    }
                    move3++;
                }
                move2++;
            }
            move1++;
        }
        //System.setOut(ps);
        //System.out.println(watch.elapsedTime());
    }
}
