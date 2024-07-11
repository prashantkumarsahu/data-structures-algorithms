package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {

    // Topological Sort means the ordering of nodes in increasing order of their indegrees.
    // node with least dependency (indegree = 0) is printed first, and so on..

    public void TopologicalSort_Kahn_BFS(ArrayList<ArrayList<Integer>> adjList, int V){
        int[] indegree = new int[V];
        // populate indegree array
        for(int i=0;i<V;i++){
            for(int v: adjList.get(i)){
                indegree[v]++; // each adjacent node v will have i-v as incoming edge;
            }
        }
        System.out.println("Indegrees are: ");
        for(int v: indegree){
            System.out.print(v + " ");
        }
        System.out.println("******");

        Queue<Integer> que = new LinkedList<>();
        // add nodes with indegree 0 to queue
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int u = que.poll();
            System.out.println(u);

            for(int v: adjList.get(u)){
                indegree[v]--; // reduce indegree of adjacent nodes by 1
                if(indegree[v] == 0){
                    que.offer(v); // if indegree becomes 0 add the node to queue
                }
            }
        }
    }


    public void TopologicalSort_DFS(ArrayList<ArrayList<Integer>> adjList, int V){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                TopologicalSort_DFS_Rec(adjList, i,visited,stack);
            }
        }
        // after all nodes are processed, starting nodes with no dependencies would be at the top,
        // followed by nodes having them as dependencies and so on
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public void TopologicalSort_DFS_Rec(ArrayList<ArrayList<Integer>> adjList, int s, boolean[] visited, Stack<Integer> stack){
        visited[s] = true;

        for(int v: adjList.get(s)){
            if(!visited[v]){
                TopologicalSort_DFS_Rec(adjList,v,visited, stack);
            }
        }
        stack.push(s); // when node s does not have any unvisited adjacent nodes, i.e. it is the bottom layer, we push it to stack.
    }
}
