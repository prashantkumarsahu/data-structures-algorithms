package Algorithms.PatternMatching;


public  class PatternMatching_KMP
{
  //Function to locate the occurrence of the string x in the string s.

  public static void main(String[] args) {
    String s = "GeeksForGeeks";
    String x = "For";

//    Time Complexity : O(n)
//    Space Complexity :O(m)

    int res = strstrKMP(s,x);

    System.out.println(res);
  }

  public static int strstrKMP(String s, String x) {

    int m = x.length();
    int n = s.length();

    if (n < m)
      return -1;

    // PREPROCESSING
    // longest_border array
    int[] longest_border = new int[m];
    // Length of Longest Border for prefix before it.
    int prev = 0;
    // Iterating from index-1. longest_border[0] will always be 0
    int i = 1;

    while (i < m) {
      if (x.charAt(i) == x.charAt(prev)) {
        // Length of Longest Border Increased
        prev += 1;
        longest_border[i] = prev;
        i += 1;
      } else {
        // Only empty border exist
        if (prev == 0) {
          longest_border[i] = 0;
          i += 1;
        }
        // Try finding longest border for this i with reduced prev
        else {
          prev = longest_border[prev - 1];
        }
      }
    }

    int s_Pointer = 0;
    int x_Pointer = 0;

    while (s_Pointer < n) {
      if (s.charAt(s_Pointer) == x.charAt(x_Pointer)) {
        // Matched Increment Both
        x_Pointer += 1;
        s_Pointer += 1;
        // All characters matched
        if (x_Pointer == m) {
          // m characters behind last matching will be start of window
          return s_Pointer - m;
        }
      } else {
        if (x_Pointer == 0) {
          // Zero Matched
          s_Pointer += 1;
        } else {

          x_Pointer = longest_border[x_Pointer - 1];
        }
      }
    }

    return -1;
  }

}