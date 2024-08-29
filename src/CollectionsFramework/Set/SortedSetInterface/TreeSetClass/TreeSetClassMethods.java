package src.CollectionsFramework.Set.SortedSetInterface.TreeSetClass;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class TreeSetClassMethods {
    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>();
        set.add(6);
        set.add(26);
        set.add(2);

        System.out.println(set.first()); // least num
        System.out.println(set.last()); // highest num

        List<Integer> list = new ArrayList<>(set);
        System.out.println(list.indexOf(6));
        //System.out.println(set.pollLast());
    }
}
