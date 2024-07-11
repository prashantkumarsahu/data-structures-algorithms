package Algorithms;

public class InsertionSort {

  public static void main(String[] args) {

    int[] arr = new int[]{8,9,11,12,3};
    int n = arr.length;

    insertionSort(arr);
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i] + " ");
    }
  }
 //
  public static void insertionSort(int[] arr){
    int key,j;
    int n = arr.length;

    for(int i=1;i<n;i++){
      key = arr[i];
      j = i-1;
      while(j>=0 && arr[j]>key){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = key;
    }

  }

}
