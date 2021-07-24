import java.util.Arrays;

public class BellmanFord {
    public static boolean doBF(int src, Edge[] graph, int[] dist, int[] path) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        dist[src] = 0;
        for(int i = 0; i < dist.length - 1; i++) {
            for(int j = 0; j < graph.length; j++) {
                int u = graph[j].src;
                int v = graph[j].target;
                int d = graph[j].dist;
                if(dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]) {
                    dist[v] = dist[u] + d;
                    path[v] = u;
                }
            }
        }
        boolean invalidGraph = false;
        // check graph is containing negative weight cycle
        for(int i = 0; i < graph.length; i++) {
            int u = graph[i].src;
            int v = graph[i].target;
            int d = graph[i].dist;
            if(dist[u] != Integer.MAX_VALUE && dist[u] + d < dist[v]) {
                dist[v] = Integer.MIN_VALUE;
                invalidGraph = true;
            }
        }
        return invalidGraph;
    }
}

class Edge {
    int src;
    int target;
    int dist;

    public Edge(int src, int target, int dist) {
        this.src = src;
        this.target = target;
        this.dist = dist;
    }
}

