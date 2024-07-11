package Greedy;

import java.util.Arrays;

class Job implements Comparable<Job>{

    int deadline;
    int profit;
    char jobid;

    public Job(char id, int d, int p) {
        this.deadline = d;
        this.profit = p;
        this.jobid = id;
    }

    // Greedy approach always would maximize the profit.
    // sort in decreasing order of profit i.e. highest profit job first
    @Override
    public int compareTo(Job o) {
        return o.profit - this.profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Job[] jobs = {new Job('a', 2,100), new Job('b',1,19), new Job('c', 2,27),
                new Job('d', 1,25), new Job('e',3,15)};

        Arrays.sort(jobs); // sort in decreasing order of profit

        int len = jobs.length; // also number of slots
        char[] jobSequence = new char[len]; // store the final job sequence
        boolean[] occupied = new boolean[len]; // check availability of slot

        // take each job one by one from the left and find the appropriate slot for it
        // TC = O(N^2)
        // SC = O(N)
        for (int i=0;i<len;i++){
            // System.out.println(jobs[i].jobid + " " + jobs[i].deadline + " " + jobs[i].profit);

            // start from the end index, compare it with the job's deadline and take their min;
            // subtract 1 for 0-based indexing
            // look for a slot until we meet the first slot
            for(int j= Math.min(len-1, jobs[i].deadline-1); j>=0;j--){
                if(!occupied[j]){
                    // free slot found at index j
                    occupied[j] = true; // mark it occupied
                    jobSequence[j] = jobs[i].jobid; // jth slot is filled by job i
                    break;
                }
            }
        }

        for(int i=0;i<len;i++){
            if(occupied[i]){ // if the slot is occupied, then print the job allocated to the slot.
                System.out.print(jobSequence[i]);
            }
        }
    }
}
