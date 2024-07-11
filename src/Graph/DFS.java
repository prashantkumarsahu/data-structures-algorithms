package Graph;

import java.util.ArrayList;

public class DFS {

    public static void DFS(ArrayList<ArrayList<Integer>> adjList, int V){
        boolean[] visited = new boolean[V]; // init as false by default in Java
        int connectedComp = 0;

        DFSTraversal(adjList,1,visited); // start from 0
//        for(int i=0;i<V;i++){
//            if(!visited[i]){
//                DFSTraversal(adjList, i, visited);
//                connectedComp++;
//            }
//        }
        System.out.println("Connected Components = " + connectedComp);
    }
    public static void DFSTraversal(ArrayList<ArrayList<Integer>> adjList, int u, boolean[] visited){

        visited[u] = true;
        System.out.println(u); //print when marking visited

        for(int v: adjList.get(u)){
            if(!visited[v]){
                DFSTraversal(adjList, v, visited);
            }
        }
    }
}
