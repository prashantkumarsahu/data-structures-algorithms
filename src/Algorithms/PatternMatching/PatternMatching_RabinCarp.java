package Algorithms.PatternMatching;



public class PatternMatching_RabinCarp
{
  //Function to locate the occurrence of the string x in the string s.
  public static void main(String[] args) {

    String s = "GeeksForGeeks";
    String x = "Fr";

    // TC = O(lenS + lenX)
    // m = lenX
    // n = lenS
    // HV needle = O(lenX)
    // check for lenS - lenX + 1 times
    // O(1) work lenS-lenX times
    // O(lenX) work 1 time
    // TC = O(m+(n−m)⋅1+(1)⋅m), which is O(n+m)

    int res = strstrRabinCarp(s,x);
    System.out.println(res);
  }

  public static int MOD = 100000007;
  public static int RADIX = 26;
  static int strstrRabinCarp(String s, String x){

    // HashValue helper method
    // Radix is length of english alphabet
    // Calculate hash value of s - the haystack
    int lenS = s.length();
    int lenX = x.length();
    long MAX_WEIGHT = 1;
    for (int i = 0; i < lenX; i++)
      MAX_WEIGHT = (MAX_WEIGHT * RADIX) % MOD;


    // Calculate hash value of x - the needle
    long hV_Needle = hashValueRabinCarp(x,RADIX,x.length());
    long hV_Window = 0;

    for(int windowStart = 0; windowStart <= lenS-lenX; windowStart++){
      // calculate HashValue of first window of length lenX in haystack s
      if(windowStart == 0){
        hV_Window = hashValueRabinCarp(s,RADIX,lenX);
      }else{
        // calculate hashValue of next window using hashValue of previous window;
        hV_Window = ((hV_Window * RADIX) % MOD - ((s.charAt(windowStart - 1) - 'a') * MAX_WEIGHT) % MOD
            + (s.charAt(windowStart + lenX - 1) - 'a') + MOD) % MOD;
      }

      // If the hash matches, Check Character by Character.
      // compare window with needle
      if(hV_Needle == hV_Window){
        for(int i=0;i<lenX;i++){
          if(x.charAt(i) != s.charAt(i+windowStart)){
            break;
          }
          if(i == lenX-1){
            // all chars of window have matched with needle
            return windowStart; //
          }
        }
      }
    }
    return -1;
  }

  static int hashValueRabinCarp(String str, int Radix, int len){
    int ans = 0;
    long factor = 1;

    for(int i=len-1; i>=0;i--){
      ans += ((str.charAt(i) -'a')*factor)%MOD;
      factor = (factor*Radix)%MOD;
    }
    return ans%MOD;
  }
}
