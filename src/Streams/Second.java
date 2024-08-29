package src.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second {

    public static void main(String[] args) {

        List<Integer> res = new ArrayList<>(Arrays.asList(3,4,5,6));

        res.parallelStream().forEachOrdered(System.out::println);

        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();

       // Arrays.stream(arr2).forEach(System.out::println);

        int totalSum = res.stream().mapToInt(Integer::intValue).sum();//
    }
}
