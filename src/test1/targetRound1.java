package src.test1;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

class ListNode{
    int val;
    ListNode next;
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class targetRound1 {
    public static void main(String[] args) {
        // Given 2 sorted arrays of integers, merge both arrays into a single sorted array
        // [1,2,3] [4,5,6]
        // [1,2,3,4,5,6]
        // 2 pointer
        // ans = m+n
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{1,2,3};
       // int[] res = mergeArrays(arr1, arr2);

        ques2();
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2){
        int i = 0, j=0;
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] res = new int[len1+len2];
        int k = 0; // TC = O(max(len1,len2)), SC = O(len1+len2)
        while(i<len1 && j<len2){
            if(arr1[i] <= arr2[j]){
                res[k++]= arr1[i];
                i++;
            }else{
                res[k++]= arr2[j];
                j++;
            }
        }
        while(i<len1){
            res[k++] = res[i++];
        }
        while(j<len2){
            res[k++] = res[j++];
        }
        return res;
    }

    public static void ques2(){
        /*
        You have a list of full Names like ["John Smith", "Rajesh Kumar", "Akshay Kumar", "Jaden Smith", "John Doe", "John Woo"]
        as an input. Use Java 8 to write a function to return an output Map with each surname
        as the key and the number of people having the surname as value.
        Example output { "Kumar": 2, "Smith": 2, "Doe" : 1, "Woo": 1 }

         */
        String[] namesArr = new String[]{"John Smith", "Rajesh Kumar", "Akshay Kumar", "Jaden Smith", "John Doe", "John Woo"};
        List<String> names = new ArrayList<>(Arrays.asList(namesArr));
        Map<String, Integer> res = new HashMap<>();
        names.stream().forEach((item) -> {
            String[] names1 = item.split(" ");
            res.put(names1[1], res.getOrDefault(names1[0],0)+1);
        });

        List<String> firstUpper = names.stream()
                .map((name) -> name.split(" ")[0].toUpperCase())
                //.map(String::toUpperCase)
                .collect(Collectors.toList());

        firstUpper.stream().forEach(System.out::println);

//        Map<String, Integer> hmap = names.stream().map(name -> name.split(" ")[1])
//                .collect(Collectors.groupingBy((surname) -> Collectors.counting()));

        names.stream().map(name -> name.split(" ")[1])
                .collect(Collectors.groupingBy((surname) -> Collectors.counting()));
        //
    }

    public static void ques3(ListNode head){
        /*
        Rearrange a linked list in to alternate first and last element
        input = 1-2-3-4-5-6-7-null
        output = 1-7-2-6-3-5-4-null
         */
        // reverse 2nd half
        // use 2 pointers and rearrange linkedlist
        // 1 2-3-4-7-6-5
        // 1-7
        // 1-7-2-6-3-5-4-null

        // 1-2
        // [1]
        // get count of nodes
        ListNode one = head;

        // fast and slow tech
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        count = 2*count;

        ListNode rev2ndHalf = reverseList(slow);
        slow.next = rev2ndHalf;

        ListNode first = head;
        ListNode second = rev2ndHalf;
        ListNode temp1, temp2;

        while(second != null){
            temp1 = first.next;
            temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        first.next = second;
    }

    public static ListNode reverseList(ListNode node){

        ListNode curr = node;
        ListNode prev = null;
        ListNode next = node.next;
        // 1 2-3
        // 3-2-1
        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void ques4(){
        /*
        Given a binary search tree can you update each node of the BST such that the new value of the
         node is equal to its original value plus the sum of all the values that are greater than that node in the tree.
         2
      1    3

         5
      6    3

         */
        // Tree
        // dump values in TreeSet - 1 2 3 // O(n)
        // suffix sum array = 6 5 3 // O(n)
        // update bst using suffix array = O(n)
        // TC = O(n) SC = O(n)

        // preorder traversal = root - left - right
        // root.val = root.val + sum(rst)
        //
        // inorder = right - root - left
        // right = process(right)
        // root = root + right
        // left = left + root

        /*
           2
      1       3

         5
      6    3
         */

        TreeNode root;

        // createSumBT(root);
    }

    public int createSumBT(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        int temp = createSumBT(root.right);

        root.val = root.val + temp;

        root.left.val = root.left.val + root.val;
        return root.val;
    }

    // TAP
    //
}
