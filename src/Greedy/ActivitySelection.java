package Greedy;

import java.util.Arrays;
import java.util.Comparator;

class Activity {
        //implements Comparable<Activity>{
    int startTime;
    int endTime;

    Activity(int s, int e){
        startTime = s;
        endTime = e;
    }

//    @Override
//    public int compareTo(Activity o) {
//        return this.endTime - o .endTime;
//    }
}

class FinishTimeCompare implements Comparator<Activity>{

    @Override
    public int compare(Activity o1, Activity o2) {
        if(o1.endTime > o2.endTime){
            return 1;
        }else if(o1.endTime < o2.endTime){
            return -1;
        }else {
            return 0;
        }
    }
}


public class ActivitySelection {

    public static void main(String[] args) {

        Activity[] activities = {new Activity(2,3), new Activity(6,10), new Activity(1,4), new Activity(5,8)};
        FinishTimeCompare finishTimeCompare = new FinishTimeCompare();
        Arrays.sort(activities, finishTimeCompare);

        int len = activities.length;
        for(int i=0;i<len;i++){
            System.out.println(activities[i].startTime + " " + activities[i].endTime);
        }
        int maxActivities = 1;
        Activity prev = activities[0];

        for(int i=1;i<len;i++){
            if(activities[i].startTime >= prev.endTime){
                maxActivities++; // if activity i start time is more than prev activity end time, then it can be performed next in sequence.
                prev = activities[i]; // activity i becomes the new prev activity
            }
        }
        System.out.println(maxActivities);
    }


}
