
import java.util.*;

public class Set{

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(26);
        set.add(2);

        System.out.println(set.pollLast());
    }
}