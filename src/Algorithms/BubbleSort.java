package Algorithms;

public class BubbleSort {

  public static void main(String[] args) {

    int[] arr = new int[]{5,4,3,2,1};
    // TC = O(n^2)
    // SC = O(1)
    bubblesort(arr, 5);
    printArr(arr,5);
  }

  public static void bubblesort(int[] arr, int n){
    int temp;

    for(int i=0;i<n-1;i++){
      // outer loop is just to track iterations, not pick elements
      // inner loop picks adjacent elements to compare
      // starts from index 0 in all iterations
      // reduce the length of sub-array to compare by 1 each time;
      for(int j=0;j<n-i-1;j++){
        // compares adjacent elements; if found out of order then swap
        if(arr[j] > arr[j+1]){
          // swap
          temp = arr[j+1];
          arr[j+1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  public static void printArr(int[] arr, int n){
    for(int i=0;i<n;i++){
      System.out.print(arr[i] + " ");
    }
  }
}
