package src.ArraysClass;

import java.util.Arrays;

public class ArraysMethods {

    public static void main(String[] args) {
        int arr[][] = {{1,2,3}, {4,5,6}};
        int a[] = {9,2,7};
        int b[] = {1,2,7};

        Arrays.parallelSort(a,0,3);

        System.out.println(Arrays.binarySearch(a,0,3,9));
          System.out.println(Arrays.compare(a,b));
//        System.out.println(Arrays.compareUnsigned(a,b));
//        System.out.println(Arrays.copyOf(a,2));
//        System.out.println(Arrays.copyOfRange(a,0,1)); // to create subarray of array a from index 0 to 1
//
//        System.out.println(Arrays.deepEquals());
//
//        System.out.println(Arrays.deepHashCode(a));
//        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.equals(a,b));
//        System.out.println(Arrays.hashCode(a));
        System.out.println(Arrays.mismatch(a,b));
//        System.out.println(Arrays.spliterator(a));
//        System.out.println(Arrays.stream());
//        System.out.println(Arrays.toString(a));
//        Arrays.sort(a,0,3);
//        System.out.println(Arrays.parallelPrefix(a, BinaryOperator.maxBy()));
//        Arrays.fill(a,-1);
//        Arrays.parallelSetAll(a, IntUnaryOperator.identity());
        Arrays.parallelSort(a,0,3);
//        Arrays.setAll(a,IntUnaryOperator.identity());
//        System.out.println(Arrays.sort(a,0,2,));

         System.out.print(Arrays.toString(a));
         // Arrays.stream(a).forEach(item -> System.out.print(item));
    }
}
