package src.ArraysClass;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ArraysMethods {

    public static void main(String[] args) {
//        int arr[][] = {{1,2,3}, {4,5,6}};
//        int a[] = {2,7,9};
//        int b[] = {1,2,7};



 //       System.out.println(Arrays.binarySearch(a,0,3,9));
 //         System.out.println(Arrays.compare(a,b));
//        System.out.println(Arrays.compareUnsigned(a,b));
//        System.out.println(Arrays.copyOf(a,2));
//        System.out.println(Arrays.copyOfRange(a,0,1)); // to create subarray of array a from index 0 to 1
//
//        System.out.println(Arrays.deepEquals());

//        System.out.println(Arrays.deepHashCode(a));
//        System.out.println(Arrays.deepToString(a));
//        System.out.println(Arrays.equals(a,b));
//        System.out.println(Arrays.hashCode(a)); // produces same result even if elements are in different order, but freq should be same
//        System.out.println(Arrays.mismatch(a,b));
//        System.out.println(Arrays.spliterator(a));
//        System.out.println(Arrays.stream());
//        System.out.println(Arrays.toString(a));

//
        Integer[] arr = new Integer[]{3,1,4,2};
//        Arrays.sort(arr); // 1234 - Default = Increasing order
        Arrays.sort(arr, Collections.reverseOrder()); // Since this arr is of Wrapper class objects, we can use Collections.reverseOrder directly
        Arrays.stream(arr).forEach(System.out::print);

        int[] arr2 = new int[]{3,1,4,2};
        Arrays.sort(arr2);

        Integer[] arr2_Temp = Arrays.stream(arr2).boxed().toArray(Integer[]::new); // need to convert int[] into Integer[]

        Arrays.sort(arr2_Temp, Comparator.reverseOrder());
        Arrays.stream(arr2_Temp).forEach(System.out::print);
       // Arrays.parallelSort(arr,0,3);


//        System.out.println(Arrays.parallelPrefix(a, BinaryOperator.maxBy()));
//        Arrays.fill(a,-1);
//        Arrays.parallelSetAll(a, IntUnaryOperator.identity());
//        Arrays.parallelSort(a,0,3);
//        Arrays.setAll(a,IntUnaryOperator.identity());
//        System.out.println(Arrays.sort(a,0,2,));

//         System.out.print(Arrays.toString(a));
         // Arrays.stream(a).forEach(item -> System.out.print(item));
    }
}
