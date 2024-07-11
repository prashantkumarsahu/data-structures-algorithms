//package Graph;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//class Graph{
//    static int V = 9; // Graph should contain num of vertices
//    private ArrayList<ArrayList<Pair>> adjList; //
//
//    static class Pair{
//        int dest;
//        int weight;
//        Pair(int d, int w){
//            this.dest = d;
//            this.weight = w;
//        }
//    }
//    Graph(int V){
//        this.V = V;
//        adjList = new ArrayList<>();
//        for(int i=0;i<V;i++){
//            adjList.add(new ArrayList<>());
//        }
//    }
//    void addEdge(int u, int v, int w){
//        adjList.get(u).add(new Pair(v,w));
//        adjList.get(v).add(new Pair(u,w));
//    }
//
////    public void shortestPath_Dijsktra(int src){
////        PriorityQueue<Pair> pq = new PriorityQueue<>(V, (x,y) -> x.);
////        int[] dist = new int[V];
////        Arrays.fill(dist,Integer.MAX_VALUE);
////        pq.add(new Pair(0,src));
////        dist[src] = 0;
////
////        while(!pq.isEmpty()){
////            int u = pq.poll().
////        }
////    }
//
//}
//
//public class ShortestPath {
//
//
//    public void shortestPath_FloydWarshall(){}
//
//    public void shortestPath_BellmanFord(){}
//
//    public static void main(String[] args) {
//        Graph g = new Graph(V);
//        g.addEdge(0, 1, 4);
//        g.addEdge(0, 7, 8);
//        g.addEdge(1, 2, 8);
//        g.addEdge(1, 7, 11);
//        g.addEdge(2, 3, 7);
//        g.addEdge(2, 8, 2);
//        g.addEdge(2, 5, 4);
//        g.addEdge(3, 4, 9);
//        g.addEdge(3, 5, 14);
//        g.addEdge(4, 5, 10);
//        g.addEdge(5, 6, 2);
//        g.addEdge(6, 7, 1);
//        g.addEdge(6, 8, 6);
//        g.addEdge(7, 8, 7);
//
//    //    g.shortestPath_Dijsktra(0);
//    }
//}
