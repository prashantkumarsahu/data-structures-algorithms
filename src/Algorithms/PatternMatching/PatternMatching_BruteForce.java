package Algorithms.PatternMatching;

public class PatternMatching_BruteForce {

  public static int MOD = 100000007;
  public static int RADIX = 26;
  public static void main(String[] args) {

    // Check whether x exists in s as a substring
    String s = "GeeksForGeeks";
    String x = "For";

    int res = 0;

    // strstrBruteForce(s, x);

    // PatternMatching_KMP Algo


    System.out.println(res);
  }

  static int strstrBruteForce(String s, String x)
  {
    // Your code here
    // Approach 1: Brute Force
    // char by char match
    // match first char of x with first char of s
    // if match, match 2nd of both; else match 2nd of s with first of x

    // TC = O(lenS*lenX) SC = lenS
    // Optimized = Rabin Karp and PatternMatching_KMP
    int lenS = s.length();
    int lenX = x.length();

    for(int i=0;i<lenS;i++){
      int k=i;
      for(int j=0;j<lenX;j++){
        if(k<lenS && s.charAt(k) == x.charAt(j)){
          k++;
        }else{
          break;
        }
      }
      if(k-i == lenX){
        return i;
      }
    }
    return -1;
  }


}




