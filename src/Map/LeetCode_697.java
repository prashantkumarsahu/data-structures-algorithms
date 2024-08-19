package src.Map;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LeetCode_697 {

    public static void main(String[] args) {

        int[] nums = {1,2,2,3,1,4,2};

       // Arrays.asList(nums).stream().forEach(System.out::println);
        // This will create List<int[]> NOT List<int>

        // Arrays.stream(nums).forEach(System.out::println);
        // converts int[] to IntStream.

        Map<Integer, Integer> hmap = new HashMap<>();
        for(int n: nums){
            hmap.put(n, hmap.getOrDefault(n,0)+1);
        }
        int maxVal = hmap.values().stream().max(Comparator.naturalOrder()).get();
        int maxVal2 = hmap.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();

        //System.out.println(maxVal2);

        int maxKey = hmap.entrySet().stream().filter((item) -> item.getValue() == maxVal).findAny().get().getKey();
        //System.out.println("degree = " + maxKey + " with freq = " + maxVal);

        List<int[]> subarrays = findAllSubarrays(nums);

        for(int[] s: subarrays){
            Arrays.stream(s).forEach(System.out::print);
            System.out.println();
        }

        Map.Entry<Integer, Long> temp = findMaxFreqEntry(nums);

        for(int[] arr: subarrays){
            Map.Entry<Integer, Long> temp2 = findMaxFreqEntry(arr);
            if(temp2.getValue().equals(temp.getValue())){
                System.out.println(temp2.getKey());
            }
        }

    }

    public static List<int[]> findAllSubarrays(int [] nums){

        // find all subarray of array
        // B.F
        List<int[]> subarrays = new LinkedList<>();

        for (int start = 0; start < nums.length; start++) {

            for (int end = start; end <= nums.length; end++) {

                int[] subarray = Arrays.copyOfRange(nums,start,end);
                // start index is inclusive,
                // end index is exclusive, may lie outside array
                subarrays.add(subarray);
            }
        }

        return subarrays;
    }

    public static Map.Entry<Integer, Long> findMaxFreqEntry(int[] nums){

        Map.Entry<Integer, Long> temp = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get();

        return temp;
    }
}
