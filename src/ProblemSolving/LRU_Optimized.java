package ProblemSolving;

import java.util.HashMap;

class DLLNode {
  int key;
  int value;
  DLLNode pre;
  DLLNode next;

  public DLLNode(int key, int value)
  {
    this.key = key;
    this.value = value;
  }
}

public class LRU_Optimized {

  private HashMap<Integer, DLLNode> map;
  private int capacity, count;
  private DLLNode head, tail;

  public LRU_Optimized(int capacity)
  {
    this.capacity = capacity;
    map = new HashMap<>();
    // head and tail are dummy nodes;
    head = new DLLNode(0, 0);
    tail = new DLLNode(0, 0);
    head.next = tail;
    tail.pre = head;
    head.pre = null;
    tail.next = null;
    count = 0;
  }

  public static void main(String[] args) {

    // Initialize the Map
    LRU_Optimized cache = new LRU_Optimized(2);

    // Use Double linked list to store cache
    cache.set(1, 10);
    cache.set(2, 20);
    System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

    cache.set(3, 30);
    System.out.println("Value for the key: 2 is " + cache.get(2)); // returns -1 (not found)

    cache.set(4, 40);
    System.out.println("Value for the key: 1 is " + cache.get(1)); // returns -1 (not found)
    System.out.println("Value for the key: 3 is " + cache.get(3)); // returns 30
    System.out.println("Value for the key: 4 is " + cache.get(4)); // return 40

    // use HashMap of keys and List nodes

  }

  public void addToHead(DLLNode node)
  {
    // adds in front of head
    node.next = head.next;
    node.next.pre = node;
    node.pre = head;
    head.next = node;
  }

  public void deleteNode(DLLNode node)
  {
    node.pre.next = node.next;
    node.next.pre = node.pre;
  }

  // This method works in O(1)
  public int get(int key)
  {
    if (map.get(key) != null) {
      DLLNode node = map.get(key);
      int result = node.value;
      deleteNode(node);
      addToHead(node);
      System.out.println("Got the value : " + result
          + " for the key: " + key);
      return result;
    }
    System.out.println("Did not get any value" + " for the key: " + key);
    return -1;
  }

  // This method works in O(1)
  public void set(int key, int value)
  {
    System.out.println("Going to set the (key, " + "value) : (" + key + ", " + value + ")");

    if (map.get(key) != null) {
      // if setting a new value for the same key
      DLLNode node = map.get(key);
      node.value = value;

      // remove the node from position and make it most recent
      deleteNode(node);
      addToHead(node);
    }
    else {
      // if adding a new key to the cache
      DLLNode node = new DLLNode(key, value);
      map.put(key, node);
      // if cache has capacity, just add it to the front
      if (count < capacity) {
        count++;
        addToHead(node);
      }
      else {
        // if cache is full, remove the last entry from linked list, i.e. one before tail
        map.remove(tail.pre.key);
        // delete the last node
        deleteNode(tail.pre);
        // add new node to head next
        addToHead(node);
      }
    }
  }



}
