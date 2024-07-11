package ProblemSolving;

public class PermutationsString {

    public static void main(String[] args) {

        String str= "abc";
        permute(str,0);
    }

    public static void permute(String str, int i){
        if(i == str.length()){
            System.out.println(str);
            return;
        }
        for (int j = i; j < str.length(); j++) {
            str = swap(str, i, j);
            // str = swap2(str,i,j);
            permute(str, i + 1);
            // str = swap2(str,i,j);
            str = swap(str, i, j);
        }
    }
    public static void permute2(String str, int l, int r){
        if(l == r){
            System.out.println(str);
            return;
        }
        for (int i = l; i <=r; i++) {

            str = swap(str,l,r);
            permute2(str, l + 1,r);
            str = swap(str,l,r);

        }
    }

    public static String swap(String s, int i, int j){
        // need to convert string to charArray to swap
        char[] chrArr = s.toCharArray();
        char z = chrArr[i];
        chrArr[i] = chrArr[j];
        chrArr[j] = z;
        return String.valueOf(chrArr);
    }


}
