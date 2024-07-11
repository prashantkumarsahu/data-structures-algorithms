package Graph;
import java.util.*;


class Graph {
    private int V;
    private List<List<iPair>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new iPair(v, w));
        adj.get(v).add(new iPair(u, w));
    }

    void shortestPath(int src) {
        // basically min heap is to be ordered as per distance values in pair
        PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new iPair(0, src)); // add Pair(distance[s], node)
        dist[src] = 0;

        while (!pq.isEmpty()) {
            // pq.poll() would pick Pair having min distance value in the PQ.
            int u = pq.poll().second; // second in Priority Queue Pair, u, is the node itself

            for (iPair v : adj.get(u)) {
                // v is from Adjacency List, so v.first = Adjacent Node itself and v.second = weight of edge
                if (dist[v.first] > dist[u] + v.second) {
                    dist[v.first] = dist[u] + v.second; // if curr distance of node v is greater, then update it to have dist[u] + weight;
                    pq.add(new iPair(dist[v.first], v.first)); // when adding to PQ, we need to add Pair(distance of node, node itself)
                    // e.g. we add (4,1) and (4,2) after processing Node 0.
                }
            }
        }

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    // this class iPair is used in 2 scenarios:
    // 1. while creating the graph = first is the other node of the edge and second is the weight of the edge
    // 2. while adding to PQ = first is the distance of the node from source, and second is the node itself
    static class iPair {
        int first, second;

        iPair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}

public class GFGDijsktra {
    public static void main(String[] args) {
        int V = 9;
        Graph g = new Graph(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }
}
