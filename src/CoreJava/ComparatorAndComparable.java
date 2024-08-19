package CoreJava;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

@Data
class Point implements Comparable<Point>{

    public static Comparator<Point> MyComparator2 = Comparator.comparing(Point::getX);
    int x;
    int y;

    // when 2 objects are naturally comparable
    Point(int a,int b){
        this.x = a;
        this.y = b;
    }

    @Override
    public int compareTo(Point obj) {
        return this.x - obj.x;
    }
}

class MyComparator implements Comparator<Point> {

    // when 2 objects are NOT naturally comparable
    @Override
    public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
    }
}

public class ComparatorAndComparable {

    public static void main(String[] args) {
        String[] s1 = {"GFG", "JKL"};
        String[] s2 = {"gfg", "jkl"};

        Point[] p1 = {new Point(4,2), new Point(2,3)};
        Point[] p2 = {new Point(2,2), new Point(2,3)};

        Arrays.sort(p1, Point.MyComparator2);
        Arrays.stream(p1).forEach(a -> System.out.print(a.x));

       // System.out.println(Arrays.equals(p1,p2, new MyComparator()));

       // Comparable<String> c = (ss1, ss2) -> ss1.compareTo(ss2);

    }

}
