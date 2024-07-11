package Graph;

import java.util.*;

public class ShortestPathLength {

    public void findShortestPathLength_BFS(ArrayList<ArrayList<Integer>> adjList, int s, int V){
        Queue<Integer> que = new LinkedList<>();
        int[] distance = new int[V];
        for(int i=0;i<V;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[V];
        que.add(s);
        visited[s] = true;
        distance[s] = 0;

        while(!que.isEmpty()){
            int u = que.poll();

            for(int v: adjList.get(u)){
                if(!visited[v]){
                                                    // DP based solution.
                    distance[v] = distance[u] + 1; // shortest path of vertex v from u is based on the subproblem distance[u]
                    visited[v] = true;
                    que.offer(v);
                }
            }
        }
        for(int v: distance){
            System.out.print(v + " ");
        }
    }

    public void shortestPath_TopologicalSort(ArrayList<ArrayList<Integer>> adjList, int s, int V){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        List<Integer> topologicalSort = new ArrayList<>(V);
        int[] distance = new int[V];
        // List<Integer> shortestPath = new ArrayList<>(V);
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0;i<V;i++){
            if(!visited[i]){
                shortestPath_TopologicalSort_Rec(adjList,i,visited, stack);
            }
        }
        while(!stack.isEmpty()){
            topologicalSort.add(stack.pop());
        }

        for(int u: topologicalSort){
            for(int v: adjList.get(u)){
                if(distance[v] > distance[u] + adjList.get(u).get(v)){
                    distance[v] = distance[u] + adjList.get(u).get(v);
                }
            }
        }
    }

    public void shortestPath_TopologicalSort_Rec(ArrayList<ArrayList<Integer>> adjList, int u, boolean[] visited, Stack<Integer> stack){
        visited[u] = true;
      //  System.out.print(u + " ");
        for(int v: adjList.get(u)){
            if(!visited[v]){
                shortestPath_TopologicalSort_Rec(adjList,v,visited,stack);
            }
        }
        stack.push(u);
    }


}
