package Graph;

import java.util.ArrayList;

public class Transpose {

    public void printTranspose(ArrayList<ArrayList<Integer>> adjList, int V){

        ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();

        for(int u=0;u<V;u++){
            for(int v: adjList.get(u)){
                // for each edge u-v in original graph, add edge v-u in transpose graph.
                transpose.get(v).add(u);
            }
        }
        DFS dfsObj = new DFS();
        dfsObj.DFS(transpose,V);
    }
}
