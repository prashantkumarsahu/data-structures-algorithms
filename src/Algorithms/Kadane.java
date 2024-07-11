package Algorithms;

public class Kadane {

  static int maxSubArrSum = 0;
  public static void main(String[] args) {

    // In an array, Find the contiguous subarray with max sum
    int[] arr = new int[]{1,2,3,-4,1};
        // {-1,-2,-3,-4,-5};

    kadane(arr, arr.length);


    System.out.println(maxSubArrSum);
  }

  public static void kadane(int[] arr, int n){
    // TC= O(N)
    // SC = O(1)
    int currSum = 0;
    maxSubArrSum = Integer.MIN_VALUE;

    for(int i=0;i<n;i++){
      currSum += arr[i];
      if(currSum>maxSubArrSum){
        maxSubArrSum = currSum;
      }
      if(currSum < 0){
        currSum = 0;
      }
    }

  }
}


