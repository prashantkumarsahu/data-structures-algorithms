package ProblemSolving;

class Node_TS {
  int key;
  int value;

  // it shows the time at which the key is stored.
  // We will use the timeStamp to find out the
  // least recently used (LRU) node.
  long timeStamp;

  public Node_TS(int key, int value)
  {
    this.key = key;
    this.value = value;

    // currentTimeStamp from system
    this.timeStamp = System.currentTimeMillis();
  }
}

public class LRU_BruteForce {


  public static int capacity = 2;
  public static Node_TS[] arr;
  public static int currenCap = 0;
  public static void main(String[] args) {
    arr = new Node_TS[capacity];

  }

  public static int get(int key){
    // TC = O(capacity)
    for(int i=0;i<capacity;i++){
      if(arr[i].key == key){
        return arr[i].value;
      }
    }
    return -1;
  }

  public static void set(int keyArg, int valueArg){
    // O(capacity)
    if(currenCap == capacity){
      // if arr is full, we need to replace the LRU node with the incoming node;
      // find node with least timestamp, it will be the least recently used node
      long minTS = Long.MAX_VALUE;
      int indMin = 0;
      for(int i=0;i<capacity;i++){
        if(arr[i].timeStamp < minTS){
          minTS = arr[i].timeStamp;
          indMin = i; // keep track of index
        }
      }
      arr[indMin].key = keyArg;
      arr[indMin].value = valueArg;
      arr[indMin].timeStamp = System.currentTimeMillis();
    }

    // if arr is not full, add the incoming node to the end
    arr[currenCap].key = keyArg;
    arr[currenCap].value = valueArg;
    arr[currenCap].timeStamp = System.currentTimeMillis();

    currenCap++;
  }

}
