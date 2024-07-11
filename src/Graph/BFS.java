package Graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public static void BFS(ArrayList<ArrayList<Integer>> adjList){
        int V = 4;
        boolean[] visited = new boolean[V]; // init as false by default in Java
        int connectedComp = 0;
        for(int i=0;i<V;i++){
            if(!visited[i]){
                BFSTraversal(adjList, i, visited);
                connectedComp++;
            }
        }
        System.out.println("Connected Components = " + connectedComp);
    }
    public static void BFSTraversal(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(s);
        visited[s] = true;

        while(!que.isEmpty()){
            int u = que.poll();
            System.out.println(u); // print after polling..

            for(int v: adjList.get(u)){
                if(!visited[v]){
                    // System.out.print(adjList.get(currVert).get(i));
                    visited[v] = true;
                    que.offer(v);
                }
            }
        }
    }
}
