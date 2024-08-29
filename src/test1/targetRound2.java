package src.test1;

public class targetRound2 {

    public static void main(String[] args) {

        int m=3,n=3;
        char[][] mat = {{'A', 'B', 'C' ,'E'},{'S', 'F', 'C' ,'S'},{'A','D','E','E'}};

        String word = "ABCCED"; // ABA
        // f(a) -> f(b) -> f(c) .... f(d)
        // visited[]
        // SC = O(len(word))

        /*
        A B C E
        S F C S
        A D E E
         */
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(checkIfWordExists(mat,i,j,m,n, word, 0))
                {
                    System.out.println("word exists");;
                }
            }
        }
        System.out.println("word does not exist");
    }

    public static boolean checkIfWordExists(char[][] mat, int i, int j, int m, int n, String word, int index){
        if(index == word.length()){
            return true;
        }
        if(i<0 || i>=m || j<0 || j>=n || mat[i][j] != word.charAt(index)){
            return false;
        }
        char t = mat[i][j];
        mat[i][j] = '-';

        boolean res = checkIfWordExists(mat,i+1,j,m,n,word,index+1) ||
            checkIfWordExists(mat,i-1,j,m,n,word,index+1) ||
            checkIfWordExists(mat,i,j+1,m,n,word,index+1) ||
            checkIfWordExists(mat,i,j-1,m,n,word,index+1);

        mat[i][j] = t;
        return res;

    }


}
