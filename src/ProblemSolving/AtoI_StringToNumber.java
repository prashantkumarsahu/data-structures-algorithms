package ProblemSolving;

public class AtoI_StringToNumber {

  public static void main(String[] args) {

    String str = "56";
    System.out.println(atoi_2(str));
  }

  public static int atoi_1(String str){
    // traverse string from end to start: make it integer and multiply by 10
    // edge cases = negative numbers
    // TC = O(len)

    int len = str.length();
    int count = 0;
    int res=0;
    int currCharVal;
    boolean negative = false;

    // traverse from end to start
    for(int i=len-1; i>=0;i--){
      currCharVal = str.charAt(i) - '0'; // 48-57

      if(currCharVal >= 0 && currCharVal <= 9){
        // process only numbers
        res = res + (int)Math.pow(10,count)*currCharVal;
        count++;
      }else if(str.charAt(i) == '-' && i==0){
        // if '-' sign is there at the front of string
        negative = true;
      }
      else{
        return -1;
      }

    }
    if(negative){
      res *= -1;
    }
    return res;
  }

  public static int atoi_2(String str){
    int len = str.length();
    int res=0;
    int currCharVal;
    boolean negative = false;

    // Traverse from start to end
    for(int i=0; i<len;i++){
      currCharVal = str.charAt(i) - '0'; // 48-57
      if(currCharVal >= 0 && currCharVal <= 9){
        // process only numbers
        // Traverse from start to end
        res = res*10 + currCharVal; // ************

      }else if(str.charAt(i) == '-' && i==0){
        // if '-' sign is there at the front of string
        negative = true;
      }
      else{
        return -1;
      }
    }
    if(negative){
      res*=-1;
    }
    return res;
  }

}
