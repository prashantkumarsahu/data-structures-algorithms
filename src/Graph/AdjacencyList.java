package Graph;

import java.util.ArrayList;

public class AdjacencyList {

    static int V = 6; // 6 vertices

    public static void addEdgeUndirected(ArrayList<ArrayList<Integer>> adjList, int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public static void addEdgeDirected(ArrayList<ArrayList<Integer>> adjList, int u, int v){
        adjList.get(u).add(v);
    }

    public static void printGraph(ArrayList<ArrayList<Integer>> adjList){
        for(int i=0;i<adjList.size();i++){
            for(int j=0;j<adjList.get(i).size();j++){
                System.out.println(i + "->" + adjList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(V);

        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<Integer>());
        }

//        addEdgeUndirected(adjList, 0,1);
//        addEdgeUndirected(adjList,4,1);
//       // addEdgeUndirected(adjList,1,3);
//       // addEdgeUndirected(adjList,2,3);
//       // addEdgeUndirected(adjList, 3,1);
//        addEdgeUndirected(adjList, 1,2);
//
//        addEdgeUndirected(adjList,2,3);
       // addEdgeUndirected(adjList,5,3);


        addEdgeDirected(adjList, 0,1);
        addEdgeDirected(adjList, 1,2);
        addEdgeDirected(adjList,2,3);
        addEdgeDirected(adjList,4,5);
        addEdgeDirected(adjList,0,4);
        addEdgeDirected(adjList,4,2);
        addEdgeDirected(adjList,5,3);



//        printGraph(adjList);

//        BFS bfsObj = new BFS();
//        bfsObj.BFS(adjList);

//        DFS dfsObj = new DFS();
//        dfsObj.DFS(adjList);

//        ShortestPathLength shortestPathLengthObj = new ShortestPathLength();
//        shortestPathLengthObj.shortestPath_TopologicalSort(adjList,0,V);
//        shortestPathLengthObj.findShortestPathLength_BFS(adjList,0,4);

//        CycleDetection cycleDetectionObj = new CycleDetection();
//        boolean cycleNode;
////        cycleNode = cycleDetectionObj.CycleDetection_Undirected(adjList,V);
////        cycleNode = cycleDetectionObj.CycleDetection_Directed(adjList,V);
//        cycleNode = cycleDetectionObj.CycleDetection_Directed_BFS_Kahn(adjList,V);
//
//        if(cycleNode){
//            System.out.println("Yes cycle exists at node =");
//        }else{
//            System.out.println("No cycle does not exist");
//        }

       // TopologicalSort topologicalSortObj = new TopologicalSort();

       // topologicalSortObj.TopologicalSort_Kahn_BFS(adjList,V);
       // topologicalSortObj.TopologicalSort_DFS(adjList,V);


    }
}
