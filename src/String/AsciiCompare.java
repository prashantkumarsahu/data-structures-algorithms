package String;

import java.util.PriorityQueue;

public class AsciiCompare {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};

        PriorityQueue<String> pq = new PriorityQueue<String>((s1, s2) -> s2.compareTo(s1));
        // (s2+s1).compareTo(s1+s2)
        for(int i: nums){
            pq.add(Integer.toString(i)); // add each integer as string
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
}
