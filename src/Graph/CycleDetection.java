package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetection {

    // TC = O(V+E)
    // SC = O(E)
    public int CycleDetection_Undirected(ArrayList<ArrayList<Integer>> adjList, int V){
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                // if (CycleDetection_Undirected_DFS(adjList,i,visited,-1) == true)
                {
                    return CycleDetection_Undirected_DFS(adjList,i,visited,-1); // initially -1 is the parent for source node
                    // return true;
                }
            }
        }
        return -1;
    }

    public int CycleDetection_Undirected_DFS(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited, int parent){
        visited[s] = true;
        // System.out.println(s);
        for(int v: adjList.get(s)){
            if(!visited[v]){
                //if (CycleDetection_Undirected_DFS(adjList,v,visited,s) == true)
                {
                    // s is the parent for all v in each iteration
                    // if any recursive call returns true then we have to return true for overall graph
                    return CycleDetection_Undirected_DFS(adjList,v,visited,s);
                    // return v;
                }
            }else if(v != parent){
                // if adj visited node is not the parent of s, then we have a cycle
                return v;
            }
        }
        return -1;
    }

    public boolean CycleDetection_Directed(ArrayList<ArrayList<Integer>> adjList, int V){
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V]; // maintain recursionStack array to check which vertices are there in the recursion call stack.

        for(int i=0;i<V;i++){
            if(!visited[i]){
                    if(CycleDetection_Directed_DFS(adjList,i,visited,recursionStack) == true){
                         return true;
                    }
            }
        }
        return false;
    }

    public boolean CycleDetection_Directed_DFS(ArrayList<ArrayList<Integer>> adjList, int u, boolean[] visited, boolean[] recursionStack){
        visited[u] = true;
        recursionStack[u] = true; // u is present to recursion stack

        for(int v: adjList.get(u)){
            if(!visited[v]){
                return CycleDetection_Directed_DFS(adjList,v,visited,recursionStack);
            }else if(recursionStack[v] == true){
                return true; // v already exists in the recursion stack => cycle exists
            }
        }
        recursionStack[u] = false; // after all adjacent vertices of u have been processed in the loop, we remove it from recursionStack array
        return false;
    }

    public boolean CycleDetection_Directed_BFS_Kahn(ArrayList<ArrayList<Integer>> adjList, int V){
        int[] indegree = new int[V];
        // populate indegree array
        for(int i=0;i<V;i++){
            for(int v: adjList.get(i)){
                indegree[v]++; // each adjacent node v will have i-v as incoming edge;
            }
        }
//        for(int v: indegree){
//            System.out.print(v + " ");
//        }
        Queue<Integer> que = new LinkedList<>();
        // add nodes with indegree 0 to queue
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        int count = 0;
        while(!que.isEmpty()){
            int u = que.poll();
            count++; // keep count of visited nodes

            for(int v: adjList.get(u)){
                indegree[v]--; // reduce indegree of adjacent nodes by 1
                if(indegree[v] == 0){
                    que.offer(v); // if indegree becomes 0 add the node to queue
                }
            }
        }
        if(count != V) return true; // if we break out of loop before visiting all nodes, there is a cycle
        else return false; // if we visit all nodes, there is no cycle

    }
}
